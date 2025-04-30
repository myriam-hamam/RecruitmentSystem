package com.myriam.recruitment.recruitmentsystem;

public class Validator {
    public static boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".com");
    }

    public static boolean isValidPosition(String position) {
        return position != null && position.length() > 2;
    }

    public static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty();
    }
}
