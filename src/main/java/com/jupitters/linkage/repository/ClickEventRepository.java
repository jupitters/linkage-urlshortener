package com.jupitters.linkage.repository;

import com.jupitters.linkage.model.ClickEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClickEventRepository extends JpaRepository<ClickEvent, Long> {
}
