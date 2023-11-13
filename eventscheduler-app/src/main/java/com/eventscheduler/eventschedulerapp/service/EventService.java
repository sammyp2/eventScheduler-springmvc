package com.eventscheduler.eventschedulerapp.service;

import com.eventscheduler.eventschedulerapp.model.Event;
import com.eventscheduler.eventschedulerapp.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public Event findEventById(Integer id) throws Exception {
        Optional<Event> event = eventRepository.findById(id);
        return event.orElseThrow(() -> new Exception("Event Not Found"));
    }

    public List <Event> findEventsByLocation(String location) throws Exception {
        List <Event> eventLocation = eventRepository.findEventsByLocation(location);
        if (eventLocation.isEmpty()) {
            throw new Exception("No Event Found At This Location");
        }
        return eventLocation;
    }

    public List <Event> findEventByName(String name) throws Exception {
        List <Event> nameOfEvent = eventRepository.findEventByName(name);
        if (nameOfEvent == null) {
            throw new Exception("No Event Found By This Name");
        }
        return nameOfEvent;
    }

    public List <Event> findEventByDate(LocalDate startDate, LocalDate endDate) {
  
        return eventRepository.findEventByDate(startDate, endDate);
    }

    public List<Event> findAllEvents() {
        return eventRepository.findAll();
    }

    public Event createEvent(Event event) {
        Event newEvent = new Event();

        newEvent.setName(event.getName());
        newEvent.setDescription(event.getDescription());
        newEvent.setLocation(event.getLocation());
        newEvent.setEventCapacity(event.getEventCapacity());
        newEvent.setStartDate(event.getStartDate());
        newEvent.setEndDate(event.getEndDate());
        newEvent.setStartTime(event.getStartTime());
        newEvent.setEndTime(event.getEndTime());

        return eventRepository.save(event);
    }

    public Event updateEvent(Event event) {
        return eventRepository.save(event);
    }

    public void deleteEventById(Integer id) throws Exception {
        eventRepository.deleteById(id);
    }

    // Additional methods

    // public boolean isEventSoldOut(Integer eventId) throws Exception {
    //     Event event = findEventById(eventId);
    //     return event.isSoldOut();
    // }

    // public Integer getRegisteredUsersCount(Integer eventId) throws Exception {
    //     Event event = findEventById(eventId);
    //     return event.getRegisteredUsersCount();
    // }

}