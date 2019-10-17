package com.company.data;

public class Geo {
    private double lat;
    private double lng;

    public Geo() {
    }

    public Geo(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }
}
