package bg.softuni.e12_bookshop.repositories;

import bg.softuni.e12_bookshop.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
        Optional<List<Book>> findAllByReleaseDateAfter(LocalDate localDate);

}
