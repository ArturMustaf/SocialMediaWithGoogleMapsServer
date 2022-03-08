package com.mustaf.printingonmaps.controller;

import com.mustaf.printingonmaps.UserRepository;
import com.mustaf.printingonmaps.dto.EventDTO;
import com.mustaf.printingonmaps.entity.Event;
import com.mustaf.printingonmaps.entity.PrintProject;
import com.mustaf.printingonmaps.EventRepository;
import com.mustaf.printingonmaps.PrintProjectRepository;
import com.mustaf.printingonmaps.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PrintProjectController {

    PrintProjectRepository printProjectRepository;
    EventRepository eventRepository;
    UserRepository userRepository;

    public PrintProjectController(PrintProjectRepository printProjectRepository,
                                  EventRepository eventRepository,
                                  UserRepository userRepository) {
        this.printProjectRepository = printProjectRepository;
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
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

    @GetMapping("/users")
    public List<User> allUsers() {
        var users = userRepository.findAll();

        System.out.println("returning users...");
        users.forEach(user -> System.out.println(user.getDisplayName()));

        return users;
    }

    @GetMapping("/users/{id}")
    public User oneUser(@PathVariable String id) {
        System.out.println("returning single user...");
        return userRepository.findById(id).get();
    }


    @PostMapping("/events")
    public void createAddress(@RequestBody EventDTO eventDTO) {
        System.out.println("new event received...");

        Event event = new Event();
        event.setAddress(eventDTO.getAddress());
        event.setLat(eventDTO.getLat());
        event.setLng(eventDTO.getLng());
        event.setPersonId(eventDTO.getPersonId());
        event.setStartDate(eventDTO.getStartDate());
        event.setEndDate(eventDTO.getEndDate());

        System.out.println("received pId: " + event.getPersonId());

        var persistentEvent = eventRepository.save(event);
        var user = userRepository.findById(event.getPersonId()).get();
        user.getEvents().add(persistentEvent);
        userRepository.save(user);
    }
}