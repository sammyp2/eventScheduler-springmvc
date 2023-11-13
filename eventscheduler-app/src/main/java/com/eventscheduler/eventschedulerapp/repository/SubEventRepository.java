package com.eventscheduler.eventschedulerapp.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eventscheduler.eventschedulerapp.model.SubEvent;

public interface SubEventRepository extends JpaRepository <SubEvent, Integer>{

    Optional<SubEvent> findById(Integer id);

    void deleteById(Integer id);

    SubEvent findSubEventByName(String name);

    SubEvent findSubEventByLocation(String location);

    @Query("SELECT e FROM Event e WHERE e.startDate >= :startDate AND e.endDate <= :endDate")
    List <SubEvent> findSubEventByDate(LocalDate startDate, LocalDate endDate);

    
}
