package com.api.agrotis.test.repository;

import com.api.agrotis.test.entities.Amostra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AmostraRepository extends JpaRepository<Amostra, Long> {
    Optional<Amostra> findByid(Long id);
}
