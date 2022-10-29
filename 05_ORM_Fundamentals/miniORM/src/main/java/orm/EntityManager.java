package orm;

import java.sql.Connection;
import java.sql.SQLException;

public class EntityManager<E> implements DBContext<E> {
    private final Connection connection;

    public EntityManager(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean persist(E entity) throws SQLException {
        String tableName = this.getTableName(entity);
        String fieldList = this.getDBFieldsWithoutIdentity(entity);
        String valueList = this.getInsertValues(entity);

        String sql = String.format("INSERT INTO %s (%s) VALUES(%s)", tableName, fieldList, valueList);

        return this.connection.prepareStatement(sql).execute();

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

    private String getTableName(E entity) {
    }
}
