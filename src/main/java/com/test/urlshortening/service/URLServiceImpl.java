package com.test.urlshortening.service;

import com.test.urlshortening.entity.URL;
import com.test.urlshortening.repository.URLRepository;
import com.test.urlshortening.util.ShorteningUtil;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class URLServiceImpl implements URLService{
    private static final Logger LOGGER = LoggerFactory.getLogger(URLServiceImpl.class);

    @Autowired
    private URLRepository urlRepository;
    public String getShortUrl(String fullUrl) {
        URL nURL = new URL();
        nURL.setUrl(fullUrl);
        LOGGER.debug("Before save Check on new URL id : {}",nURL.getId());
        urlRepository.save(nURL);
        String shortUrlText = ShorteningUtil.idToStr(nURL.getId());
        LOGGER.debug("Check on new URL id : {}",nURL.getId());
        return shortUrlText;
    }
}
