package com.gameclub.model;

public enum MembershipType {
    NONE,
    STANDARD,
    PREMIUM,
    VIP;

    public static MembershipType fromString(String value) {
        if (value == null) return NONE;
        String v = value.trim().toUpperCase();
        for (MembershipType mt : values()) {
            if (mt.name().equals(v)) return mt;
        }
        return NONE;
    }
}


