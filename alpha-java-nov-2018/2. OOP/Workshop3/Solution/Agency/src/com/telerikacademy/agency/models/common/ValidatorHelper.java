package com.telerikacademy.agency.models.common;

public class ValidatorHelper {
    public static void validateInterval(int start, int end, int value, String errorMessage) {
        if (value < start || value > end) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}