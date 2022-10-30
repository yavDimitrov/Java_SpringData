package orm;

import org.w3c.dom.css.CSSStyleRule;
import orm.annotations.Column;
import orm.annotations.Entity;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EntityManager<E> implements DBContext<E> {
    private final Connection connection;

    public EntityManager(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean persist(E entity) throws SQLException, IllegalAccessException {
        String tableName = this.getTableName(entity);
        String fieldList = this.getDBFieldsWithoutIdentity(entity);
        String valueList = this.getValuesWithoutIdentity(entity);

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
        String tableName = this.getTableName(???);

        String sql = "SELECT * FROM %s LIMIT 1";

        ResultSet resultSet = this.connection.prepareStatement(sql).executeQuery();
        return null;
    }

    @Override
    public Iterable findFirst(String where) {
        return null;
    }

    private String getTableName(E entity) {
        Entity annotation = entity.getClass().getAnnotation(Entity.class);

        if(annotation == null) {
            throw new ORMException("Provided class does not have Entity annotation");
        }

        return annotation.name();
    }

    private String getDBFieldsWithoutIdentity(E entity) {
/*        for (Field declaredField : entity.getClass().getDeclaredFields()) {
            if(declaredField.getAnnotation(Column.class) != null){
                // TODO: save
            }

        }*/

       return Arrays.stream(entity.getClass().getDeclaredFields())
                .filter(f -> f.getAnnotation(Column.class) != null)
                .map(f -> f.getAnnotation(Column.class).name())
                .collect(Collectors.joining(","));
    }

    private String getValuesWithoutIdentity(E entity) throws IllegalAccessException {
        Field[] declaredFields = entity.getClass().getDeclaredFields();
        List<String> result = new ArrayList<>();


        for (Field declaredField : declaredFields) {
            if(declaredField.getAnnotation(Column.class) == null) {
                continue;
            }
            declaredField.setAccessible(true);
            Object value = declaredField.get(entity);
            result.add("\"" + value.toString() + "\"");
        }

        return String.join(",", result);
    }
}
