package com.mustaf.printingonmaps.entity;

import com.mustaf.printingonmaps.dto.AddressDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
@Data
public class Address {

    @Id
    private String id;
    private String address;


    @Override
    public String toString() {
        return "address: " + address;
    }
}
