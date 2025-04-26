package com.example.AmbulanceManagement.models;

import com.example.AmbulanceManagement.entity.AmbulanceEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AmbulanceBookingResponse {
    private String bookingDate;
    private String userId;
    private String userName;
    private String userEmail;
    private String userPhoneNum;
    private AmbulanceEntity ambulance;
}
