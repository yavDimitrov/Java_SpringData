package bg.softuni.l11_spring_data_intro.repositories;

import bg.softuni.l11_spring_data_intro.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long>{
}
