package bg.softuni.e12_bookshop.services.seed;

import java.io.IOException;

public interface SeedService {

    void seedAuthors() throws IOException;

    void seedBooks();

    void seedCategory();


    default void seedAllData() throws IOException {
        seedAuthors();
        seedBooks();
        seedCategory();
    }
}
