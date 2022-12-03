package bg.softuni.e12_bookshop.services.book;

import bg.softuni.e12_bookshop.domain.enums.AgeRestriction;
import bg.softuni.e12_bookshop.domain.enums.EditionType;
import bg.softuni.e12_bookshop.entities.Author;
import bg.softuni.e12_bookshop.entities.Book;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BookService {

    void seedBooks(List<Book> books);

    List<Book> findAllByReleaseDateAfter(LocalDate date);

    List<Book> findAllByAuthorFirstNameAndAuthorLastNameOOrderByReleaseDateDescTitleAsc(String firstName, String lastName);

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, Integer copiesNumber);

}
