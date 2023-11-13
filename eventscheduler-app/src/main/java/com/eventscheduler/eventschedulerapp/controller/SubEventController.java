package com.eventscheduler.eventschedulerapp.controller;

import com.eventscheduler.eventschedulerapp.model.SubEvent;
import com.eventscheduler.eventschedulerapp.service.SubEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/subevents")
@CrossOrigin("*")
public class SubEventController {

    @Autowired
    private SubEventService subEventService;

    @RequestMapping(
        value = "/findSubEventByName/{name}",
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.GET)
    public ResponseEntity<Object> findSubEventByName(@PathVariable String name) {
        try {
            SubEvent foundSubEventByName = subEventService.findSubEventByName(name);
            return new ResponseEntity<>(foundSubEventByName, HttpStatus.OK);
        } catch (Exception exception) {
            System.out.println(exception);
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Error error) {
            System.out.println(error);
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(
        value = "/findSubEventByLocation/{location}",
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.GET)
    public ResponseEntity<Object> findSubEventByLocation(@PathVariable String location) {
        try {
            SubEvent foundSubEventByLocation = subEventService.findSubEventByLocation(location);
            return new ResponseEntity<>(foundSubEventByLocation, HttpStatus.OK);
        } catch (Exception exception) {
            System.out.println(exception);
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Error error) {
            System.out.println(error);
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(
        value = "/findSubEventById/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.GET)
    public ResponseEntity<Object> findSubEventById(@PathVariable Integer id) {
        try {
            SubEvent findSubEventId = subEventService.findSubEventById(id);
            return new ResponseEntity<>(findSubEventId, HttpStatus.OK);
        } catch (Exception exception) {
            System.out.println(exception);
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Error error) {
            System.out.println(error);
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(
        value = "/findSubEventByDate/{startDate}/{endDate}",
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.GET
    )
    public ResponseEntity<Object> findSubEventByDate (@PathVariable LocalDate startDate, LocalDate endDate) {
        try {
            List <SubEvent> foundSubEventByDate = subEventService.findSubEventByDate(startDate, endDate);
            return new ResponseEntity<>(foundSubEventByDate, HttpStatus.OK);
        } catch (Exception exception) {
        System.out.println(exception);
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Error error) {
        System.out.println(error);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<SubEvent>> getAllSubEvents() {
        List<SubEvent> allSubEvents = subEventService.findAllSubEvents();
        return ResponseEntity.ok(allSubEvents);
    }

    @RequestMapping(
        value = "/createSubEvent",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.POST)
    public ResponseEntity<Object> createSubEvent(@RequestBody SubEvent subEvent) {
        try {
            SubEvent createdSubEvent = subEventService.createSubEvent(subEvent);
            return new ResponseEntity<>(createdSubEvent, HttpStatus.CREATED);
        } catch (Exception exception) {
            System.out.println(exception);
            return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
        } catch (Error error) {
            System.out.println(error);
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(
        value = "/updateSubEvent",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.PUT)
    public ResponseEntity<Object> updateSubEvent(@RequestBody SubEvent subEvent) {
        try {
            SubEvent updatedSubEvent = subEventService.updateSubEvent(subEvent);
            return new ResponseEntity<>(updatedSubEvent, HttpStatus.OK);
        } catch (Exception exception) {
            System.out.println(exception);
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Error error) {
            System.out.println(error);
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(
        value = "/deleteSubEvent/{id}",
        method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSubEvent(@PathVariable Integer id) {
        try {
            subEventService.deleteSubEventById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception exception) {
            System.out.println(exception);
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Error error) {
            System.out.println(error);
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}