package bg.softuni.e12_bookshop;

import bg.softuni.e12_bookshop.domain.enums.AgeRestriction;
import bg.softuni.e12_bookshop.domain.enums.EditionType;
import bg.softuni.e12_bookshop.domain.entities.Author;
import bg.softuni.e12_bookshop.domain.entities.Book;
import bg.softuni.e12_bookshop.services.author.AuthorService;
import bg.softuni.e12_bookshop.services.book.BookService;
import bg.softuni.e12_bookshop.services.seed.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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

    // EXCERCISE 03
   public void findAllByPriceLessThanOrPriceGreaterThan() {
       this.bookService.findAllByPriceLessThanOrPriceGreaterThan(BigDecimal.valueOf(5L), BigDecimal.valueOf(40L))
               .stream().map(Book::getBookTitleAndPriceFormat).forEach(System.out::println);

   }

    // EXCERCISE 04
    public void notReleasedBook () {

        this.bookService.findAllByReleaseDateNot("2000")
                .stream()
                .map(Book::getTitle).forEach(System.out::println);
    }

    // EXCERCISE 05
    public void booksReleasedBeforeDate () {

        Scanner scanner = new Scanner(System.in);

        final List<Integer> arg = Arrays.stream(scanner.nextLine().split("-"))
                .map(Integer::parseInt).toList();

        LocalDate loca = LocalDate.of(arg.get(2), arg.get(1), arg.get(0));

        this.bookService.findAllByReleaseDateBefore(LocalDate.of(1992,4,12))
                .stream()
                .map(Book::getBookTitleEditionTypeAndPriceFormat)
                .forEach(System.out::println);
    }

    // EXCERCISE 06
    public void authorsSearch(String arg) {

        this.authorService.findByFirstNameEndingWith(arg)
                .stream()
                .map(Author::getFullName)
                .forEach(System.out::println);
    }

    // EXCERCISE 07
    public void booksSearchByContainingArgument(String arg) {
            this.bookService.findAllByTitleContaining(arg)
                    .stream()
                    .map(Book::getTitle)
                    .forEach(System.out::println);
        }

    // EXCERCISE 08
    public void booksSearchByAuthorLastNameStartingWith(String arg) {

        this.bookService.findAllByAuthorLastNameStartingWith(arg)
                .stream()
                .map(Book::getBookTitleandAuthorFullNameFormat)
                .forEach(System.out::println);

    }


    // EXCERCISE 12
    public void IncreaseBookCopies () {

        Scanner scanner = new Scanner(System.in);

        final String year = scanner.nextLine().replaceAll(" ", "-");
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

        final int copies = Integer.parseInt(scanner.nextLine());


        this.bookService.IncreaseBookCopies(LocalDate.parse(year, dateTimeFormatter), copies);

    }




}
