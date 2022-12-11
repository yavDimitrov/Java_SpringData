package bg.softuni.e12_bookshop;

import bg.softuni.e12_bookshop.services.author.AuthorService;
import bg.softuni.e12_bookshop.services.book.BookService;
import bg.softuni.e12_bookshop.services.seed.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final BookService bookService;
    private final AuthorService authorService;

    private final SeedService seedService;
    private final Scanner scanner;


    @Autowired
    public ConsoleRunner(BookService bookService, AuthorService authorService, SeedService seedService) {
                this.bookService = bookService;
                this.authorService = authorService;
        this.seedService = seedService;
        this.scanner = new Scanner(System.in);
    }


    @Override
    public void run(String... args) throws IOException {

        this.seedService.seedAllData();

        final  String year = scanner.nextLine().replaceAll(" ", "-");
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

/*        final  LocalDate dateToPass = LocalDate.of(Integer.parseInt(year[2]),
                Month.valueOf(year[1]),
                Integer.parseInt(year[0]));*/
        final  int copies = Integer.parseInt(scanner.nextLine());


        this.bookService.IncreaseBookCopies(LocalDate.parse(year, dateTimeFormatter), copies);
    }








}

