package bg.softuni.gamestore;

import bg.softuni.gamestore.service.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static bg.softuni.gamestore.constants.Commands.REGISTER_USER;
import static bg.softuni.gamestore.constants.Validation.COMMAND_NOT_FOUND_MESSAGE;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private static final Scanner scanner = new Scanner(System.in);
    private final UserService userService ;

    public ConsoleRunner(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        final String[] input = scanner.nextLine().split("\\|");

        final String command = input[0];

        switch (command) {
         case REGISTER_USER -> userService.registerUser(input);

            default -> COMMAND_NOT_FOUND_MESSAGE;
        }
    }
}
