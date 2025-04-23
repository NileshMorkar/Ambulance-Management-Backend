package com.example.AmbulanceManagement.utils;

public class GeoUtils {

    public static double calculateDistance(String latitude1, String longitude1, String latitude2, String longitude2) {

        double lat1 = Double.parseDouble(latitude1);
        double lon1 = Double.parseDouble(longitude1);
        double lat2 = Double.parseDouble(latitude2);
        double lon2 = Double.parseDouble(longitude2);


        final int EARTH_RADIUS_KM = 6371;

        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        double a = Math.sin(dLat / 2.0) * Math.sin(dLat / 2.0) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLon / 2.0) * Math.sin(dLon / 2.0);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS_KM * c;
    }

}
