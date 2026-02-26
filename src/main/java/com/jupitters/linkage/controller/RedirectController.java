package com.jupitters.linkage.controller;

import com.jupitters.linkage.model.UrlMapping;
import com.jupitters.linkage.service.UrlMappingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RedirectController {
    private final UrlMappingService urlMappingService;

    public ResponseEntity<> redirect(@PathVariable String shortUrl){
        UrlMapping urlMapping = urlMappingService.getOriginalUrl(shortUrl);

    }
 }
