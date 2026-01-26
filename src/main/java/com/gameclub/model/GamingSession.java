package com.gameclub.model;

import java.time.LocalDateTime;

public class GamingSession {
    private long id;
    private long customerId;
    private long stationId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Double totalCost; // can be null before end
    private SessionStatus status;

    public GamingSession() {
    }

    public GamingSession(long id, long customerId, long stationId,
                         LocalDateTime startTime, LocalDateTime endTime,
                         Double totalCost, SessionStatus status) {
        this.id = id;
        this.customerId = customerId;
        this.stationId = stationId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.totalCost = totalCost;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getStationId() {
        return stationId;
    }

    public void setStationId(long stationId) {
        this.stationId = stationId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public SessionStatus getStatus() {
        return status;
    }

    public void setStatus(SessionStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "GamingSession{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", stationId=" + stationId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", totalCost=" + totalCost +
                ", status=" + status +
                '}';
    }
}
