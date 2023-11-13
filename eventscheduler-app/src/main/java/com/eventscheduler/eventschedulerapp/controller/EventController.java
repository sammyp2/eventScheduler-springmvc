package com.eventscheduler.eventschedulerapp.controller;

import com.eventscheduler.eventschedulerapp.model.Event;
import com.eventscheduler.eventschedulerapp.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/events")
@CrossOrigin("*")
public class EventController {

    @Autowired
    private EventService eventService;

    @RequestMapping(
        value = "/findEventsByLocation/{location}",
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.GET)
    public ResponseEntity<Object> findEventsByLocation(@PathVariable String location) {
        try {
            List <Event> foundEventByLocation = eventService.findEventsByLocation(location);
            return new ResponseEntity<>(foundEventByLocation, HttpStatus.OK);
        } catch (Exception exception) {
            System.out.println(exception);
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Error error) {
            System.out.println(error);
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(
        value = "/findEventByName/{name}",
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.GET)
    public ResponseEntity<Object> findEventByName(@PathVariable String name) {
        try {
            List <Event> foundEventByName = eventService.findEventByName(name);
            return new ResponseEntity<>(foundEventByName, HttpStatus.OK);
        } catch (Exception exception) {
            System.out.println(exception);
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Error error) {
            System.out.println(error);
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(
        value = "/findEventByDate/{startDate}/{endDate}",
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.GET
    )
    public ResponseEntity<Object> findEventByDate (@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        try {
            List <Event> eventByDate = eventService.findEventByDate(startDate, endDate);
            return new ResponseEntity<>(eventByDate, HttpStatus.OK);
        } catch (Exception exception) {
            System.out.println(exception);
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Error error) {
            System.out.println(error);
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(
        value = "/findEventById/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.GET)
    public ResponseEntity<Object> findById(@PathVariable Integer id) {
        try {
            Event findEventId = eventService.findEventById(id);
            return new ResponseEntity<>(findEventId, HttpStatus.OK);
        } catch (Exception exception) {
            System.out.println(exception);
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Error error) {
            System.out.println(error);
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> allEvents = eventService.findAllEvents();
        return ResponseEntity.ok(allEvents);
    }

    @RequestMapping(
        value = "/createEvent",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.POST)
    public ResponseEntity<Object> addEvent(@RequestBody Event event) {
        try {
            Event savedEvent = eventService.createEvent(event);
            return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
        } catch (Exception exception) {
            System.out.println(exception);
            return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
        } catch (Error error) {
            System.out.println(error);
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(
        value = "/updateEvent",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.PUT)
    public ResponseEntity<Object> eventUpdate(@RequestBody Event event) {
        try {
            Event updatedEvent = eventService.updateEvent(event);
            return new ResponseEntity<>(updatedEvent, HttpStatus.OK);
        } catch (Exception exception) {
            System.out.println(exception);
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Error error) {
            System.out.println(error);
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(
        value = "/deleteEvent/{id}",
        method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteEvent(@PathVariable Integer id) {
        try {
            eventService.deleteEventById(id);
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