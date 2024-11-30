package com.test.urlshortening.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.test.urlshortening.entity.URL;

public class AftURL {
    @JsonProperty("full_url")
    private String fullURL;

    @JsonProperty("short_url")
    private String shortURL;

    public AftURL(URL url) {
        this.fullURL = url.getFullURL();
        this.shortURL = url.getShortURL();
    }

    public String getFullURL() {
        return fullURL;
    }

    public void setFullURL(String fullURL) {
        this.fullURL = fullURL;
    }

    public String getShortURL() {
        return shortURL;
    }

    public void setShortURL(String shortURL) {
        this.shortURL = shortURL;
    }
}
