import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class P02_changeCasing_Alternative {
    private static final String DATABASE_NAME = "soft_uni";
    private static final String UPDATE_ALL_TOWNS_WITH_LENGHT_NAME_MORE_THAN_5
            = "UPDATE towns t SET t.name = UPPER(t.name) WHERE LENGTH(t.name) > 5";


    public static void main(String[] args) {
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(DATABASE_NAME);

        final EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

       entityManager.createQuery(UPDATE_ALL_TOWNS_WITH_LENGHT_NAME_MORE_THAN_5).executeUpdate();


        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
