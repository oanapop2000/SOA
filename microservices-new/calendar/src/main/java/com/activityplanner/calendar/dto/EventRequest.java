package com.activityplanner.calendar.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
public class EventRequest {
    private Long userId;

    private String eventName;

    private String eventDescription;

    private ZonedDateTime startDate;

    private ZonedDateTime endDate;

    private String location;
}
