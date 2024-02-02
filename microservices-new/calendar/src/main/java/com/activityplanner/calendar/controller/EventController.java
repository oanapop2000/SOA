package com.activityplanner.calendar.controller;

import com.activityplanner.calendar.dto.EventRequest;
import com.activityplanner.calendar.model.Event;
import com.activityplanner.calendar.service.EventService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
@Slf4j
@Tag(name = "/events", description = "Provides REST functionality for calendar events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/{eventName}")
    @ResponseStatus(HttpStatus.OK)
    public Event getEvent(@PathVariable(value = "eventName") String eventName) {
        return eventService.getEventByName(eventName);
    }

    @GetMapping("userId/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Event> getEventsByUserId(@PathVariable(value = "userId") Long userId) {
        return eventService.getEventByUserId(userId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createEvent(@RequestBody EventRequest eventRequest) {
        eventService.createEvent(eventRequest);
    }
}
