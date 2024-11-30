package com.test.urlshortening.exception;

public class URLNotFoundException extends RuntimeException {
    public URLNotFoundException(Object id) {
        super("URL not found with id " + id);
    }
}
