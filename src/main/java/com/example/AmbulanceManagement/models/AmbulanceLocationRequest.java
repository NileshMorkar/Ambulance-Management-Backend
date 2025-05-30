package com.example.AmbulanceManagement.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class AmbulanceLocationRequest {
    private String ambulanceId;
    private String latitude;
    private String longitude;
    private int status;
}
