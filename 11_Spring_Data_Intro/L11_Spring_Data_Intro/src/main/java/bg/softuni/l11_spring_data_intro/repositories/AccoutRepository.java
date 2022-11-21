package bg.softuni.l11_spring_data_intro.repositories;

import bg.softuni.l11_spring_data_intro.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccoutRepository extends JpaRepository<Account, Long> {
}
