package com.example.AmbulanceManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ambulances")
public class AmbulanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String phoneNumber;
    private String ambulanceNumber;
    private String licenceNumber;
    private String ambulanceType;

    private String hospitalId;
    private String hospitalName;
    private String hospitalAddress;

    @Column(unique = true)
    private String email;
    private String password;
}
