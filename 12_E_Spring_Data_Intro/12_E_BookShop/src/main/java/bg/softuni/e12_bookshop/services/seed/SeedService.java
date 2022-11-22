package bg.softuni.e12_bookshop.services.seed;

public interface SeedService {

    void seedAuthors();

    void seedBooks();

    void seedCategory();


    default void seedAllData() {
        seedAuthors();
        seedBooks();
        seedCategory();
    }
}
