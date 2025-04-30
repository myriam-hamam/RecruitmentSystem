package com.myriam.recruitment.recruitmentsystem;


import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class RecruitmentSystem implements Serializable {
    private static final long serialVersionUID = 1L;
    private static RecruitmentSystem instance;

    private final Map<String, User> users;

    private RecruitmentSystem() {
        users = new HashMap<>();
    }

    public static RecruitmentSystem getInstance() {
        if (instance == null) {
            instance = loadFromFile("recruitment_data.dat");
        }
        return instance;
    }

    public void addUser(User user) {
        users.put(user.getEmail(), user);
        System.out.println("✅ User added.");
    }

    public void listUsers() {
        if (users.isEmpty()) {
            System.out.println("⚠️ No users.");
        } else {
            users.values().forEach(System.out::println);
        }
    }

    public void listUsersSortedByName() {
        users.values().stream()
                .sorted(Comparator.comparing(User::getName))
                .forEach(System.out::println);
    }

    public void filterByType(String type) {
        users.values().stream()
                .filter(u -> type.equalsIgnoreCase("candidate") && u instanceof Candidate
                        || type.equalsIgnoreCase("recruiter") && u instanceof Recruiter)
                .forEach(System.out::println);
    }

    public void search(String keyword) {
        boolean found = false;
        for (User u : users.values()) {
            if (u.getName().toLowerCase().contains(keyword.toLowerCase())
                    || u.getEmail().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("🔍 " + u);
                found = true;
            }
        }
        if (!found) System.out.println("❌ No match.");
    }

    public User login(String email, String password) {
        User user = users.get(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public void saveToFile(String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(this);
            System.out.println("💾 Data saved.");
        } catch (IOException e) {
            System.err.println("❌ Save error: " + e.getMessage());
        }
    }

    static RecruitmentSystem loadFromFile(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (RecruitmentSystem) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("⚠️ No saved data. Starting new system.");
            return new RecruitmentSystem();
        }
    }
    public Iterable<User> getAllUsers() {
    return users.values();
}

}
