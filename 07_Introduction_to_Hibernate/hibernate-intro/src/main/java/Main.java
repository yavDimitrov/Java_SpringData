import entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure();

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

/*        Student example = new Student();
        example.setName("Toshko");
        session.persist(example);

        */

        Student fromDB = session.get(Student.class, 0);
        System.out.println(fromDB.getId() + " "  + fromDB.getName());

        session.getTransaction().commit();
        session.close();



    }
}
