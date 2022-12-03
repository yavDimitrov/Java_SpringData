package bg.softuni.e12_bookshop;

import bg.softuni.e12_bookshop.domain.enums.AgeRestriction;
import bg.softuni.e12_bookshop.domain.enums.EditionType;
import bg.softuni.e12_bookshop.entities.Book;
import bg.softuni.e12_bookshop.services.author.AuthorService;
import bg.softuni.e12_bookshop.services.book.BookService;
import bg.softuni.e12_bookshop.services.seed.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final BookService bookService;
    private final AuthorService authorService;
    private final Scanner scanner;


    @Autowired
    public ConsoleRunner( BookService bookService, AuthorService authorService) {
                this.bookService = bookService;
                this.authorService = authorService;
                this.scanner = new Scanner(System.in);
    }


    @Override
    public void run(String... args) {

        final  String arg = scanner.nextLine();

        this.bookService.findAllByPriceLessThanOrPriceGreaterThan(BigDecimal.valueOf(5L), BigDecimal.valueOf(40L))
                .stream().map(Book::getBookTitleAndPriceFormat).forEach(System.out::println);

    }

}

