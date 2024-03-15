package com.lalo.earthquakes.earthquakes;

import java.util.Objects;

public class Earthquake {
    private String id;
    private String place;
    private double magnitude;
    private long time;
    private double longitude;

    private double latitude;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLoingitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Earthquake(String id, String place, double magnitude, long time, double loingitude, double latitude) {
        this.id = id;
        this.place = place;
        this.magnitude = magnitude;
        this.time = time;
        this.longitude = loingitude;
        this.latitude = latitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Earthquake)) return false;
        Earthquake that = (Earthquake) o;
        return Double.compare(that.getMagnitude(), getMagnitude()) == 0 && getTime() == that.getTime() && Double.compare(that.getLongitude(), getLongitude()) == 0 && Double.compare(that.getLatitude(), getLatitude()) == 0 && Objects.equals(getId(), that.getId()) && Objects.equals(getPlace(), that.getPlace());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPlace(), getMagnitude(), getTime(), getLongitude(), getLatitude());
    }
}
