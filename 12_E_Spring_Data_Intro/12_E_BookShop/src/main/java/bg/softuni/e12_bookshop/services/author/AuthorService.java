package bg.softuni.e12_bookshop.services.author;

import bg.softuni.e12_bookshop.entities.Author;

import java.util.List;

public interface AuthorService {
    void seedAuthors(List<Author> authors);

    boolean isDataSeeded();

    Author findByID ();
}
