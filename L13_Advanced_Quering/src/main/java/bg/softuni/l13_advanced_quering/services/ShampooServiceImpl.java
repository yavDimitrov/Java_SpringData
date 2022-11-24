package bg.softuni.l13_advanced_quering.services;

import bg.softuni.l13_advanced_quering.entities.Shampoo;
import bg.softuni.l13_advanced_quering.entities.Size;
import bg.softuni.l13_advanced_quering.repositories.ShampooRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShampooServiceImpl implements ShampooService{

    private final ShampooRepository shampooRepository;

    public ShampooServiceImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }


    @Override
    public List<Shampoo> findByBrand(String brand) {
        return this.shampooRepository.findByBrand(brand);
    }

    @Override
    public List<Shampoo> findByBrandAndSize(String brand, String size) {
        Size parsed = Size.valueOf(size.toUpperCase());

        return this.shampooRepository.findByBrandAndSize(brand, parsed);
    }

    @Override
    public List<Shampoo> findBySizeOrderById(String size) {

        Size parsed = Size.valueOf(size.toUpperCase());

        return this.shampooRepository.findBySizeOrderByIdDesc(parsed);

    }
}
