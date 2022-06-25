package de.htw.VocLearner.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("http://localhost:8080/api/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowedOrigins(
                        "https://voclearner-frontend.herokuapp.com",
                        "http://localhost:3000"
                );
    }



}
