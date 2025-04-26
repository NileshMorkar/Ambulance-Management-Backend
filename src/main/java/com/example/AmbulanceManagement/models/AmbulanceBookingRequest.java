package com.example.AmbulanceManagement.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AmbulanceBookingRequest {
    private String ambulanceId;
    private String userId;
    private String userName;
    private String userEmail;
    private String userPhoneNum;
}
