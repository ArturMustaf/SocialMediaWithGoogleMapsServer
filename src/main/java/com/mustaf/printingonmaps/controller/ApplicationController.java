package com.mustaf.printingonmaps.controller;

import com.mustaf.printingonmaps.dto.EventDTO;
import com.mustaf.printingonmaps.dto.UserDTO;
import com.mustaf.printingonmaps.entity.Event;
import com.mustaf.printingonmaps.entity.User;
import com.mustaf.printingonmaps.repository.EventRepository;
import com.mustaf.printingonmaps.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController
public class ApplicationController {

    EventRepository eventRepository;
    UserRepository userRepository;

    public ApplicationController(EventRepository eventRepository,
                                 UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
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

    @PostMapping("/users")
    public void createUser(@RequestBody UserDTO userDTO) {
        System.out.println("creating user with id..." + userDTO.getGoogleAccId());
        User user = new User();
        user.setGoogleAccId(userDTO.getGoogleAccId());
        user.setSurname(userDTO.getSurname());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setDisplayName(userDTO.getDisplayName());
        user.setPhotoUrl(userDTO.getPhotoUrl());

        userRepository.save(user);
    }

    @PostMapping("/events")
    public EventDTO createAddress(@RequestBody EventDTO eventDTO) {
        System.out.println("new event received..." + eventDTO);

        Event event = new Event();
        event.setName(eventDTO.getName());
        event.setAddress(eventDTO.getAddress());
        event.setLat(eventDTO.getLat());
        event.setLng(eventDTO.getLng());
        event.setPersonId(eventDTO.getPersonId());
        event.setStartDate(LocalDateTime.of(eventDTO.getStartDate(), LocalTime.of(eventDTO.getStartTimeHour(), eventDTO.getStartTimeMinute())));
        event.setEndDate(LocalDateTime.of(eventDTO.getEndDate(), LocalTime.of(eventDTO.getEndTimeHour(), eventDTO.getEndTimeMinute())));

        var persistentEvent = eventRepository.save(event);
        var user = userRepository.findById(event.getPersonId()).get();
        user.getEvents().add(persistentEvent);
        userRepository.save(user);
        return eventDTO;
    }

    @GetMapping("/events")
    public List<Event> allEvents() {
        var events = eventRepository.findAll();

        System.out.println("returning events...");
        events.forEach(event -> System.out.println(event.getAddress() + ", " + event.getLat() + ", " + event.getLng() + ", " + event.getPersonId()));

        return events;
    }
}