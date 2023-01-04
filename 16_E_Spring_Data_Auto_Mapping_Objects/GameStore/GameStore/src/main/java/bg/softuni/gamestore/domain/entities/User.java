package bg.softuni.gamestore.domain.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table
public class User extends BaseEntity{

    @Column(nullable = false)
    private String email;
    @Column(nullable = false)

    private String password;
    @Column(name = "full_name", nullable = false)
    private String fullName;

    @ManyToMany
    private Set<Games> games;

    @OneToMany
    private Set<Orders> orders;

    @Column
    private Boolean isAdmin;

    public User() {
        this.games = new HashSet<>();
        this.orders = new HashSet<>();
    }

    public User(String email, String password, String fullName) {
        this();
        this.email = email;
        this.password = password;
        this.fullName = fullName;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Set<Games> getGames() {
        return games;
    }

    public void setGames(Set<Games> games) {
        this.games = games;
    }

    public void setIsAdmin (Boolean isAdmin){
        this.isAdmin = isAdmin;
    }

    public Boolean getIsAdmin() {
        return this.isAdmin;
    }
}
