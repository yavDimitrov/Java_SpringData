package entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SortComparator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table
public class Competition extends BaseEntity{


    @Column
    private String name;

    @ManyToOne
    private CompetitionTypes types;
}
