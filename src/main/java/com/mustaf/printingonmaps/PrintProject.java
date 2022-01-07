package com.mustaf.printingonmaps;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PrintProject {

    @Id
    private String id;
    private String name;
    private String description;
    private String sourceUrl;

    public PrintProject() {}

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
