package bg.softuni.e12_bookshop.services.seed;

import bg.softuni.e12_bookshop.services.author.AuthorService;
import bg.softuni.e12_bookshop.services.book.BookService;
import bg.softuni.e12_bookshop.services.category.CategoryService;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static bg.softuni.e12_bookshop.Constants.FilePath.AUTHOR_FILE_NAME;
import static bg.softuni.e12_bookshop.Constants.FilePath.RESOURCE_URL;

@Component
public class SeedServiceImpl implements SeedService{


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
        Files.readAllLines(Path.of(RESOURCE_URL + AUTHOR_FILE_NAME));

        System.out.println();
    }

    @Override
    public void seedBooks() {

    }

    @Override
    public void seedCategory() {

    }
}
