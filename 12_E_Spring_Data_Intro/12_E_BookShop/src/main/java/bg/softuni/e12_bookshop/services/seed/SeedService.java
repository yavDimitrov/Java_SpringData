package bg.softuni.e12_bookshop.services.seed;

import java.io.IOException;

public interface SeedService {

    void seedAuthors() throws IOException;

    void seedBooks() throws IOException;

    void seedCategory() throws IOException;


    default void seedAllData() throws IOException {
        seedCategory();
        seedAuthors();
        seedBooks();
    }
}
