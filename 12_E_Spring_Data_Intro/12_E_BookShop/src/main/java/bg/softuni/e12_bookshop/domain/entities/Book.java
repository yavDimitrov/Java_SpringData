package bg.softuni.e12_bookshop.domain.entities;

import bg.softuni.e12_bookshop.domain.enums.AgeRestriction;
import bg.softuni.e12_bookshop.domain.enums.EditionType;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Book extends BaseEntity{

    @Column(nullable = false, length = 50)
    private String title;

    @Column(length = 1000)
    private String description;

    @Enumerated(EnumType.STRING)
    private EditionType editionType;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer copies;

    @Column(name="release_date")
    private LocalDate releaseDate;

    @Enumerated(EnumType.STRING)
    private AgeRestriction ageRestriction;

    @ManyToOne
    private Author author;

    @ManyToMany
    private Set<Category> categories;

    public String getBookTitleAndPriceFormat() {
        return this.title + " - $" + this.price;
    }
    public String getBookTitleEditionTypeAndPriceFormat() {
        return this.title + " " + this.editionType + " " + this.price;
    }


    public String getBookTitleandAuthorFullNameFormat() {
        return this.title + " (" + this.author.getFullName() + ")";
    }


}

