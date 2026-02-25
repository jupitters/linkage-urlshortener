package com.jupitters.linkage.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ClickEventDTO {
    private LocalDate clickdate;
    private Long count;
}
