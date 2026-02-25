package com.jupitters.linkage.service.impl;

import com.jupitters.linkage.dto.ClickEventDTO;
import com.jupitters.linkage.dto.UrlMappingDTO;
import com.jupitters.linkage.model.UrlMapping;
import com.jupitters.linkage.model.User;
import com.jupitters.linkage.repository.UrlMappingRepository;
import com.jupitters.linkage.service.UrlMappingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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

        UrlMapping savedUrlMapping = urlMappingRepository.save(urlMapping);
        return convertUrlMappingToDtoBuilder(savedUrlMapping);
    }

    @Override
    public List<UrlMappingDTO> getUrslByUser(User user) {
        return urlMappingRepository.findByUser(user).stream()
                .map(this::convertUrlMappingToDtoBuilder)
                .toList();
    }

    @Override
    public List<ClickEventDTO> getClickEventsByDate(String shortUrl, LocalDateTime start, LocalDateTime end) {
        UrlMapping urlMapping = urlMappingRepository.findByShortUrl(shortUrl);
        if(urlMapping != null){

        }

        return List.of();
    }

    private UrlMappingDTO convertUrlMappingToDtoBuilder(UrlMapping urlMapping) {
        return UrlMappingDTO.builder()
                .id(urlMapping.getId())
                .originalUrl(urlMapping.getOriginalUrl())
                .shortUrl(urlMapping.getShortUrl())
                .clickCount(urlMapping.getClickCount())
                .createdDate(urlMapping.getCreatedDate())
                .username(urlMapping.getUser().getUsername())
                .build();
    }

    private String generateShortUrl() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz01233456789";

        Random random = new Random();
        StringBuilder  shortUrl = new StringBuilder(8);

        for(int i = 0; i < 8; i++){
            shortUrl.append(characters.charAt(random.nextInt(characters.length())));
        }

        return shortUrl.toString();
    }
}
