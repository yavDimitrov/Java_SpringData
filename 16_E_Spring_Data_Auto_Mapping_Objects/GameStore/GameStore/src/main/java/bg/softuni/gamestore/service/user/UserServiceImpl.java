package bg.softuni.gamestore.service.user;

import bg.softuni.gamestore.domain.dtos.UserRegister;
import bg.softuni.gamestore.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String registerUser(String[] args) {
        final String email = args[1];
        final String password = args[2];
        final String confirmPassword = args[3];
        final String fullName = args[4];
        final UserRegister userRegister = new UserRegister(email, password, confirmPassword, fullName);

        return null;
    }
}
