package de.htw.VocLearner.Controller;

import de.htw.VocLearner.persistence.UebersetzungEntity;
import de.htw.VocLearner.service.WordTranslationService;
import de.htw.VocLearner.web.TestRestController;
import de.htw.VocLearner.web.api.Wort;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.*;

import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(TestRestController.class)
public class RestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WordTranslationService wordTranslationService;

    @Test
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
}
