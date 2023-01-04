package bg.softuni.gamestore.domain.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table
public class User extends BaseEntity{

    private String email;
    private String password;
    private String fullName;

    private Set<Games> games;


}
