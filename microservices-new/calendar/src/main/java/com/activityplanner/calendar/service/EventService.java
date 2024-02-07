package com.activityplanner.calendar.service;

import com.activityplanner.calendar.dto.EventRequest;
import com.activityplanner.calendar.dto.User;
import com.activityplanner.calendar.model.Event;
import com.activityplanner.calendar.repository.EventRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class EventService {

    private final EventRepository eventRepository;
    private final WebClient.Builder webClientBuilder;

    public EventService(EventRepository eventRepository, WebClient.Builder webClientBuilder) {
        this.eventRepository = eventRepository;
        this.webClientBuilder = webClientBuilder;
    }

    public Event getEventByName(String eventName) {
        Optional<Event> optionalEvent = eventRepository.findByEventName(eventName);
        if (optionalEvent.isEmpty()) {
            throw new RuntimeException("Event not found!");
        }
        log.info("Event {} is found", optionalEvent.get().getId());
        return optionalEvent.get();
    }

    public List<Event> getEventByUserId(Long userId) {
        List<Event> events = eventRepository.findByUserId(userId);
        if (events.isEmpty()) {
            return new ArrayList<Event>();
        }
        log.info("Events are found");
        return events;
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

        // Call user and check if there is a user with eventRequest's userId
        User user = webClientBuilder.build().get()
                .uri("http://user/user/users",
                        uriBuilder -> uriBuilder.queryParam("id", event.getUserId()).build())
                .retrieve()
                .bodyToMono(User.class)
                .block();

        if(user != null){
            eventRepository.save(event);
        }else{
            throw new IllegalArgumentException("User does not exist");
        }


        log.info("Event {} is saved", event.getId());
    }

    public void deleteEvent(Long id){
        Optional<Event> event = eventRepository.findById(id);
        if (event.isEmpty()) {
            throw new RuntimeException("Event not found!");
        }

        eventRepository.delete(event.get());

        log.info("Event {} is deleted", event.get().getId());
    }
}
