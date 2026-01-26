package com.gameclub.model;

public enum StationStatus {
    AVAILABLE,
    IN_USE,
    MAINTENANCE;

    public static StationStatus fromString(String value) {
        if (value == null) return AVAILABLE;
        String v = value.trim().toUpperCase();
        for (StationStatus ss : values()) {
            if (ss.name().equals(v)) return ss;
        }
        return AVAILABLE;
    }
}
