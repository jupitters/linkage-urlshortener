package com.jupitters.linkage.service;

import com.jupitters.linkage.dto.ClickEventDTO;
import com.jupitters.linkage.dto.UrlMappingDTO;
import com.jupitters.linkage.model.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface UrlMappingService {
    UrlMappingDTO createShortUrl(String originalUrl, User user);

    List<UrlMappingDTO> getUrlsByUser(User user);

    List<ClickEventDTO> getClickEventsByDate(String shortUrl, LocalDateTime start, LocalDateTime end);

    Map<LocalDate, Long> getTotalClicksByUserAndDate(User user, LocalDate start, LocalDate end);
}
