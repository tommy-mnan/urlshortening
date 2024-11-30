package com.test.urlshortening.service;

import com.test.urlshortening.dto.AftURL;
import com.test.urlshortening.dto.BefURL;
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
    public AftURL getShortUrl(BefURL fullUrl) {
        URL nURL = new URL();
        nURL.setFullURL(fullUrl.getFullURL());
        urlRepository.save(nURL);

        nURL.setShortURL(ShorteningUtil.idToStr(nURL.getId()));

        AftURL aftURL = new AftURL(nURL);

        return aftURL;
    }
}
