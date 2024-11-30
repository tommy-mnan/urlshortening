package com.test.urlshortening.repository;

import com.test.urlshortening.entity.URL;
import org.springframework.data.repository.CrudRepository;


public interface URLRepository extends CrudRepository<URL, Long> {
}
