package com.jupitters.linkage.service;

import com.jupitters.linkage.dto.UrlMappingDTO;
import com.jupitters.linkage.model.User;

public interface UrlMappingService {
    UrlMappingDTO createShortUrl(String originalUrl, User user);
}
