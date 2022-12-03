package bg.softuni.e12_bookshop;

import bg.softuni.e12_bookshop.domain.enums.AgeRestriction;
import bg.softuni.e12_bookshop.domain.enums.EditionType;
import bg.softuni.e12_bookshop.entities.Book;
import bg.softuni.e12_bookshop.services.author.AuthorService;
import bg.softuni.e12_bookshop.services.book.BookService;
import bg.softuni.e12_bookshop.services.seed.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class ConsoleRunnerUtils {
    private final LocalDate BOOK_YEAR_AFTER = LocalDate.of(2000,1,1);
    private final LocalDate BOOK_YEAR_BEFORE = LocalDate.of(2000,1,1);

    private final SeedService seedService;
    private final BookService bookService;
    private final AuthorService authorService;

    @Autowired
    public ConsoleRunnerUtils(SeedService seedService, BookService bookService, AuthorService authorService) {
        this.seedService = seedService;
        this.bookService = bookService;
        this.authorService = authorService;
    }

    private void getAllBooksAfterAGivenYear() {
        this.bookService.findAllByReleaseDateAfter(BOOK_YEAR_AFTER)
                .forEach(book -> System.out.println(book.getTitle()));

    }

    private void getAllAuthorsWithBooksReleaseDateBefore() {
        this.authorService
                .findDistinctByBooksReleaseDateBefore(BOOK_YEAR_BEFORE)
                .forEach(author -> System.out.println(author.getFirstName()+ " " + author.getLastName()));

    }

    private void getAllOrderByBooks() {
        this.bookService
                .findAllByAuthorFirstNameAndAuthorLastNameOOrderByReleaseDateDescTitleAsc("George", "Powell")
                .forEach(book -> System.out.println(book.getTitle()+ " "
                        + book.getReleaseDate() + " " + book.getCopies()));

    }

/*    private void getAllOrderByBooks() {
        this.authorService
                .findAllOrderByBooks()
                .forEach(author -> System.out.println(author.getFirstName()+ " "
                        + author.getLastName() + " " + author.getBooks().size()));

    }*/
    // EXCERCISE 01
    public void booksTitlesByAgeRestrictions (String ageRestrictionType) {

        final AgeRestriction ageRestriction = AgeRestriction.valueOf(ageRestrictionType.toUpperCase());

        final List<Book> allByAgeRestriction = this.bookService.findAllByAgeRestriction(ageRestriction);

        allByAgeRestriction.stream()
                .map(Book::getTitle).forEach(System.out::println);
    }


   // EXCERCISE 02
    public void goldenBookWithLessThan5KCopies() {

        this.bookService.findAllByEditionTypeAndCopiesLessThan(EditionType.GOLD, 5000)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }



}
