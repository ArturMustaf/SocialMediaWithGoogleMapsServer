package com.mustaf.printingonmaps.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Document
@Data
public class User {

    @Id
    private String googleAccId;

    private String name;
    private String surname;
    private String displayName;
    private String photoUrl;
    private String email;
    @DBRef
    private List<Event> events = new ArrayList<>();
}
