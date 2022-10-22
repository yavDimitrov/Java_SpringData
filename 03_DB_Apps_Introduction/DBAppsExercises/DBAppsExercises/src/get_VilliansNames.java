import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class get_VilliansNames {
    public static void main(String[] args) throws SQLException {
    final Connection connection = Utils.getSQLConnection();

    final PreparedStatement statement = connection.prepareStatement("")

    }
}
