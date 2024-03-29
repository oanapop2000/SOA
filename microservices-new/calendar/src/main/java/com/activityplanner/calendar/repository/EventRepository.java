package com.activityplanner.calendar.repository;

import com.activityplanner.calendar.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Long> {

    Optional<Event> findByEventName(String eventName);
    List<Event> findByUserId(Long userId);
}
