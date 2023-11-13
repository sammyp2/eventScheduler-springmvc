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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "subevents")
public class SubEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subevent_id")
    private Integer id;

    @Column(name = "sub_event_name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String eventDescription;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "sub_event_capacity")
    private int eventCapacity;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "start_time", nullable = false)
    private LocalTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalTime endTime;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event parentEvent;

    @ManyToMany(mappedBy = "registeredSubEvents")
    private List<User> registeredUsers = new ArrayList<>();

    // Constructors, getters, setters, and other methods

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

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventLocation() {
        return location;
    }

    public void setEventLocation(String location) {
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

    public Event getParentEvent() {
        return parentEvent;
    }

    public void setParentEvent(Event parentEvent) {
        this.parentEvent = parentEvent;
    }

    public boolean isSoldOut() {
        return registeredUsers.size() >= eventCapacity;
    }

    public Integer getRegisteredUsersCount() {
        return registeredUsers.size();
    }

    public List<User> getRegisteredUsers() {
        return registeredUsers;
    }

    public void setRegisteredUsers(List<User> registeredUsers) {
        this.registeredUsers = registeredUsers;
    }

}