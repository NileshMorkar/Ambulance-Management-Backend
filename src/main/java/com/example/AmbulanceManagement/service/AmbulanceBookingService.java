package com.example.AmbulanceManagement.service;

import com.example.AmbulanceManagement.entity.AmbulanceBookingEntity;
import com.example.AmbulanceManagement.models.AmbulanceBookingRequest;
import com.example.AmbulanceManagement.models.AmbulanceBookingResponse;
import com.example.AmbulanceManagement.repository.AmbulanceBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AmbulanceBookingService {

    @Autowired
    private AmbulanceService ambulanceService;
    @Autowired
    private AmbulanceBookingRepository ambulanceBookingRepository;

    public void bookAmbulance(AmbulanceBookingRequest ambulanceBookingRequest) {
        AmbulanceBookingEntity ambulanceBookingEntity = AmbulanceBookingEntity
                .builder()
                .ambulanceId(Long.parseLong(ambulanceBookingRequest.getAmbulanceId()))
                .userId(ambulanceBookingRequest.getUserId())
                .bookingDate(ZonedDateTime.now(ZoneId.of("Asia/Kolkata")))
                .userPhoneNum(ambulanceBookingRequest.getUserPhoneNum())
                .userEmail(ambulanceBookingRequest.getUserEmail())
                .userName(ambulanceBookingRequest.getUserName())
                .build();
        ambulanceBookingRepository.save(ambulanceBookingEntity);
    }

    public List<AmbulanceBookingResponse> getAmbulancesBookedByUser(String userId) {
        List<AmbulanceBookingEntity> ambulanceBookingEntityList = ambulanceBookingRepository.findAllByUserId(userId);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm a");
        return ambulanceBookingEntityList.stream().map(ambulanceBooking -> {

            return AmbulanceBookingResponse
                    .builder()
                    .userId(ambulanceBooking.getUserId())
                    .userPhoneNum(ambulanceBooking.getUserPhoneNum())
                    .userEmail(ambulanceBooking.getUserEmail())
                    .userName(ambulanceBooking.getUserName())
                    .bookingDate(dateTimeFormatter.format(ambulanceBooking.getBookingDate()))
                    .ambulance(ambulanceService.getAmbulanceById(ambulanceBooking.getAmbulanceId()))
                    .build();
        }).collect(Collectors.toList());
    }

    public List<AmbulanceBookingResponse> getAmbulancesBookingHistoryOfDriver(String ambulanceId) {
        List<AmbulanceBookingEntity> ambulanceBookingEntityList = ambulanceBookingRepository.findAllByAmbulanceId(Long.parseLong(ambulanceId));

        return ambulanceBookingEntityList.stream().map(ambulanceBooking -> {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm a");

            return AmbulanceBookingResponse
                    .builder()
                    .userId(ambulanceBooking.getUserId())
                    .userPhoneNum(ambulanceBooking.getUserPhoneNum())
                    .userEmail(ambulanceBooking.getUserEmail())
                    .userName(ambulanceBooking.getUserName())
                    .bookingDate(dateTimeFormatter.format(ambulanceBooking.getBookingDate()))
                    .ambulance(ambulanceService.getAmbulanceById(ambulanceBooking.getAmbulanceId()))
                    .build();
        }).collect(Collectors.toList());
    }
}
