package com.example.AmbulanceManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "ambulance_booking_record")
public class AmbulanceBookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long ambulanceId;

    private String userId;

    @Column(name = "booking_date")
    private ZonedDateTime bookingDate;

    private String userName;
    private String userEmail;
    private String userPhoneNum;
}
