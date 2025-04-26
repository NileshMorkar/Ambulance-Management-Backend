package com.example.AmbulanceManagement.repository;

import com.example.AmbulanceManagement.entity.AmbulanceBookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AmbulanceBookingRepository extends JpaRepository<AmbulanceBookingEntity, Long> {


    public List<AmbulanceBookingEntity> findAllByUserId(String userId);

    public List<AmbulanceBookingEntity> findAllByAmbulanceId(long userId);

}
