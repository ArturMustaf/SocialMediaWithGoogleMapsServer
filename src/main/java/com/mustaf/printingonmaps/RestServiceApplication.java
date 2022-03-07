package com.mustaf.printingonmaps;

import com.mustaf.printingonmaps.entity.PrintProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestServiceApplication implements CommandLineRunner {

    @Autowired
    private PrintProjectRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(RestServiceApplication.class, args);
    }

    @Override
    public void run(String... args) {

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
        }
    }
}
