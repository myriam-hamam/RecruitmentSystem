package com.myriam.recruitment.recruitmentsystem;

import java.io.Serializable;

public abstract class User implements Serializable {
    protected String name;
    protected String email;
    protected String password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }

    public abstract String getDetails();
}
