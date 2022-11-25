package bg.softuni.l13_advanced_quering.repositories;

import bg.softuni.l13_advanced_quering.entities.Shampoo;
import bg.softuni.l13_advanced_quering.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {
    List<Shampoo> findByBrand(String brand);

    List<Shampoo> findByBrandAndSize(String brand, Size size);

    List<Shampoo>findBySizeOrderByIdDesc(Size parsed);

    @Query(value = "SELECT s FROM Shampoo AS s " +
    "JOIN s.ingredients AS i " +
    "WHERE i.name = :name")
    List<Shampoo>findByIngredient(@Param("name") String ingredient);

    @Query("SELECT s FROM Shampoo As s " +
    "JOIN s.ingredients AS i " +
    "WHERE i.name IN :ingredients")
    List<Shampoo> findByIngredients(List<String> ingredients);
}
