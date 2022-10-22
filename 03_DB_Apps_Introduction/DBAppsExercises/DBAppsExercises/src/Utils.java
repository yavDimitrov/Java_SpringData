import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

 enum Utils {
    ;
    static Connection getSQLConnection() throws SQLException {
       final Properties properties = new Properties();

        properties.setProperty(Constraints.USER_KEY, Constraints.USER_VALUE);
        properties.setProperty(Constraints.PASSWORD_KEY, Constraints.PASSWORD_VALUE);

        return DriverManager.getConnection(Constraints.JDBC_URL, properties);

    }
}
