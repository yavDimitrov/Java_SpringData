package bg.softuni.l13_advanced_quering.services;

import bg.softuni.l13_advanced_quering.entities.Ingredient;
import bg.softuni.l13_advanced_quering.repositories.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IngredientServiceImpl implements IngrediantService{

    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> selectByName(String name) {
        return this.ingredientRepository.findByNameStartingWith(name);
    }

    @Override
    public List<Ingredient> selectByNames(List<String> names) {
        return this.ingredientRepository.findByNameInOrderByPrice(names);
    }


}
