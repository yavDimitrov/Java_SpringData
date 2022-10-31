import entities.Student;
import entities.User;
import orm.Connector;
import orm.EntityManager;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Struct;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        Connector.createConnection("root", "", "soft_uni");

        Connection connection = Connector.getConnection();

        EntityManager<User> userManager = new EntityManager<>(connection);
        User user = new User("First", 28, LocalDate.now());
        userManager.persist(user);

//        EntityManager<Student> studentManager = new EntityManager<>(connection);
//        Student student = new Student("name");
//        studentManager.persist(student);

        User first = userManager.findFirst(User.class);

        System.out.println(first.getId() + " " + first.getUsername());

        userManager.find("age > 18 AND registration_date > 2022-06-06")
                .forEach(User::toString);

    }
}
