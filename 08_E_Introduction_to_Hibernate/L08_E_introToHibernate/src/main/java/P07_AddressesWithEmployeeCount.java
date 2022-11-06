import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class P07_AddressesWithEmployeeCount {
    public static void main(String[] args) {
        final EntityManager entityManager = Persistence.createEntityManagerFactory("soft_uni")
                .createEntityManager();

        entityManager.createQuery("")
    }
}
