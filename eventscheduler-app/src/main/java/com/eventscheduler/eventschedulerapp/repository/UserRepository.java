package com.eventscheduler.eventschedulerapp
.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.eventscheduler.eventschedulerapp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value="select * from user where email = ?1 and password = ?2", nativeQuery = true)
    public User signIn(String email, String rawPassword);

    public User findByEmail(String email);

    public void deleteById(Long id);

    public User findByUsername(String username);

    public Optional<User> findById(Long id);

    // public Optional<User> findUserById(Long userId);

    public Optional<User> findUserByUsername(String username);

    public Optional<User> findUserByEmail(String email);

    
}

