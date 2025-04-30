/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myriam.recruitment.recruitmentsystem;

/**
 *
 * @author Zbook
 */
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
