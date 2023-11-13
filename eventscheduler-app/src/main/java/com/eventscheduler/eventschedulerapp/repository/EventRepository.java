package com.eventscheduler.eventschedulerapp
.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.eventscheduler.eventschedulerapp.model.Event;


@Repository
public interface EventRepository extends JpaRepository <Event, Integer> {

    Optional<Event> findById(Integer id);

    List <Event> findEventsByLocation(String location);

    List <Event> findEventByName(String name);

    void deleteById(Integer id);

    @Query("SELECT e FROM Event e WHERE e.startDate >= :startDate AND e.endDate <= :endDate")
    List<Event> findEventByDate(LocalDate startDate, LocalDate endDate);





}
