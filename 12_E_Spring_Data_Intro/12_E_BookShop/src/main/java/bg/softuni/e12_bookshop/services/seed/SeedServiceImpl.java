package bg.softuni.e12_bookshop.services.seed;

import bg.softuni.e12_bookshop.domain.enums.AgeRestriction;
import bg.softuni.e12_bookshop.domain.enums.EditionType;
import bg.softuni.e12_bookshop.entities.Author;
import bg.softuni.e12_bookshop.entities.Book;
import bg.softuni.e12_bookshop.entities.Category;
import bg.softuni.e12_bookshop.services.author.AuthorService;
import bg.softuni.e12_bookshop.services.book.BookService;
import bg.softuni.e12_bookshop.services.category.CategoryService;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static bg.softuni.e12_bookshop.Constants.FilePath.*;

@Component
public class SeedServiceImpl implements SeedService {


    private final AuthorService authorService;
    private final BookService bookService;
    private final CategoryService categoryService;


    public SeedServiceImpl(AuthorService authorService, BookService bookService, CategoryService categoryService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedAuthors() throws IOException {
      this.authorService.seedAuthors(Files.readAllLines(Path.of(RESOURCE_URL + AUTHOR_FILE_NAME))
                    .stream()
                    .filter(s -> !s.isBlank())
                    .map(s -> Author.builder()
                            .firstName(s.split(" ")[0])
                            .lastName(s.split(" ")[1])
                            .build()).collect(Collectors.toList()));

/*            if (!this.authorService.isDataSeeded()) {
            this.authorService.seedAuthors(Files.readAllLines(Path.of(RESOURCE_URL + AUTHOR_FILE_NAME))
                    .stream().filter(first -> !first.isBlank())
                    .map(firstAndLastName -> Author.builder()
                            .firstName(firstAndLastName.split(" ")[0])
                            .lastName(firstAndLastName.split(" ")[1])
                            .build()).collect(Collectors.toList()));            */

//        Files.readAllLines(Path.of(RESOURCE_URL + AUTHOR_FILE_NAME))
//                .stream().filter(s -> !s.isBlank())
//                .map(s-> {
//                    String[] firstAndLastName = s.split(" ");
//
//                    return Author.builder().firstName(firstAndLastName[0])
//                            .lastName(firstAndLastName[1])
//                            .build();
//                });
        }
    }

    @Override
    public void seedBooks() throws IOException {
        List<Book> books = Files.readAllLines(Path.of(RESOURCE_URL + BOOK_FILE_NAME))
                .stream()
                .filter(s -> !s.isBlank())
                .map(row -> {
                    String[] data = row.split("\\s+");

                    String title = Arrays.stream(data)
                            .skip(5)
                            .collect(Collectors.joining(" "));


//                   Author author = authorService.getRandomAuthor();
//                    EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];
//                   LocalDate releaseDate = LocalDate.parse(data[1],DateTimeFormatter.ofPattern("d/M/yyyy"));
//                    int copies = Integer.parseInt(data[2]);
//                   BigDecimal price = new BigDecimal(data[3]);
//                   AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];
//                    Set<Category> categories = categoryService.getRandomCategories();


                    return Book.builder()
                            .title(title)
                            .editionType(EditionType.values()[Integer.parseInt(data[0])])
                            .price(new BigDecimal(data[3]))
                            .releaseDate(LocalDate.parse(data[1],
                                    DateTimeFormatter.ofPattern("d/M/yyyy")))
                            .ageRestriction(AgeRestriction
                                    .values()[Integer.parseInt(data[4])])
                            .author(authorService.getRandomAuthor())
                            .categories(this.categoryService.getRandomCategories())
                            .copies(Integer.parseInt(data[2]))
                            .build();

                })
                .collect(Collectors.toList());

        this.bookService.seedBooks(books);


    }

    @Override
    public void seedCategory() throws IOException {
        if (!this.categoryService.isDataSeeded()) {
            this.categoryService.seedCategory(Files.readAllLines(Path.of(RESOURCE_URL + CATEGORY_FILE_NAME))
                    .stream()
                    .filter(s -> !s.isBlank())
                    .map(name -> Category.builder().name(name).build())
                    .collect(Collectors.toList()));
        }
    }
}
