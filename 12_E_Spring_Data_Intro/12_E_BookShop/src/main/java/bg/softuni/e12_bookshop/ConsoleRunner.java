package bg.softuni.e12_bookshop;

import bg.softuni.e12_bookshop.services.author.AuthorService;
import bg.softuni.e12_bookshop.services.book.BookService;
import bg.softuni.e12_bookshop.services.seed.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final LocalDate BOOK_YEAR_AFTER = LocalDate.of(2000,1,1);
    private final LocalDate BOOK_YEAR_BEFORE = LocalDate.of(2000,1,1);

    private final SeedService seedService;
    private final BookService bookService;
    private final AuthorService authorService;


    @Autowired
    public ConsoleRunner(SeedService seedService, BookService bookService, AuthorService authorService) {
        this.seedService = seedService;
        this.bookService = bookService;
        this.authorService = authorService;
    }


    @Override
    public void run(String... args) throws Exception {
            this.seedService.seedAllData();
            this.getAllBooksAfterAGivenYear();
            this.getAllAuthorsWithBooksReleaseDateBefore();
            this.getAllOrderByBooks();
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


}
