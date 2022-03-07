package com.mustaf.printingonmaps.controller;

import com.mustaf.printingonmaps.dto.EventDTO;
import com.mustaf.printingonmaps.entity.Event;
import com.mustaf.printingonmaps.entity.PrintProject;
import com.mustaf.printingonmaps.EventRepository;
import com.mustaf.printingonmaps.PrintProjectRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PrintProjectController {

    PrintProjectRepository printProjectRepository;
    EventRepository eventRepository;

    public PrintProjectController(PrintProjectRepository printProjectRepository,
                                  EventRepository eventRepository) {
        this.printProjectRepository = printProjectRepository;
        this.eventRepository = eventRepository;
    }

    @GetMapping("/print-projects/{id}")
    public PrintProject one(@PathVariable String id) {
        return printProjectRepository.findById(id).orElse(null);
    }

    @GetMapping("/print-projects")
    public List<PrintProject> all() {
        System.out.println("requesting data...:");
        return printProjectRepository.findAll();
    }

    @GetMapping("/events")
    public List<Event> allEvents() {
        var events = eventRepository.findAll();

        System.out.println("returning events...");
        events.forEach(event -> System.out.println(event.getAddress() + ", " + event.getLat() + ", " + event.getLng()));

        return events;
    }

    @PostMapping("/events")
    public void createAddress(@RequestBody EventDTO eventDTO) {
        System.out.println("new event received...");

        Event event = new Event();
        event.setAddress(eventDTO.getAddress());
        event.setLat(eventDTO.getLat());
        event.setLng(eventDTO.getLng());
        event.setPersonId(eventDTO.getPersonId());

        System.out.println("received pId: " + event.getPersonId());

        eventRepository.save(event);
    }
}