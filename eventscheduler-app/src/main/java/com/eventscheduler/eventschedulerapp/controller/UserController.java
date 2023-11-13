package com.eventscheduler.eventschedulerapp.controller;

import com.eventscheduler.eventschedulerapp.model.Event;
import com.eventscheduler.eventschedulerapp.model.User;
import com.eventscheduler.eventschedulerapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<Object> signUpUser(@RequestBody User user) {
        try {
            User savedUser = userService.signUpUser(user);
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        } catch (Exception exception) {
            System.out.println(exception);
            return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
        } catch (Error error) {
            System.out.println(error);
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<Object> signIn(@RequestBody User user) {
        try {
            User authenticatedUser = userService.signInUser(user.getUserInput(), user.getRawPassword());
            return new ResponseEntity<>(authenticatedUser, HttpStatus.OK);
        } catch (Exception exception) {
            System.out.println(exception);
            return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
        } catch (Error error) {
            System.out.println(error);
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findUserById/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        try {
            User findUserId = userService.findUserById(id);
            return new ResponseEntity<>(findUserId, HttpStatus.OK);
        } catch (Exception exception) {
            System.out.println(exception);
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Error error) {
            System.out.println(error);
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findUserByEmail/{email}")
    public ResponseEntity<Object> findByEmail(@PathVariable String email) {
        try {
            User foundUserByEmail = userService.findUserByEmail(email);
            return new ResponseEntity<>(foundUserByEmail, HttpStatus.OK);
        } catch (Exception exception) {
            System.out.println(exception);
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Error error) {
            System.out.println(error);
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findUserByUsername/{username}")
    public ResponseEntity<Object> findByUsername(@PathVariable String username) {
        try {
            User foundUserByUsername = userService.findUserByUsername(username);
            return new ResponseEntity<>(foundUserByUsername, HttpStatus.OK);
        } catch (Exception exception) {
            System.out.println(exception);
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Error error) {
            System.out.println(error);
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<Object> findAll() {
        try {
            List<User> allUsers = userService.findAllUsers();
            return new ResponseEntity<>(allUsers, HttpStatus.OK);
        } catch (Exception exception) {
            System.out.println(exception);
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Error error) {
            System.out.println(error);
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateUser")
    public ResponseEntity<Object> userUpdate(@RequestBody User user) {
        try {
            User updatedUser = userService.updateUser(user);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } catch (Exception exception) {
            System.out.println(exception);
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Error error) {
            System.out.println(error);
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<Object> removeUser(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception exception) {
            System.out.println(exception);
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Error error) {
            System.out.println(error);
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/approveAdmin/{id}")
    public ResponseEntity<Object> approveAdminStatus(@PathVariable Long id) {
        try {
            userService.approveAdminStatus(id);
            return new ResponseEntity<> ("Admin Status Approved", HttpStatus.OK);
        } catch (Exception exception) {
            System.out.println(exception);
            return new ResponseEntity<> (exception.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Error error) {
            System.out.println(error);
            return new ResponseEntity<> (error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{userId}/events")
    public List<Event> getUserEvents(@PathVariable Long userId) {
        return userService.getUserEvents(userId);
    }
}