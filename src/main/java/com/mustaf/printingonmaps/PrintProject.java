package com.mustaf.printingonmaps;

import org.springframework.data.annotation.Id;

public class PrintProject {

    @Id
    private long id;
    private String name;
    private String description;
    private String sourceUrl;

    public PrintProject() {}

    public PrintProject(String name, String description, String sourceUrl) {
        this.name = name;
        this.description = description;
        this.sourceUrl = sourceUrl;
    }
}
