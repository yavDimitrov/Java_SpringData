package bg.softuni.l13_advanced_quering;

import bg.softuni.l13_advanced_quering.entities.Ingredient;
import bg.softuni.l13_advanced_quering.entities.Shampoo;
import bg.softuni.l13_advanced_quering.services.IngrediantService;
import bg.softuni.l13_advanced_quering.services.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class Main implements CommandLineRunner {

    private final ShampooService shampooService;

    private final IngrediantService ingredientService;

    @Autowired
    public Main(ShampooService shampooService, IngrediantService ingredientService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scan = new Scanner(System.in);

    /*

    String size = scan.nextLine();

        for (Shampoo shampoo : this.shampooService.findBySizeOrderById(size)) {
            System.out.println(shampoo);
        }


        for (Shampoo shampoo : this.shampooService.findByIngredient(ingredients)) {
            System.out.println(shampoo);
        }

        */

/*
// EXCERSISE 02

        String nextLine = scan.nextLine();

        List<String> ingredients = new ArrayList<>();

        while(!nextLine.isBlank()) {
            ingredients.add(nextLine);

            nextLine = scan.nextLine();
        }

        for (Shampoo shampoo : this.shampooService.findByIngredients(ingredients)) {
            System.out.println(shampoo);
        }
*/
/*
      // EXCERSISE 03

      String size = scan.nextLine();
        long labelId=Long.parseLong((scan.nextLine()));


        for (Shampoo shampoo : this.shampooService.findBySizeOrLabelId(size, labelId)) {
            System.out.println(shampoo);
        }

        */
/*
  //EXERCISE 04

  String price = scan.nextLine();



        for (Shampoo shampoo : this.shampooService.findWithPriceGreaterThan(price)) {
            System.out.println(shampoo);*/

/*
     //EXERCISE 05

     String name = scan.nextLine();

        for (Ingredient ingredient : this.ingredientService.selectByName(name)) {
            System.out.println(ingredient);
        }*/

/*          EXERCISE 06
        String nextLine = scan.nextLine();

        List<String> ingredients = new ArrayList<>();

        while(!nextLine.isBlank()) {
            ingredients.add(nextLine);

            nextLine = scan.nextLine();
        }


        for (Ingredient ingredient : this.ingredientService.selectByNames(ingredients)) {
            System.out.println(ingredient);
        } */
/*    EXERCISE 07

        String price = scan.nextLine();

        System.out.println(this.shampooService.countWithPriceLowerThan(price));*/

        int count = Integer.parseInt(scan.nextLine());


        for (Shampoo shampoo : this.shampooService.findWithIngredienCountLessThan(count)) {
            System.out.println(shampoo);


        }
    }
}

