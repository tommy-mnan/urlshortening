package com.test.urlshortening.repository;

import com.test.urlshortening.entity.URL;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface URLRepository extends CrudRepository<URL, Long> {
    Optional<URL> findURLByShortURL(String shortURL);
    Optional<URL> findURLByFullURL(String fullURL);

}
