package com.activityplanner.calendar.service;

import com.activityplanner.calendar.dto.EventRequest;
import com.activityplanner.calendar.model.Event;
import com.activityplanner.calendar.repository.EventRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event getEventByName(String eventName) {
        Optional<Event> optionalEvent = eventRepository.findByEventName(eventName);
        if (optionalEvent.isEmpty()) {
            throw new RuntimeException("Event not found!");
        }

        return optionalEvent.get();
    }

    public void createEvent(EventRequest eventRequest){
        Event event = Event.builder()
                .userId(eventRequest.getUserId())
                .eventName(eventRequest.getEventName())
                .eventDescription(eventRequest.getEventDescription())
                .startDate(eventRequest.getStartDate())
                .endDate(eventRequest.getEndDate())
                .location(eventRequest.getLocation())
                .build();

        eventRepository.save(event);
        log.info("Event {} is saved", event.getId());
    }
}
