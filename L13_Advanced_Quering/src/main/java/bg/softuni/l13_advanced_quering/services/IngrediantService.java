package bg.softuni.l13_advanced_quering.services;

import bg.softuni.l13_advanced_quering.entities.Ingredient;

import java.util.List;

public interface IngrediantService {

 List<Ingredient> selectByName(String name);

 List<Ingredient> selectByNames(List<String> name);



}
