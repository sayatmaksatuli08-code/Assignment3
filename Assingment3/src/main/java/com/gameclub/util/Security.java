package com.gameclub.util;

import com.gameclub.model.Role;

public class Security {
    public static void require(Role currentRole, Role requiredRole) {
        if (currentRole.ordinal() > requiredRole.ordinal()) {
            throw new RuntimeException("Access denied for role: " + currentRole);
        }
    }
}
