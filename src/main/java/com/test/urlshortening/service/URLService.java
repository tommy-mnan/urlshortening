package com.test.urlshortening.service;

import com.test.urlshortening.dto.AftURL;
import com.test.urlshortening.dto.BefURL;

public interface URLService {
    AftURL getShortUrl(BefURL fullUrl);
}
