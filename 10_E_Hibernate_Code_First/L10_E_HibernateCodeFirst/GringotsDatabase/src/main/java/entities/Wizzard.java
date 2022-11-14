package entities;


import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
public class Wizzard() {

    @Id
    @Column
    private long id;

    @Column(length = 50)
    private String firstName;

    @Column(length = 60)
    @NotNull
    private String lastName;

    @Column(length = 1000)
    private String notes;

    @Column
    @NotNull
    private long age;

}
