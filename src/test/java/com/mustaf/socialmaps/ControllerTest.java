package com.mustaf.socialmaps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mustaf.socialmaps.dto.EventDTO;
import com.mustaf.socialmaps.entity.User;
import com.mustaf.socialmaps.repository.EventRepository;
import com.mustaf.socialmaps.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();


    @BeforeEach
    public void initializeData() {
        userRepository.deleteAll();
        eventRepository.deleteAll();

        User user = new User();
        user.setGoogleAccId("112646633066035474956");
        user.setName("Name");
        user.setSurname("Surame");
        user.setDisplayName("DisplayName");
        user.setPhotoUrl("www.photo-url.com");
        user.setEmail("www.email.com+");

        User user0 = new User();
        user0.setGoogleAccId("1111111111111111111");
        user0.setName("Name_2");
        user0.setSurname("Surname_2");
        user0.setDisplayName("DisplayName_2");
        user0.setPhotoUrl("www.photo-url-2.com");
        user0.setEmail("www.email2.com");

        userRepository.save(user);
        userRepository.save(user0);
    }

    @Test
    public void givenUser_whenPostEvent_thenSaveEvent() throws Exception {
        var eventDto = new EventDTO();
        eventDto.setAddress("Eine Adresse");
        eventDto.setLat(01234);
        eventDto.setLng(5678);
        eventDto.setPersonId("112646633066035474956");

        var postValue = OBJECT_MAPPER.writeValueAsString(eventDto);

        this.mockMvc.perform(post("/events")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postValue))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void givenUserWithEvent_whenGetAllEvents_thenReturnEvent() throws Exception {
        var eventDto = new EventDTO();
        eventDto.setAddress("Eine Adresse");
        eventDto.setLat(01234);
        eventDto.setLng(5678);
        eventDto.setPersonId("112646633066035474956");

        var postValue = OBJECT_MAPPER.writeValueAsString(eventDto);

        this.mockMvc.perform(post("/events")
                .contentType(MediaType.APPLICATION_JSON)
                .content(postValue));

        this.mockMvc.perform(get("/events"))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    public void getUsers_shouldReturnMultipleUsers() throws Exception {
        var eventDto = new EventDTO();
        eventDto.setAddress("Eine Adresse");
        eventDto.setLat(01234);
        eventDto.setLng(5678);
        eventDto.setPersonId("112646633066035474956");

        var postValue = OBJECT_MAPPER.writeValueAsString(eventDto);

        this.mockMvc.perform(post("/events")
                .contentType(MediaType.APPLICATION_JSON)
                .content(postValue));

        this.mockMvc.perform(get("/users"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
