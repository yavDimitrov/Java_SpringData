package orm;

import java.sql.SQLException;

public interface DBContext <E>{
    boolean persist(E entity) throws SQLException;

    Iterable<E> find();
    Iterable<E> find(String where);

    Iterable<E> findFirst();
    Iterable<E> findFirst(String where);
}
