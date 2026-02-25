package com.jupitters.linkage.controller;

import com.jupitters.linkage.dto.ClickEventDTO;
import com.jupitters.linkage.dto.UrlMappingDTO;
import com.jupitters.linkage.model.User;
import com.jupitters.linkage.repository.UserRepository;
import com.jupitters.linkage.service.UrlMappingService;
import com.jupitters.linkage.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/urls")
public class UrlMappingController {
    private final UrlMappingService urlMappingService;
    private final UserService userService;
    private final UserRepository userRepository;

    @PostMapping("/shorten")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<UrlMappingDTO> createShortUrl(@RequestBody Map<String, String> request, Principal principal){
        String originalUrl = request.get("originalUrl");
        User user = userService.findByUsername(principal.getName());
        UrlMappingDTO shortUrl = urlMappingService.createShortUrl(originalUrl, user);

        return ResponseEntity.ok(shortUrl);
    }

    @PostMapping("/my-urls")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<UrlMappingDTO>> getUserUrls(Principal principal){
        User user = userService.findByUsername(principal.getName());
        List<UrlMappingDTO> urls = urlMappingService.getUrslByUser(user);
        return ResponseEntity.ok(urls);
    }

    public ResponseEntity<List<ClickEventDTO>> getUrlAnalytics(@PathVariable String shortUrl,
                                                               @RequestParam("startDate") String startDate,
                                                               @RequestParam("endDate") String endDate){
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime start = LocalDateTime.parse(startDate, formatter);
        LocalDateTime end = LocalDateTime.parse(endDate, formatter);

        List<ClickEventDTO> clickEvents = urlMappingService.getClickEventsByDate(shortUrl, start, end);
    }
}
