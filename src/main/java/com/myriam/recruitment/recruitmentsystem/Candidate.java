/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myriam.recruitment.recruitmentsystem;


public class Candidate extends User {
    private String position;

    public Candidate(String name, String email, String password, String position) {
        super(name, email, password);
        this.position = position;
    }

    public String getPosition() { return position; }

    @Override
    public String getDetails() {
        return "👤 Candidate | Name: " + name + ", Email: " + email + ", Position: " + position;
    }

    @Override
    public String toString() { return getDetails(); }
}
