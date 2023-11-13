package com.eventscheduler.eventschedulerapp.
service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventscheduler.eventschedulerapp.model.Event;
import com.eventscheduler.eventschedulerapp.model.User;
import com.eventscheduler.eventschedulerapp.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User signUpUser(User user) {
        User newUser = new User();

        System.out.println("Raw password: " + user.getRawPassword());
        System.out.println("User Type: " + user.getUserType());
        newUser.setUsername(user.getUsername());
        newUser.setEmail(user.getEmail());
        newUser.setRawPassword(user.getRawPassword());
        newUser.setUserType(user.getUserType());

        return userRepository.save(newUser);
    }

    public User signInUser(String userIdentity, String rawPassword) throws Exception {
        User userFound = userRepository.findByEmail(userIdentity);
        
        if(userFound == null) {
            userFound = userRepository.findByUsername(userIdentity);
        } if (userFound == null) {
            throw new Exception("User Not Found");
        } if (!userFound.getRawPassword().equals(rawPassword)) {
            throw new Exception("Invalid Password");
        }

        return userFound;
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User findUserById(Long id) throws Exception {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new Exception("User Not Found"));
    }

    public User findUserByEmail(String email) throws Exception {
        Optional<User> userEmail = userRepository.findUserByEmail(email);
        return userEmail.orElseThrow(() -> new Exception("User Not Found With This Email"));
    }

    public User findUserByUsername(String username) throws Exception {
        Optional<User> userName = userRepository.findUserByUsername(username);
        return userName.orElseThrow(() -> new Exception("User Not Found With This Username"));
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void approveAdminStatus(Long userId) throws Exception{
        Optional<User> typeUser = userRepository.findById(userId);

        if (typeUser.isPresent()) {
            User user = typeUser.get();
            if(user.getUserType() == User.UserType.USER) {
                user.approveAdminStatus();
                userRepository.save(user);
            } else {
                throw new Exception("User Is Already An Admin");
            }
            } else {
                throw new Exception("User Not Found");
            }
        }

        public List<Event> getUserEvents(Long userId) {
            Optional<User> user = userRepository.findById(userId);
    
            if (user.isPresent()) {
                return user.get().getUserEvents();
            } else {
                throw new RuntimeException("User not found");
            }
        }

}