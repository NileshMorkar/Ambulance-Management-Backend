package com.example.AmbulanceManagement.controller;

import com.example.AmbulanceManagement.entity.AmbulanceEntity;
import com.example.AmbulanceManagement.entity.AmbulanceLocationEntity;
import com.example.AmbulanceManagement.exception.GlobalException;
import com.example.AmbulanceManagement.models.AmbulanceLocationRequest;
import com.example.AmbulanceManagement.models.AmbulanceLocationResponse;
import com.example.AmbulanceManagement.models.request.LoginRequest;
import com.example.AmbulanceManagement.models.response.LoginResponse;
import com.example.AmbulanceManagement.service.AmbulanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ambulances")
public class AmbulanceController {


    @Autowired
    private AmbulanceService ambulanceService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) throws GlobalException {
        long id = ambulanceService.login(loginRequest);
        return ResponseEntity.ok().body(new LoginResponse(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AmbulanceEntity> getAmbulanceById(@PathVariable long id) {
        return ResponseEntity.ok(ambulanceService.getAmbulanceById(id));
    }

    @PostMapping
    public ResponseEntity<AmbulanceEntity> createAmbulance(@RequestBody AmbulanceEntity ambulance) {
        AmbulanceEntity savedAmbulance = ambulanceService.save(ambulance);
        return ResponseEntity.ok(savedAmbulance);
    }

    @PostMapping("/location/update")
    public ResponseEntity<AmbulanceLocationEntity> updateLocation(@RequestBody AmbulanceLocationRequest ambulanceLocation) {
        return ResponseEntity.status(HttpStatus.OK).body(ambulanceService.updateLocation(Long.valueOf(ambulanceLocation.getAmbulanceId()), ambulanceLocation.getLatitude(), ambulanceLocation.getLongitude()));
    }

    @GetMapping("/nearby")
    public List<AmbulanceLocationResponse> getNearByAmbulances(@RequestParam(defaultValue = "200") String distance, @RequestParam String latitude, @RequestParam String longitude) {
        return ambulanceService.getNearByAmbulances(latitude, longitude, distance);
    }

    @GetMapping("/all")
    public List<AmbulanceLocationEntity> getAllAmbulances() {
        return ambulanceService.getAllAmbulances();
    }

    @GetMapping("/status/update/{id}")
    public ResponseEntity<Void> updateStatus(@PathVariable("id") long ambulanceId, @RequestParam int status) {
        ambulanceService.updateStatus(ambulanceId, status);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
