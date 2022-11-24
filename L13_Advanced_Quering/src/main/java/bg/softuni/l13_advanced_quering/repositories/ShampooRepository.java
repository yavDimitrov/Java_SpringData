package bg.softuni.l13_advanced_quering.repositories;

import bg.softuni.l13_advanced_quering.entities.Shampoo;
import bg.softuni.l13_advanced_quering.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {
    List<Shampoo> findByBrand(String brand);

    List<Shampoo> findByBrandAndSize(String brand, Size size);

    List<Shampoo>findBySizeOrderByIdDesc(Size parsed);
}
