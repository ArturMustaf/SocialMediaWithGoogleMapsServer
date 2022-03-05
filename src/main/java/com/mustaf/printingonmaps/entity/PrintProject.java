package com.mustaf.printingonmaps.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class PrintProject {

    @Id
    private String id;
    private String name;
    private String description;
    private String sourceUrl;

    public PrintProject(String name, String description, String sourceUrl) {
        this.name = name;
        this.description = description;
        this.sourceUrl = sourceUrl;
    }

    @Override
    public String toString() {
        return "3D printer project: \"" + name + "\"\ndescription: " + description + "\nsource: " + sourceUrl;
    }
}
