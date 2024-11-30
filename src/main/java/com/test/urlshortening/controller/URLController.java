package com.test.urlshortening.controller;

import com.test.urlshortening.dto.AftURL;
import com.test.urlshortening.dto.BefURL;
import com.test.urlshortening.service.URLService;
import com.test.urlshortening.util.ResponseModel;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class URLController {

    @Autowired
    private URLService urlService;

    @PostMapping("/shorten")
    public ResponseEntity<ResponseModel> saveUrl(@Valid @RequestBody BefURL fullUrl, HttpServletRequest request) {
        AftURL aftURL = urlService.getShortUrl(fullUrl);
        aftURL.setShortURL(request.getHeader("host")+ "/" + aftURL.getShortURL());
        ResponseModel responseModel = new ResponseModel(HttpStatus.OK.value(), "Success", aftURL);
        return ResponseEntity.ok(responseModel);
    }
}
