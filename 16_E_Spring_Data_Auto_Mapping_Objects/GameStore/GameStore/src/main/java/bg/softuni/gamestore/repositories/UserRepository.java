package bg.softuni.gamestore.repositories;

import bg.softuni.gamestore.domain.entities.Game;
import bg.softuni.gamestore.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

