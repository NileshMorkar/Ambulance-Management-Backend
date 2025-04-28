package com.example.AmbulanceManagement.service;

import com.example.AmbulanceManagement.entity.AmbulanceEntity;
import com.example.AmbulanceManagement.entity.AmbulanceLocationEntity;
import com.example.AmbulanceManagement.exception.GlobalException;
import com.example.AmbulanceManagement.models.AmbulanceLocationResponse;
import com.example.AmbulanceManagement.models.Location;
import com.example.AmbulanceManagement.models.request.LoginRequest;
import com.example.AmbulanceManagement.repository.AmbulanceLocationRepository;
import com.example.AmbulanceManagement.repository.AmbulanceRepository;
import com.example.AmbulanceManagement.utils.GeoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AmbulanceService {
    @Autowired
    private AmbulanceRepository ambulanceRepository;
    @Autowired
    private AmbulanceLocationRepository ambulanceLocationRepository;

    public AmbulanceEntity save(AmbulanceEntity ambulance) {
        ambulance.setStatus(1);
        return ambulanceRepository.save(ambulance);
    }

    public List<AmbulanceLocationResponse> getNearByAmbulances(String latitude, String longitude, String distance) {
        List<AmbulanceLocationEntity> ambulanceLocations = ambulanceLocationRepository.findAll();
        List<AmbulanceLocationResponse> ambulanceLocationResponseList = new ArrayList<>();
        int miniDistance = Integer.parseInt(distance);
        for (AmbulanceLocationEntity ambulanceLocation : ambulanceLocations) {
            double calculatedDistance = GeoUtils.calculateDistance(latitude, longitude, ambulanceLocation.getLatitude(), ambulanceLocation.getLongitude());
            if (calculatedDistance < miniDistance) {
                ambulanceLocationResponseList.add(AmbulanceLocationResponse
                        .builder()
                        .ambulance(ambulanceLocation.getAmbulance())
                        .status(ambulanceLocation.getAmbulance().getStatus())
                        .location(new Location(ambulanceLocation.getLatitude(), ambulanceLocation.getLongitude()))
                        .distance(Double.toString(calculatedDistance))
                        .build());
            }
        }

        return ambulanceLocationResponseList;
    }

    public void updateStatus(long ambulanceId, int status) {

        AmbulanceEntity ambulance = ambulanceRepository.findById(ambulanceId).orElse(null);
        assert ambulance != null;
        ambulance.setStatus(status);
        ambulanceRepository.save(ambulance);
    }


    public AmbulanceLocationEntity updateLocation(Long ambulanceId, String latitude, String longitude) {

        AmbulanceEntity ambulance = ambulanceRepository.findById(ambulanceId).orElse(null);
        AmbulanceLocationEntity ambulanceLocation = ambulanceLocationRepository.findByAmbulance(ambulance).orElse(null);
        if (ambulanceLocation == null) {
            ambulanceLocation = new AmbulanceLocationEntity();
            ambulanceLocation.setAmbulance(ambulance);
        }
        ambulanceLocation.setLatitude(latitude);
        ambulanceLocation.setLongitude(longitude);

        return ambulanceLocationRepository.save(ambulanceLocation);
    }

    public List<AmbulanceLocationEntity> getAllAmbulances() {
        return ambulanceLocationRepository.findAll();
    }

    public AmbulanceEntity getAmbulanceById(long id) {
        return ambulanceRepository.findById(id).orElse(null);
    }

    public long login(LoginRequest loginRequest) throws GlobalException {
        AmbulanceEntity ambulance = ambulanceRepository.findByEmail(loginRequest.getEmail()).orElse(null);
        if (ambulance == null) {
            throw new GlobalException("Email Not Present!", HttpStatus.NOT_FOUND);
        }

        if (!ambulance.getPassword().equals(loginRequest.getPassword())) {
            throw new GlobalException("Password Is Wrong!", HttpStatus.BAD_REQUEST);
        }

        return ambulance.getId();
    }
}
