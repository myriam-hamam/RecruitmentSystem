package com.myriam.recruitment.recruitmentsystem;

public class UserFactory {
    public static User createUser(String type, String name, String email, String password, String extra) {
        return switch (type.toLowerCase()) {
            case "candidate" -> new Candidate(name, email, password, extra);
            case "recruiter" -> new Recruiter(name, email, password, extra);
            default -> throw new IllegalArgumentException("❌ Invalid user type.");
        };
    }
}
