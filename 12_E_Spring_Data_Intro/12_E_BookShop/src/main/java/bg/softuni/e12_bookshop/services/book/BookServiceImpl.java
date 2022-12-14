package bg.softuni.e12_bookshop.services.book;

import bg.softuni.e12_bookshop.domain.dto.BookInformation;
import bg.softuni.e12_bookshop.domain.enums.AgeRestriction;
import bg.softuni.e12_bookshop.domain.enums.EditionType;
import bg.softuni.e12_bookshop.domain.entities.Book;
import bg.softuni.e12_bookshop.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void seedBooks(List<Book> books) {
        this.bookRepository.saveAll(books);
    }

    @Override
    public boolean isDataSeeded() {
        return this.bookRepository.count() > 0;
    }

    @Override
    public List<Book> findAllByReleaseDateAfter(LocalDate date) {
        return this.bookRepository.findAllByReleaseDateAfter(date).orElseThrow(NoSuchElementException::new);
    }
    @Override
    public List<Book> findAllByAuthorFirstNameAndAuthorLastNameOOrderByReleaseDateDescTitleAsc(String firstName, String lastName) {
        return this.bookRepository.findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(firstName, lastName)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction) {
        return bookRepository.findAllByAgeRestriction(ageRestriction).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, Integer copiesNumber) {
        return this.bookRepository.findAllByEditionTypeAndCopiesLessThan(editionType, copiesNumber)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal low, BigDecimal greater) {
        return this.bookRepository.findAllByPriceLessThanOrPriceGreaterThan(low, greater).orElseThrow(NoSuchElementException::new);
    }


    @Override
    public List<Book> findAllByReleaseDateNot(String year) {
        return this.bookRepository.findAllByReleaseDateStartsWith(year).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Book> findAllByReleaseDateBefore(LocalDate date) {
        return this.bookRepository.findAllByReleaseDateBefore(date).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Book> findAllByTitleContaining(String contains) {
        return this.bookRepository.findAllByTitleContaining(contains).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Book> findAllByAuthorLastNameStartingWith(String prefix) {
        return bookRepository.findAllByAuthorLastNameStartingWith(prefix)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Integer findCountOfBooksByTitleLongerThan(Integer length) {
        return this.bookRepository.findCountOfBooksByTitleLongerThan(length).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public BookInformation findFirstByTitle(String title) {

        final BookInformation bookInformation = this.bookRepository
                .findFirstByTitle(title)
                .orElseThrow(NoSuchElementException::new);

        System.out.println(bookInformation.toString());

        return bookInformation;
    }

    @Override
    public int IncreaseBookCopies(LocalDate date, int copies) {
        final int count = this.bookRepository.IncreaseBookCopies(date, copies);
        System.out.println(count * copies);
        return count;
    }

    @Override
    public int deleteAllByCopiesLessThan(Integer copies) {
        return this.bookRepository.deleteAllByCopiesLessThan(copies);
    }


}
