package bg.softuni.l11_spring_data_intro.services;

import bg.softuni.l11_spring_data_intro.models.User;

public interface UserService {
    void register(String username, int age);

    //User findByUsername(String username);
}
