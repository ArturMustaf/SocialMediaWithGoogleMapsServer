package com.mustaf.printingonmaps;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PrintProjectController {

    PrintProjectRepository repository;

    @GetMapping("/print-projects/{id}")
    public PrintProject one(@PathVariable String id) {
        return repository.findById(id).orElse(null);
    }

    @GetMapping("/print-projects")
    public List<PrintProject> all() {
        return repository.findAll();
    }
}
