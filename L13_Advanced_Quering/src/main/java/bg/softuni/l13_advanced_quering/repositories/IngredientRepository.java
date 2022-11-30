package bg.softuni.l13_advanced_quering.repositories;

import bg.softuni.l13_advanced_quering.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findByNameStartingWith(String name);

    List<Ingredient> findByNameInOrderByPrice(List<String> names);


    void deleteByName(String name);

    @Query("UPDATE Ingredient AS i SET i.price = i.price*1.1")
    @Modifying
    void updateAllPrice();
}
