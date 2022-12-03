package bg.softuni.e12_bookshop.repositories;

import bg.softuni.e12_bookshop.domain.enums.AgeRestriction;
import bg.softuni.e12_bookshop.domain.enums.EditionType;
import bg.softuni.e12_bookshop.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.print.attribute.standard.Copies;
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

}
