package com.mustaf.printingonmaps.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
@Data
public class Event {

    @Id
    private String id;
    private String address;
    private double lat;
    private double lng;
    private String personId;

}
