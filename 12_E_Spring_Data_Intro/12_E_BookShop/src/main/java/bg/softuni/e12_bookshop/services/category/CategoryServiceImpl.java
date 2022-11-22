package bg.softuni.e12_bookshop.services.category;

import bg.softuni.e12_bookshop.entities.Category;
import bg.softuni.e12_bookshop.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedCategory(List<Category> categories) {
        this.categoryRepository.saveAll(categories);
    }
}
