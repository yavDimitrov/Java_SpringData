import entities.User;
import orm.Connector;
import orm.entityManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connector.createConnection("root", "", "soft_uni");

        Connection connection = Connector.getConnection();

        entityManager<User> userManager = new entityManager<>(connection);
        User user = new User("First", 28, LocalDate.now());

        userManager.persist(user);

    }
}
