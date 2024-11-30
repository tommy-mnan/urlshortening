package com.test.urlshortening.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class BefURL {
    @JsonProperty("full_url")
    @NotEmpty(message = "full_url can't be empty or null")
    @Pattern(regexp="(https?:\\/\\/.*)", message="Invalid URL!")
    private String fullURL;

    public String getFullURL() {
        return fullURL;
    }

    public void setFullURL(String fullURL) {
        this.fullURL = fullURL;
    }
}
