package bg.softuni.l13_advanced_quering;

import bg.softuni.l13_advanced_quering.entities.Shampoo;
import bg.softuni.l13_advanced_quering.entities.Size;
import bg.softuni.l13_advanced_quering.repositories.ShampooRepository;
import bg.softuni.l13_advanced_quering.services.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Main implements CommandLineRunner {

    private final ShampooService shampooService;

    @Autowired
    public Main (ShampooService shampooService){
        this.shampooService = shampooService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scan = new Scanner(System.in);

        String size = scan.nextLine();

        for (Shampoo shampoo : this.shampooService.findBySizeOrderById(size)) {
            System.out.println(shampoo);
        }

    }
}
