package com.test.urlshortening.service;

import com.test.urlshortening.dto.AftURL;
import com.test.urlshortening.dto.BefURL;
import com.test.urlshortening.entity.URL;
import com.test.urlshortening.repository.URLRepository;
import com.test.urlshortening.util.ShorteningUtil;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class URLServiceImpl implements URLService{
    private static final Logger LOGGER = LoggerFactory.getLogger(URLServiceImpl.class);

    private URLRepository urlRepository;

    public URLServiceImpl(URLRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public AftURL getShortURL(BefURL befURL) {
        URL nURL = new URL();
        nURL.setFullURL(befURL.getFullURL());
        urlRepository.save(nURL);
        nURL.setShortURL(ShorteningUtil.idToStr(nURL.getId()));
        LOGGER.debug("getShortURL check url id {}",nURL.getId());
        urlRepository.save(nURL);
        return new AftURL(nURL);
    }

    public Optional<URL> findByShortURL(String shortURL) {
        return urlRepository.findURLByShortURL(shortURL);
    }

    public Optional<URL> findByFullURL(String fullURL) {
        return urlRepository.findURLByFullURL(fullURL);
    }
}
