package com.test.urlshortening.service;

import com.test.urlshortening.dto.AftURL;
import com.test.urlshortening.dto.BefURL;
import com.test.urlshortening.entity.URL;

import java.util.Optional;

public interface URLService {
    AftURL getShortURL(BefURL befURL);
    Optional<URL> findByShortURL(String shortURL);
    Optional<URL> findByFullURL(String fullURL);

}
