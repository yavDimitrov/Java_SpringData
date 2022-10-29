package orm;

import java.sql.Connection;

public class entityManager<E> implements DBContext<E> {
    private final Connection connection;

    public entityManager(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean persist(E entity) {
        return false;
    }

    @Override
    public Iterable find() {
        return null;
    }

    @Override
    public Iterable find(String where) {
        return null;
    }

    @Override
    public Iterable findFirst() {
        return null;
    }

    @Override
    public Iterable findFirst(String where) {
        return null;
    }
}
