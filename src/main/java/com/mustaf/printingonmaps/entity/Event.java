package com.mustaf.printingonmaps.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Document
@Data
public class Event {

    @Id
    private String id;
    private String name;
    private String address;
    private double lat;
    private double lng;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String personId;

}
