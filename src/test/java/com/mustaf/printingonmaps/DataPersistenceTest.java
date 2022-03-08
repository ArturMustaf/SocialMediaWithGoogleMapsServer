package com.mustaf.printingonmaps;

import com.mustaf.printingonmaps.entity.Event;
import com.mustaf.printingonmaps.entity.User;
import com.mustaf.printingonmaps.repository.EventRepository;
import com.mustaf.printingonmaps.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DataPersistenceTest {

    private EventRepository eventRepository;
    private UserRepository userRepository;

    @Autowired
    public void setRepositories(EventRepository eventRepository, UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    @BeforeEach
    public void initializeData() {
        User user = new User();
        user.setGoogleAccId("112646633066035474956");
        user.setName("Name");
        user.setSurname("Surame");
        user.setDisplayName("DisplayName");
        user.setPhotoUrl("www.photo-url.com");
        user.setEmail("www.email.com+");

        userRepository.save(user);
    }

    @Test
    public void retrievingUser_shouldReturnValidUser() {
        var user = userRepository.findById("112646633066035474956").get();
        assertAll(
                () -> assertThat(user).isNotNull(),
                () -> assertThat(user.getGoogleAccId()).isEqualTo("112646633066035474956")
        );
    }

    @Test
    public void givenSaveEventToDB_whenRetrievingEvent_shouldReturnValidEvent() {
        var event = new Event();
        event.setAddress("Eine Adresse");
        event.setLat(01234);
        event.setLng(5678);
        event.setPersonId("112646633066035474956");

        var persistentEvent = eventRepository.save(event);

        assertAll(
                () -> assertThat(persistentEvent).isNotNull(),
                () -> assertThat(persistentEvent.getPersonId()).isEqualTo("112646633066035474956")
        );
    }

    @Test
    public void givenUserWithOneEvent_whenAccessingUser_thenAlsoReturnEvent() {
        var user = userRepository.findById("112646633066035474956").get();

        var event = new Event();
        event.setAddress("Eine Adresse");
        event.setLat(01234);
        event.setLng(5678);
        event.setPersonId("112646633066035474956");

        eventRepository.save(event);

        user.getEvents().add(event);
        var updatedUser = userRepository.save(user);

        assertAll(
                () -> assertThat(updatedUser).isNotNull(),
                () -> assertThat(updatedUser.getGoogleAccId()).isEqualTo("112646633066035474956"),
                () -> assertThat(updatedUser.getEvents()).isNotNull(),
                () -> assertThat(updatedUser.getEvents().get(0).getAddress()).isEqualTo("Eine Adresse")
        );
    }
}