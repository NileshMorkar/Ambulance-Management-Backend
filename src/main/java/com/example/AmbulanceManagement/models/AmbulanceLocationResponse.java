package com.example.AmbulanceManagement.models;

import com.example.AmbulanceManagement.entity.AmbulanceEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class AmbulanceLocationResponse {

    private AmbulanceEntity ambulance;
    private Location location;
    private String distance;
    private int status;

}
