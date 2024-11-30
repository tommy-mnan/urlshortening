package com.test.urlshortening.controller;

import com.test.urlshortening.service.URLService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class URLController {

    @Autowired
    private URLService urlService;

    @PostMapping("/shorten")
    public String saveUrl(@RequestBody String fullUrl, HttpServletRequest request) {
        return urlService.getShortUrl(fullUrl);
    }
}
