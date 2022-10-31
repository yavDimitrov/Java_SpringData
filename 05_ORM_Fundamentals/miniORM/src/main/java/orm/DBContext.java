package orm;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public interface DBContext <E>{
    boolean persist(E entity) throws SQLException, IllegalAccessException;

    Iterable<E> find();
    Iterable<E> find(String where);

    E findFirst(Class<E> entityType) throws SQLException;
    E findFirst(Class<E> entityType,String where) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
}
