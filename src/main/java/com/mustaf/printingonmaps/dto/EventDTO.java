package com.mustaf.printingonmaps.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EventDTO {

    private String name;
    private String address;
    private double lat;
    private double lng;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate startDate;
    private int startTimeHour;
    private int startTimeMinute;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate endDate;
    private int endTimeHour;
    private int endTimeMinute;
    private String personId;
}
