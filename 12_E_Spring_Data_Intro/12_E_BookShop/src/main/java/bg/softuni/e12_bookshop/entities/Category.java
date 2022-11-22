package bg.softuni.e12_bookshop.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Category extends BaseEntity{

    @Column(nullable = false)
    private String name;

}
