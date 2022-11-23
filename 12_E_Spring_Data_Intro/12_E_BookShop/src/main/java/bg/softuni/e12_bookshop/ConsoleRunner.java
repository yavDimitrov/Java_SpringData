package bg.softuni.e12_bookshop;

import bg.softuni.e12_bookshop.entities.Book;
import bg.softuni.e12_bookshop.services.book.BookService;
import bg.softuni.e12_bookshop.services.seed.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final LocalDate BOOK_YEAR = LocalDate.of(2000,1,1);

    private final SeedService seedService;
    private final BookService bookService;


    @Autowired
    public ConsoleRunner(SeedService seedService, BookService bookService) {
        this.seedService = seedService;
        this.bookService = bookService;
    }


    @Override
    public void run(String... args) throws Exception {
            this.seedService.seedAllData();
            this.getAllBooksAfterAGivenYear();
    }

    private void getAllBooksAfterAGivenYear() {
        this.bookService.findAllByReleaseDateAfter(BOOK_YEAR)
                .forEach(book -> System.out.println(book.getTitle()));

    }

}
