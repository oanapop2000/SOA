package com.activityplanner.calendar.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
public class EventRequest {
    private Long userId;

    private String eventName;

    private String eventDescription;

    private Date startDate;

    private Date endDate;

    private String location;
}
