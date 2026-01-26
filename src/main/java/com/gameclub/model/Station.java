package com.gameclub.model;

public class Station {
    private long id;
    private String code;
    private double hourlyRate;
    private StationStatus status;

    public Station() {
    }

    public Station(long id, String code, double hourlyRate, StationStatus status) {
        this.id = id;
        this.code = code;
        this.hourlyRate = hourlyRate;
        this.status = status;
    }

    public Station(String code, double hourlyRate, StationStatus status) {
        this.code = code;
        this.hourlyRate = hourlyRate;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public StationStatus getStatus() {
        return status;
    }

    public void setStatus(StationStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", hourlyRate=" + hourlyRate +
                ", status=" + status +
                '}';
    }
}
