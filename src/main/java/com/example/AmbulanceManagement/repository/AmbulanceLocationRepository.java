package com.example.AmbulanceManagement.repository;

import com.example.AmbulanceManagement.entity.AmbulanceEntity;
import com.example.AmbulanceManagement.entity.AmbulanceLocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AmbulanceLocationRepository extends JpaRepository<AmbulanceLocationEntity, Long> {

    public Optional<AmbulanceLocationEntity> findByAmbulance(AmbulanceEntity ambulance);


}
