package com.eventscheduler.eventschedulerapp.service;

import com.eventscheduler.eventschedulerapp.model.SubEvent;
import com.eventscheduler.eventschedulerapp.repository.SubEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SubEventService {

    @Autowired
    private SubEventRepository subEventRepository;

    public SubEvent findSubEventById(Integer id) throws Exception {
        Optional<SubEvent> subEvent = subEventRepository.findById(id);
        return subEvent.orElseThrow(() -> new Exception("Sub Event Not Found"));
    }

    public SubEvent findSubEventByName(String name) throws Exception {
        SubEvent subEventName = subEventRepository.findSubEventByName(name);

        if (subEventName == null) {
            throw new Exception("No Sub Event Found By This Name");
        }

        return subEventName;
    }

    public SubEvent findSubEventByLocation(String location) throws Exception {
        SubEvent subEventLocation = subEventRepository.findSubEventByLocation(location);

        if (subEventLocation == null) {
            throw new Exception("No Sub Event Found At This Location");
        }

        return subEventLocation;
    }

    public List<SubEvent> findSubEventByDate(LocalDate startDate, LocalDate endDate) {
        
        return subEventRepository.findSubEventByDate(startDate, endDate);
    }

    public List<SubEvent> findAllSubEvents() {
        return subEventRepository.findAll();
    }

    public SubEvent createSubEvent(SubEvent subEvent) {
        return subEventRepository.save(subEvent);
    }

    public SubEvent updateSubEvent(SubEvent subEvent) {
        return subEventRepository.save(subEvent);
    }

    public void deleteSubEventById(Integer id) throws Exception {
        subEventRepository.deleteById(id);
    }

    // Additional methods

    public boolean isSubEventSoldOut(Integer subEventId) throws Exception {
        SubEvent subEvent = findSubEventById(subEventId);
        return subEvent.isSoldOut();
    }

    public Integer getRegisteredUsersCount(Integer subEventId) throws Exception {
        SubEvent subEvent = findSubEventById(subEventId);
        return subEvent.getRegisteredUsersCount();
    }

}