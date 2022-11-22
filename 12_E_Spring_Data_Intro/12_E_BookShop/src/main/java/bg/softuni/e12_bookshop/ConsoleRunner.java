package bg.softuni.e12_bookshop;

import bg.softuni.e12_bookshop.repositories.AuthorRepository;
import bg.softuni.e12_bookshop.repositories.BookRepository;
import bg.softuni.e12_bookshop.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;
    private final BookRepository bookRepository;


    @Autowired
    public ConsoleRunner(AuthorRepository authorRepository, CategoryRepository categoryRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
        this.bookRepository = bookRepository;
    }


    @Override
    public void run(String... args) throws Exception {

    }

}
