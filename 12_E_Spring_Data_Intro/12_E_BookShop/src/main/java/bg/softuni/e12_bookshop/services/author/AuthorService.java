package bg.softuni.e12_bookshop.services.author;

import bg.softuni.e12_bookshop.entities.Author;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AuthorService {
    void seedAuthors(List<Author> authors);

    boolean isDataSeeded();

    Author getRandomAuthor();

    List<Author> findDistinctByBookBefore(LocalDate date);

}
