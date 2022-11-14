package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Setter
@Getter
@NoArgsConstructor
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
