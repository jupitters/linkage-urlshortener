package com.jupitters.linkage.repository;

import com.jupitters.linkage.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(User username);
}
