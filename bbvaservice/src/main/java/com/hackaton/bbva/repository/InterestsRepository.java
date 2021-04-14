package com.hackaton.bbva.repository;

import com.hackaton.bbva.model.entity.Interests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestsRepository extends JpaRepository<Interests, Long> {
}