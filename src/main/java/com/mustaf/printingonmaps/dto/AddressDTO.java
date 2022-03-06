package com.mustaf.printingonmaps.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@Document
public class AddressDTO {

    private String address;
    private double lat;
    private double lng;
}
