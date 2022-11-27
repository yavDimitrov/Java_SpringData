package bg.softuni.l13_advanced_quering.services;

import bg.softuni.l13_advanced_quering.entities.Shampoo;
import bg.softuni.l13_advanced_quering.entities.Size;

import java.util.List;

public interface ShampooService {
    List<Shampoo> findByBrand(String brand);

    List<Shampoo> findByBrandAndSize(String brand, String size);

    List<Shampoo> findBySizeOrderById(String size);



    List<Shampoo> findByIngredient(String ingredient);

    List<Shampoo> findByIngredients(List<String> ingredients);

    List<Shampoo> findBySizeOrLabelId (String size, long labelId);

    List<Shampoo> findWithPriceGreaterThan(String price);

    long countWithPriceLowerThan(String price);

    List<Shampoo> findWithIngredienCountLessThan(int count);
}
