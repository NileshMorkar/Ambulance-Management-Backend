package com.example.AmbulanceManagement.controller;

import com.example.AmbulanceManagement.models.AmbulanceBookingRequest;
import com.example.AmbulanceManagement.models.AmbulanceBookingResponse;
import com.example.AmbulanceManagement.models.ApiResponseMessage;
import com.example.AmbulanceManagement.service.AmbulanceBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ambulance/booking")
public class AmbulanceBookingController {

    @Autowired
    private AmbulanceBookingService ambulanceBookingService;

    @PostMapping
    public ResponseEntity<ApiResponseMessage> bookAmbulance(@RequestBody AmbulanceBookingRequest ambulanceBookingRequest) {

        try {
            ambulanceBookingService.bookAmbulance(ambulanceBookingRequest);
            return ResponseEntity.ok().body(new ApiResponseMessage("Ambulance Booked Successfully!", HttpStatus.CREATED));
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(new ApiResponseMessage(exception.getMessage(), HttpStatus.BAD_REQUEST));
        }

    }

    @GetMapping("/driver")
    public ResponseEntity<List<AmbulanceBookingResponse>> getAmbulancesBookingHistoryOfDriver(@RequestParam String ambulanceId) {
        return ResponseEntity.ok().body(ambulanceBookingService.getAmbulancesBookingHistoryOfDriver(ambulanceId));
    }

    @GetMapping("/user")
    public ResponseEntity<List<AmbulanceBookingResponse>> getAmbulancesBookedByUser(@RequestParam String userUd) {
        return ResponseEntity.ok().body(ambulanceBookingService.getAmbulancesBookedByUser(userUd));
    }


}
