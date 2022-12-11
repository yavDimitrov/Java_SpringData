package bg.softuni.e12_bookshop.repositories;

import bg.softuni.e12_bookshop.domain.dto.BookInformation;
import bg.softuni.e12_bookshop.domain.enums.AgeRestriction;
import bg.softuni.e12_bookshop.domain.enums.EditionType;
import bg.softuni.e12_bookshop.domain.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
        Optional<List<Book>> findAllByReleaseDateAfter(LocalDate localDate);

        Optional<List<Book>> findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String firstName, String lastName);

        Optional<List<Book>> findAllByAgeRestriction(AgeRestriction ageRestriction);
        Optional<List<Book>> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, Integer copiesNumber);

        Optional<List<Book>> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal low, BigDecimal greater);

        Optional<List<Book>> findAllByReleaseDateStartsWith(String date);

        Optional<List<Book>> findAllByReleaseDateBefore(LocalDate date);

        Optional<List<Book>> findAllByTitleContaining(String contains);

        Optional<List<Book>> findAllByAuthorLastNameStartingWith(String prefix);

        @Query("SELECT count(b) FROM Book b WHERE LENGTH(b.title) > :length")
        Optional<Integer> findCountOfBooksByTitleLongerThan(Integer length);


        @Query ("SELECT NEW bg.softuni.e12_bookshop.domain.dto.BookInformation(b.title, b.editionType, b.ageRestriction, b.price)"
                + " FROM Book AS b WHERE b.title = :title")
        Optional<BookInformation> findFirstByTitleWithQuerry(String title);


        Optional<BookInformation> findFirstByTitle(String title);

        @Transactional
        @Modifying
        @Query("UPDATE Book b SET b.copies = b.copies +:copies WHERE b.releaseDate > :date")
        int IncreaseBookCopies(LocalDate date, int copies);

        @Transactional
        int deleteAllByCopiesLessThan (Integer copies);





}
