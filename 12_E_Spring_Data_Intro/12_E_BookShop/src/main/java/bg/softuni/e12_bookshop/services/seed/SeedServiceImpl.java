package bg.softuni.e12_bookshop.services.seed;

import bg.softuni.e12_bookshop.entities.Author;
import bg.softuni.e12_bookshop.entities.Category;
import bg.softuni.e12_bookshop.services.author.AuthorService;
import bg.softuni.e12_bookshop.services.book.BookService;
import bg.softuni.e12_bookshop.services.category.CategoryService;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
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
//        Files.readAllLines(Path.of(RESOURCE_URL + AUTHOR_FILE_NAME))
//                .stream().filter(s -> !s.isBlank())
//                .map(s-> {
//                    String[] firstAndLastName = s.split(" ");
//
//                    return Author.builder().firstName(firstAndLastName[0])
//                            .lastName(firstAndLastName[1])
//                            .build();
//                });
        if (!this.authorService.isDataSeeded()) {
            this.authorService.seedAuthors(Files.readAllLines(Path.of(RESOURCE_URL + AUTHOR_FILE_NAME))
                    .stream().filter(first -> !first.isBlank())
                    .map(firstAndLastName -> Author.builder()
                            .firstName(firstAndLastName.split(" ")[0])
                            .lastName(firstAndLastName.split(" ")[1])
                            .build()).collect(Collectors.toList()));
        }
    }

    @Override
    public void seedBooks() throws IOException {
        Files.readAllLines(Path.of(RESOURCE_URL + BOOK_FILE_NAME))
                .forEach(line -> {

                    
                });


    }

    @Override
    public void seedCategory() throws IOException {
        if(!this.categoryService.isDataSeeded()) {
            this.categoryService.seedCategory(Files.readAllLines(Path.of(RESOURCE_URL + CATEGORY_FILE_NAME))
                    .stream()
                    .filter(s -> !s.isBlank())
                    .map(name -> Category.builder().name(name).build())
                    .collect(Collectors.toList()));
        }
    }
}
