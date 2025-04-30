package com.myriam.recruitment.recruitmentsystem;

public class Recruiter extends User {
    private String company;

    public Recruiter(String name, String email, String password, String company) {
        super(name, email, password);
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public String getDetails() {
        return "🏢 Recruiter | Name: " + name + ", Email: " + email + ", Company: " + company;
    }
}
