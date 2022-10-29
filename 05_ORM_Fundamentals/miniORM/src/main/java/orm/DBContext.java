package orm;

public interface DBContext <E>{
    boolean persist(E entity);

    Iterable<E> find();
    Iterable<E> find(String where);

    Iterable<E> findFirst();
    Iterable<E> findFirst(String where);
}
