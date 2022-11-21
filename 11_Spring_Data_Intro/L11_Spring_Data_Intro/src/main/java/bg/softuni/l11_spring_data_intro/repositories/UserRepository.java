package bg.softuni.l11_spring_data_intro.repositories;

import bg.softuni.l11_spring_data_intro.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, Long>{
    Optional<User> findByUsername(String username);
}
