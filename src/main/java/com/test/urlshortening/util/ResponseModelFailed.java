package com.test.urlshortening.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

import java.util.Date;

public class ResponseModelFailed {
    @JsonProperty("timestamp")
    private Date timeStamp;

    @JsonProperty("message")
    private String responseMessage;

    @JsonProperty("status")
    private int status;

    @JsonProperty("details")
    private Object details;

    @JsonProperty("path")
    private String path;

    public ResponseModelFailed(HttpStatus httpStatus, Object details, String path) {
        this.status = httpStatus.value();
        this.responseMessage = httpStatus.getReasonPhrase();
        this.details = details;
        this.timeStamp = new Date();
        this.path = path;
    }
}