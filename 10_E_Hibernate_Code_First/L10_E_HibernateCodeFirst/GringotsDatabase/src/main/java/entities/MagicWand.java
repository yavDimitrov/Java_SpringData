package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table
public class MagicWand {

    @Id
    @Column
    private Long id;

    @Column (length = 100)
    @OneToOne
    private String creator;

    @Column
  //  @Size
    private Long size;

}
