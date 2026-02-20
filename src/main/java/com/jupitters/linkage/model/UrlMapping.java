package com.jupitters.linkage.model;

import java.time.LocalDateTime;

public class UrlMapping {
    private Long id;
    private String originalUrl;
    private String shortUrl;
    private int clickCount = 0;
    private LocalDateTime createdDate;
}
