package com.test.urlshortening.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.urlshortening.UrlshorteningApplication;
import com.test.urlshortening.dto.BefURL;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UrlshorteningApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class URLControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void givenBefURLReturnStatusOK() throws Exception {
        BefURL befURL = new BefURL();
        befURL.setFullURL("https://test.com");

        mvc.perform(post("/shorten")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objToJsonString(befURL)))
                .andExpect(status().isOk());
    }

    @Test
    public void givenEmptyBefURLReturnStatusBadRequest() throws Exception {
        BefURL befURL = new BefURL();

        mvc.perform(post("/shorten")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objToJsonString(befURL)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void givenBefURLReturnShortURL() throws Exception {
        BefURL befURL = new BefURL();
        befURL.setFullURL("https://test.com");

        mvc.perform(post("/shorten")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objToJsonString(befURL)).header("host","example.com"))
                .andExpect(status().isOk())
                        .andExpect(jsonPath("$.data.short_url").value("example.com/VBS5"));
    }

    @Test
    public void givenShortURLReturnOK() throws Exception {
        mvc.perform(get("/VBS5"))
                .andExpect(status().isFound());
    }


    public static String objToJsonString(final Object obj) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(obj);
    }


}
