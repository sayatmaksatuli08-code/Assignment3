package com.gameclub.util;

import com.gameclub.model.Role;

public class AccessControl {

    public static boolean canViewReports(Role role) {
        return role == Role.ADMIN || role == Role.MANAGER;
    }
}
