package com.example.AmbulanceManagement.repository;

import com.example.AmbulanceManagement.entity.AmbulanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AmbulanceRepository extends JpaRepository<AmbulanceEntity, Long> {
    public Optional<AmbulanceEntity> findByEmail(String email);
}
