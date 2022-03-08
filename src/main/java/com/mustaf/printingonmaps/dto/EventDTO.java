package com.mustaf.printingonmaps.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Getter
@Setter
@Document
public class EventDTO {

    private String address;
    private double lat;
    private double lng;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String personId;
}
