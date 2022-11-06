import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.StringTokenizer;

public class P02_changeCasing {
    private static final String DATABASE_NAME = "soft_uni";
/*    private static final String UPDATE_ALL_TOWNS_WITH_LENGHT_NAME_MORE_THAN_5
            = "UPDATE towns t SET t.name = UPPER(t.name) WHERE LENGTH(t.name) > 5";*/
    public static void main(String[] args) {
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(DATABASE_NAME);

        final EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

       final List<Town> resultList = entityManager.createQuery("SELECT t FROM Town t", Town.class).getResultList();


        for (Town town : resultList) {
            final String townName = town.getName();

            if(townName.length() <= 5) {
                town.setName(townName.toUpperCase());
                entityManager.persist(town);
            }
            
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
