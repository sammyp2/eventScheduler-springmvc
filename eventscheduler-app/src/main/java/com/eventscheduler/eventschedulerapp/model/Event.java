package com.eventscheduler.eventschedulerapp.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Integer id;

    @Column(name = "event_name")
    private String name;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "location")
    private String location;

    @Column(name = "event_capacity")
    private int eventCapacity;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    @OneToMany(mappedBy = "parentEvent")
    private List<SubEvent> subEvents = new ArrayList<>();

    // @ManyToMany(mappedBy = "registeredEvents")
    // private List<User> registeredUsers = new ArrayList<>();

    // Constructors, getters, and setters

    public Event() {
    }

    public Event(String name, String description, String location, int eventCapacity,
                 LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.eventCapacity = eventCapacity;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getEventCapacity() {
        return eventCapacity;
    }

    public void setEventCapacity(int eventCapacity) {
        this.eventCapacity = eventCapacity;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    // // Other Methods
    // public List<User> getRegisteredUsers() {
    //     return registeredUsers;
    // }

    // public void setRegisteredUsers(List<User> registeredUsers) {
    //     this.registeredUsers = registeredUsers;
    // }

    public List<SubEvent> getSubEvents() {
        return subEvents;
    }

    public void setSubEvents(List<SubEvent> subEvents) {
        this.subEvents = subEvents;
    }

    // public boolean isSoldOut() {
    //     return registeredUsers.size() >= eventCapacity;
    // }

    // public Integer getRegisteredUsersCount() {
    //     return registeredUsers.size();
    // }

}