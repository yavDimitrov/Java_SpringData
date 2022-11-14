package entities;


import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Wizzard {

    @Id
    @Column
    private long id;

    @Column(length = 50)
    private String firstName;

    @Column(length = 60, nullable = true)
    private String lastName;

    @Column(length = 1000)
    private String notes;

    @Column
    @NotNull
    private long age;

    @OneToOne
    @JoinColumn
    private MagicWand magicWand;

    @OneToMany
    private List<Deposit> deposits;


}
