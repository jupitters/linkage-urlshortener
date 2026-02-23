package com.jupitters.linkage.repository;

import com.jupitters.linkage.model.UrlMapping;
import com.jupitters.linkage.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UrlMappingRepository extends JpaRepository<UrlMapping, Long> {
    UrlMapping findByShortUrl(String shortUrl);
    List<UrlMapping> findByUser(User user);
}
