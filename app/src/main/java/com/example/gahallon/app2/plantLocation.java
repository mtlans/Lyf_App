package com.example.gahallon.app2;

import com.google.android.gms.maps.model.LatLng;

public class plantLocation {

    public int id;
    public String plantName;
    public double latitude;
    public double longitude;

    public plantLocation(){

    }
    public plantLocation(int id, String plantName, double latitude, double longitude) {
        this.id = id;
        this.plantName = plantName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
