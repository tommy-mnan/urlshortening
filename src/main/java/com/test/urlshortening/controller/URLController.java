package com.test.urlshortening.controller;

import com.test.urlshortening.dto.AftURL;
import com.test.urlshortening.dto.BefURL;
import com.test.urlshortening.entity.URL;
import com.test.urlshortening.exception.URLNotFoundException;
import com.test.urlshortening.service.URLService;
import com.test.urlshortening.util.ResponseModel;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;


@RestController
public class URLController {

    @Autowired
    private URLService urlService;

    @PostMapping("/shorten")
    public ResponseEntity<ResponseModel> saveUrl(@Valid @RequestBody BefURL befURL, HttpServletRequest request) {
        Optional<URL> optional = urlService.findByFullURL(befURL.getFullURL());
        AftURL aftURL;
        if (optional.isPresent()) {
            aftURL = new AftURL(optional.get());
        }else {
            aftURL = urlService.getShortURL(befURL);
        }
            aftURL.setShortURL(request.getHeader("host") + "/" + aftURL.getShortURL());
            ResponseModel responseModel = new ResponseModel(HttpStatus.OK.value(), "Success", aftURL);
            return ResponseEntity.ok(responseModel);

    }

    @GetMapping("/{shortURL}")
    public ResponseEntity<Void> redirectToFullUrl(@PathVariable String shortURL) {
        Optional<URL> optional = urlService.findByShortURL(shortURL);
        if (optional.isPresent()) {
            //RedirectView
            return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(optional.get().getFullURL())).build();
        } else {
            throw new URLNotFoundException(shortURL);
        }
    }
}
