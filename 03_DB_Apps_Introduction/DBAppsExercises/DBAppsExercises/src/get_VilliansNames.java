import java.sql.*;
import java.util.Properties;

public class get_VilliansNames {

    private static final String GET_VILLAINS_NAMES = "SELECT v.name, count(distinct mv.minion_id) AS minions_count" +
            " FROM villains AS v" +
            "    JOIN minions_villains AS mv ON v.id = mv.villain_id" +
            " GROUP BY mv.villain_id" +
            " HAVING minions_count > ?" +
            " ORDER BY minions_count";

    private static final String COLOMN_LABEL_MINIONS_COUNT = "minions_count";
    private static final String PRINT_FORMAT = "%s %d";

    public static void main(String[] args) throws SQLException {
    final Connection connection = Utils.getSQLConnection();

    final PreparedStatement statement = connection.prepareStatement(GET_VILLAINS_NAMES);
    
    statement.setInt(1, 15);
        final ResultSet resultSet = statement.executeQuery();

        while(resultSet.next()){
            final String villainName = resultSet.getString(Constraints.COLOMN_LABEL_NAME);
            final int minionsCount = resultSet.getInt(COLOMN_LABEL_MINIONS_COUNT);

            System.out.printf(PRINT_FORMAT,villainName, minionsCount);
                    }
        connection.close();
    }
}

