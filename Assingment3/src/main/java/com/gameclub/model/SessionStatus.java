package com.gameclub.model;

public enum SessionStatus {
    ACTIVE,
    COMPLETED,
    CANCELED;

    public static SessionStatus fromString(String value) {
        if (value == null) return ACTIVE;
        String v = value.trim().toUpperCase();
        for (SessionStatus s : values()) {
            if (s.name().equals(v)) return s;
        }
        return ACTIVE;
    }
}
