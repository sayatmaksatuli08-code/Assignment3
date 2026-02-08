package com.gameclub.util;

public class Validator {

    public static boolean isValidPhone(String phone) {
        return phone != null && phone.matches("\\+7\\d{10}");
    }

    public static boolean isPositive(int value) {
        return value > 0;
    }
}
