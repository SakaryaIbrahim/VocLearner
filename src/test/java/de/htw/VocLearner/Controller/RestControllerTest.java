package de.htw.VocLearner.Controller;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.htw.VocLearner.persistence.UebersetzungEntity;
import de.htw.VocLearner.service.WordTranslationService;
import de.htw.VocLearner.web.TestRestController;
import de.htw.VocLearner.web.api.Uebersetzung;
import de.htw.VocLearner.web.api.WordTranslation;
import de.htw.VocLearner.web.api.Wort;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.*;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TestRestController.class)
public class RestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WordTranslationService wordTranslationService;

    @Autowired
    ObjectMapper objectMapper;
    @Test
    @DisplayName("should read the Words from the database")
    public void testGetWords() throws Exception {
        //Test daten und service mock
        Set<UebersetzungEntity> uebersetzungEntities = new HashSet<>();
        Wort wort = new Wort(24L, "run", "english", uebersetzungEntities);
        List<Wort> allWorts = new ArrayList<>();
        allWorts.add(wort);
        when(wordTranslationService.findAll()).thenReturn(allWorts);

        String expected = "[{\"id\":24,\"bezeichnung\":\"run\",\"sprache\":\"english\",\"uebersetzungSet\":[]}]";

        this.mockMvc.perform(get("/api/v1/words"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(expected));
    }

    @Test
    @DisplayName("should add new Word with translation to database")
    public void testinsertNewValues () throws Exception {

        Set<UebersetzungEntity> uebersetzungEntities = new HashSet<>();
        Wort wort = new Wort(24L,"run","english",uebersetzungEntities);
        WordTranslation wordTranslation = new WordTranslation("rdkajkd","english","jakdjkasjdf","deutsch");
        UebersetzungEntity uebersetzungEntity = new UebersetzungEntity("jakdjkasjdf","deutsch",1);
        uebersetzungEntity.setId(15L);
        uebersetzungEntities.add(uebersetzungEntity);
        when(wordTranslationService.insertWordTranslation(wordTranslation)).thenReturn(wort);

        String expected = "[{\"id\":24,\"bezeichnung\":\"rdkajkd\",\"sprache\":\"english\",\"uebersetzungSet\":[{\"id\":15,\"uebersetzung\":\"jakdjkasjdf\",\"sprache\":\"deutsch\",\"wahrscheinlichkeit\":1}]}]";


        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api/v1/wordtranslation)")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(String.valueOf(this.objectMapper.writeValueAsString(wordTranslation)));
        this.mockMvc.perform(mockRequest)
                .andExpect(status().isNotFound());

    }


    @Test
    @DisplayName("test delete")
    void testDeleteWord () throws Exception {
        Mockito.when(wordTranslationService.deleteWordTranslation("run")).thenReturn("SUCESS");
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.delete("/api/v1/wordtranslation")
                .content(String.valueOf("run"));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("update von Wahrscheinlichkeit")
    void testUpdateWahrscheinlichkeit () throws Exception {
        Set<UebersetzungEntity> uebersetzungEntities = new HashSet<>();
        Wort wort = new Wort(24L,"run","english",uebersetzungEntities);
        WordTranslation wordTranslation = new WordTranslation("rdkajkd","english","jakdjkasjdf","deutsch");
        UebersetzungEntity uebersetzungEntity = new UebersetzungEntity("jakdjkasjdf","deutsch",1);
        uebersetzungEntity.setId(15L);
        uebersetzungEntities.add(uebersetzungEntity);

        when(wordTranslationService.updateProbability(wort)).thenReturn(wort);

        String expected = "{\"id\":12,\"uebersetzung\":\"run\",\"sprache\":\"english\",\"wahrscheinlichkeit\":0.3}";

        this.mockMvc.perform(post("/api/v1/uebersetzung")
                        .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(wort)))
                .andExpect(status().isOk());
    }

}
