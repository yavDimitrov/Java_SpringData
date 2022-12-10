package bg.softuni.e12_bookshop.repositories;

import bg.softuni.e12_bookshop.domain.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findAuthorById(Long Id);

    Optional<List<Author>> findDistinctByBooksReleaseDateBefore(LocalDate date);

  //  Optional<List<Author>> findAllGroupByBooksOrderByCount();

    @Query ("SELECT a FROM Author a order by a.books.size")
    Optional<List<Author>> findAllDistinctOrderByBooks();

    Optional<List<Author>> findByFirstNameEndingWith(String suffix);

}

