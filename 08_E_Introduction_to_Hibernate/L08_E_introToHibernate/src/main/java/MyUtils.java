import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class MyUtils {
;

public EntityManager createEntityManager() {
    return Persistence.createEntityManagerFactory("soft_uni").createEntityManager();
}

}
