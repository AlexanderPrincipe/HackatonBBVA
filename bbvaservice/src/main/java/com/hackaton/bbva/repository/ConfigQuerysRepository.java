package com.hackaton.bbva.repository;

import com.hackaton.bbva.model.entity.ConfigQuerys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConfigQuerysRepository extends JpaRepository<ConfigQuerys, Long> {
    Optional<ConfigQuerys> findConfigQuerysByCode(String code);
}
