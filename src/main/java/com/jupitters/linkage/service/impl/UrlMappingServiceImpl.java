package com.jupitters.linkage.service.impl;

import com.jupitters.linkage.dto.UrlMappingDTO;
import com.jupitters.linkage.model.UrlMapping;
import com.jupitters.linkage.model.User;
import com.jupitters.linkage.repository.UrlMappingRepository;
import com.jupitters.linkage.service.UrlMappingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UrlMappingServiceImpl implements UrlMappingService {
    private final UrlMappingRepository urlMappingRepository;

    @Override
    public UrlMappingDTO createShortUrl(String originalUrl, User user) {
        String shortUrl = generateShortUrl();
        UrlMapping urlMapping = new UrlMapping();
        urlMapping.setOriginalUrl(originalUrl);
        urlMapping.setShortUrl(shortUrl);
        urlMapping.setUser(user);
        urlMapping.setCreatedDate(LocalDateTime.now());

        return urlMappingRepository.save(urlMapping);
    }
}
