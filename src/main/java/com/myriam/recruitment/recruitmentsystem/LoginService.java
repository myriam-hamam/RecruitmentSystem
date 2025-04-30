package com.myriam.recruitment.recruitmentsystem;

public class LoginService {
    private final RecruitmentSystem system;

    public LoginService(RecruitmentSystem system) {
        this.system = system;
    }

    public User login(String email, String password) {
        for (User user : system.getAllUsers()) {
            if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)) {
                System.out.println("✅ Login successful.");
                return user;
            }
        }
        System.out.println("❌ Invalid credentials.");
        return null;
    }
}
