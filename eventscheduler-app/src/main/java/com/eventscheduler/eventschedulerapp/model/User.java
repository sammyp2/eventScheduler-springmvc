package com.eventscheduler.eventschedulerapp
.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class User {
    public enum UserType {
        ADMIN,
        USER
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    
    @Column(name = "email", unique = true)
    private String email;
    
    @Column(name = "username", unique = true)
    private String username;
    
    @Column(name = "raw_password")
    private String rawPassword;
    
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
    
    private String aliasName;
    
    // Constructors, getters, setters
    
    @Enumerated(EnumType.STRING)
    @Column(name = "user_type")
    private UserType userType;
    
    @OneToMany
    @JoinColumn(name="user_Id")
    private List<Event> userEvents;
    
    // private List<Event> registeredEvents = new ArrayList<>();
    
    @ManyToMany
    @JoinTable(
        name = "user_registered_subevents",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "subevent_id")
    )
    private List<SubEvent> registeredSubEvents = new ArrayList<>();
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getRawPassword() {
        return rawPassword;
    }

    public void setRawPassword(String rawPassword) {
        this.rawPassword = rawPassword;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }
    
    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
    
    // Method to request admin status
    public void requestAdminStatus() {
        if (userType == UserType.USER) {
            // Logic to request admin status
        }
    }
    
    // Method to approve admin status
    public void approveAdminStatus() {
        if (userType == UserType.USER) {
            userType = UserType.ADMIN;
            // Logic to notify user and update status
        }
    }

    public boolean isEmail() {
        return false;
    }

    public List<SubEvent> getRegisteredSubEvents() {
        return registeredSubEvents;
    }

    public void setRegisteredSubEvents(List<SubEvent> registeredSubEvents) {
        this.registeredSubEvents = registeredSubEvents;
    }
    
    private String userInput;

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public List<Event> getUserEvents() {
        return userEvents;
    }

    public void setUserEvents(List<Event> userEvents) {
        this.userEvents = userEvents;
    }

    
}