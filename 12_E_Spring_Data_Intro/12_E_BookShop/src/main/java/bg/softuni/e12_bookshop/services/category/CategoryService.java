package bg.softuni.e12_bookshop.services.category;

import bg.softuni.e12_bookshop.domain.entities.Category;

import java.util.List;
import java.util.Set;

public interface CategoryService {

    void seedCategory(List<Category> categories);

    boolean isDataSeeded();

    Set<Category> getRandomCategories();
}
