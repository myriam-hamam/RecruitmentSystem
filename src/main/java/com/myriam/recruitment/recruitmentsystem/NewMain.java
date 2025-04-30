package com.myriam.recruitment.recruitmentsystem;

import java.util.Scanner;

public class NewMain {
    private static final String DATA_FILE = "recruitment_data.dat";

    public static void main(String[] args) {
        RecruitmentSystem system = RecruitmentSystem.loadFromFile(DATA_FILE);
        LoginService loginService = new LoginService(system);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n🔹 Menu:\n1. Register\n2. Login\n3. List Users\n4. Save & Exit");
            System.out.print("👉 Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Type (candidate/recruiter): ");
                    String type = scanner.nextLine();
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Password: ");
                    String password = scanner.nextLine();
                    System.out.print(type.equalsIgnoreCase("candidate") ? "Position: " : "Company: ");
                    String extra = scanner.nextLine();

                    try {
                        User user = UserFactory.createUser(type, name, email, password, extra);
                        system.addUser(user);
                    } catch (Exception e) {
                        System.out.println("❌ " + e.getMessage());
                    }
                }
                case 2 -> {
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Password: ");
                    String password = scanner.nextLine();
                    loginService.login(email, password);
                }
                case 3 -> system.listUsers();
                case 4 -> {
                    system.saveToFile(DATA_FILE);
                    System.out.println("👋 Exiting...");
                    return;
                }
                default -> System.out.println("❌ Invalid option.");
            }
        }
    }
}
