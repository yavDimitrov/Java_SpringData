package bg.softuni.e12_bookshop;

import bg.softuni.e12_bookshop.domain.entities.Author;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
        Author.builder().build();
    }

}
