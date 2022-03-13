package com.mustaf.printingonmaps;

import com.mustaf.printingonmaps.entity.Event;
import com.mustaf.printingonmaps.entity.User;
import com.mustaf.printingonmaps.repository.EventRepository;
import com.mustaf.printingonmaps.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
public class RestServiceApplication implements CommandLineRunner {

    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    public RestServiceApplication(UserRepository userRepository, EventRepository eventRepository) {
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(RestServiceApplication.class, args);
    }

    @Override
    public void run(String... args) {
        userRepository.deleteAll();
        eventRepository.deleteAll();

        Event event0 = new Event();
        event0.setName("Wanderung am Rochusberg.");
        event0.setAddress("55411 Bingen");
        event0.setLat(49.96220674146701);
        event0.setLng(7.917981305391342);
        event0.setStartDate(LocalDateTime.of(2022,03,20,8,0));
        event0.setEndDate(LocalDateTime.of(2022,03,20,14,0));

        Event event1 = new Event();
        event1.setName("Jemand Lust auf Filmabend?");
        event1.setAddress("55411 Bingen");
        event1.setLat(49.96784985506164);
        event1.setLng(7.877169046455733);
        event1.setStartDate(LocalDateTime.of(2022,03,18,20,0));
        event1.setEndDate(LocalDateTime.of(2022,03,18,22,30));
        //event0.setPersonId();

        Event event2 = new Event();
        event2.setName("ASV Nahe. Umweltschutztag 2022!");
        event2.setAddress("55450 Langenlonsheim");
        event2.setLat(49.89783405142373);
        event2.setLng(7.909947750065851);
        event2.setStartDate(LocalDateTime.of(2022,03,19,8,0));
        event2.setEndDate(LocalDateTime.of(2022,03,19,20,0));
        //event0.setPersonId();

        Event event3 = new Event();
        event3.setName("Picknick auf der LGS. Musik + Karten zum Pokern am Start");
        event3.setAddress("55411 Bingen");
        event3.setLat(49.969991447866);
        event3.setLng(7.883392911784725);
        event3.setStartDate(LocalDateTime.of(2022,03,20,10,0));
        event3.setEndDate(LocalDateTime.of(2022,03,20,14,0));
        //event0.setPersonId();

        Event event4 = new Event();
        event4.setName("Android-Präsentation. Zuschauer gesucht!");
        event4.setAddress("Berlinstraße 109, 55411 Bingen am Rhein");
        event4.setLat(49.95277259471173);
        event4.setLng(7.925557940593324);
        event4.setStartDate(LocalDateTime.of(2022,03,15,8,0));
        event4.setEndDate(LocalDateTime.of(2022,03,15,16,0));
        //

        Event event5 = new Event();
        event5.setName("Impfung an der TH!");
        event5.setAddress("Berlinstraße 109, 55411 Bingen am Rhein");
        event5.setLat(49.952815693292536);
        event5.setLng(7.924380940570162);
        event5.setStartDate(LocalDateTime.of(2022,03,15,8,0));
        event5.setEndDate(LocalDateTime.of(2022,03,15,16,0));
        //

        Event event6 = new Event();
        event6.setName("Jemand Lust auf eine Fahrrad-Tour nach Mainz? Starten in Bingen.");
        event6.setAddress("Bleiche 2, 55411 Bingen am Rhein");
        event6.setLat(49.97005203664737);
        event6.setLng(7.889721765791379);
        event6.setStartDate(LocalDateTime.of(2022,03,27,7,0));
        event6.setEndDate(LocalDateTime.of(2022,03,27,20,0));

        Event event7 = new Event();
        event7.setName("Rhein in Flammen.");
        event7.setAddress("65385 Rüdesheim am Rhein");
        event7.setLat(49.980206265986986);
        event7.setLng(7.930729540423449);
        event7.setStartDate(LocalDateTime.of(2022,8,16,20,0));
        event7.setEndDate(LocalDateTime.of(2022,8,18,20,0));

        User user0 = new User();
        user0.setGoogleAccId("112646633066035474956");
        user0.setName("Artur");
        user0.setSurname("Mustaf");
        user0.setDisplayName("Artur");
        user0.setPhotoUrl("https://lh3.googleusercontent.com/a-/AOh14Gixhaqzfh3rmwkyQhTE6Jd9_s7OsQUW_3Bl05d4Og");
        user0.setEmail("artur.mustaf@th-bingen.de");
        user0.getEvents().addAll(Arrays.asList(event4, event7));
        event4.setPersonId(user0.getGoogleAccId());
        event7.setPersonId(user0.getGoogleAccId());

        User user1 = new User();
        user1.setGoogleAccId("9988776655");
        user1.setName("Jonas");
        user1.setSurname("Milo");
        user1.setDisplayName("Jon");
        user1.setPhotoUrl("https://lh3.googleusercontent.com/wys3Hu2pfmpK36xCscLRCfeFvCkhjUSyI3Bvl3GprVOWRT2wl3YSkv3ua7zY13DBmBO-rgC5qc76YtkUU--puzaH-So");
        user1.setEmail("Jonas.Milo@testmail.de");
        user1.getEvents().addAll(Arrays.asList(event0, event5, event6));
        event0.setPersonId(user1.getGoogleAccId());
        event5.setPersonId(user1.getGoogleAccId());
        event6.setPersonId(user1.getGoogleAccId());

        User user2 = new User();
        user2.setGoogleAccId("1234567");
        user2.setName("Emilia");
        user2.setSurname("Malea");
        user2.setDisplayName("EM");
        user2.setPhotoUrl("https://lh3.googleusercontent.com/G7XRN-oq4w0OUTzxDwYa_1NR2oR-lkjwm9pjOU8Occ2bIO7FhUfRBNFR7EIg6GhllM14Mop4ddoxRaxHo6N_W9dgWg");
        user2.setEmail("Emilia.Malea@testmail.de");
        user2.getEvents().addAll(Arrays.asList(event1, event2, event3));
        event1.setPersonId(user2.getGoogleAccId());
        event2.setPersonId(user2.getGoogleAccId());
        event3.setPersonId(user2.getGoogleAccId());



        eventRepository.saveAll(Arrays.asList(event0, event1, event2, event3, event4, event5, event6, event7));
        userRepository.saveAll(Arrays.asList(user0, user1, user2));

        /*
        repository.deleteAll();

        var printProject0 = new PrintProject("Benchy",
                "It is designed to 3D-print quickly and be a fun tool for calibrating your 3D printer. There is a single-part STL file for 3D printing the boat in one material, and a multi-part STL assembly to suitable for multi-material/printhead 3D printing.",
                "https://www.thingiverse.com/thing:763622");
        var printProject1 = new PrintProject("Baby Groot",
                "Hello, my version of baby Groot from the upcoming blockbuster movie \"Guardians of the Galaxy 2\". The model resembles the baby groots appearance in the trailers of the movie.",
                "https://www.thingiverse.com/thing:2014307");
        var printProject2 = new PrintProject("Baby Yoda",
                "A cute lil baby Yoda just in time for Christmas! Sculpted in ZBrush because he's just so darned adorable. Print him up for all your friends that are obsessed with this little guy- I know I will be printing quite a few...",
                "https://www.thingiverse.com/thing:4038181");

        repository.save(printProject0);
        repository.save(printProject1);
        repository.save(printProject2);

        System.out.println("Print project found with findAll():");
        System.out.println("-----------------------------------");
        for (var printProject : repository.findAll()) {
            System.out.println(printProject);
        }*/
    }
}
