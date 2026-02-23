package com.jupitters.linkage.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UrlMappingDTO {
    private Long id;
    private String originalUrl;
    private String shortUrl;
    private int clickCount;
    private LocalDateTime createdDate;
    private String username;
}
