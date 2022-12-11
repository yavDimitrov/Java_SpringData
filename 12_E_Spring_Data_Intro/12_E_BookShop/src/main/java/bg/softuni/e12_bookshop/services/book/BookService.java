package bg.softuni.e12_bookshop.services.book;

import bg.softuni.e12_bookshop.domain.dto.BookInformation;
import bg.softuni.e12_bookshop.domain.enums.AgeRestriction;
import bg.softuni.e12_bookshop.domain.enums.EditionType;
import bg.softuni.e12_bookshop.domain.entities.Book;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BookService {

    void seedBooks(List<Book> books);

    boolean isDataSeeded();

    List<Book> findAllByReleaseDateAfter(LocalDate date);

    List<Book> findAllByAuthorFirstNameAndAuthorLastNameOOrderByReleaseDateDescTitleAsc(String firstName, String lastName);

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, Integer copiesNumber);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal low, BigDecimal greater);


    List<Book> findAllByReleaseDateNot(String year);

    List<Book> findAllByReleaseDateBefore(LocalDate date);

    List<Book> findAllByTitleContaining(String contains);

    List<Book>  findAllByAuthorLastNameStartingWith(String prefix);

    Integer findCountOfBooksByTitleLongerThan(Integer length);

    BookInformation findFirstByTitle(String title);

    int IncreaseBookCopies(LocalDate date, int copies);


}
