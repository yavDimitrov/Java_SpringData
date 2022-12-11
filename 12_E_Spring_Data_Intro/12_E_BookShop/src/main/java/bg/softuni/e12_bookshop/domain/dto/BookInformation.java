package bg.softuni.e12_bookshop.domain.dto;

import bg.softuni.e12_bookshop.domain.enums.AgeRestriction;
import bg.softuni.e12_bookshop.domain.enums.EditionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
public class BookInformation {

    private String title;

    private EditionType editionType;

    private AgeRestriction ageRestriction;

    private BigDecimal price;


    @Override
    public String toString() {
        return this.title + " "
                + this.editionType.name() +  " "
                + this.ageRestriction.name() + " "
                + this.price;
    }
}


