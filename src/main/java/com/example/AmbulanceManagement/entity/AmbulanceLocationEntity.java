package com.example.AmbulanceManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ambulance_location")
public class AmbulanceLocationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "ambulance_id", referencedColumnName = "id")
    private AmbulanceEntity ambulance;

    private String latitude;
    private String longitude;
}
