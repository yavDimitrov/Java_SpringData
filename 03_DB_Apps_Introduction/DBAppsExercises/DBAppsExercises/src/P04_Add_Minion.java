import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class P04_Add_Minion {
    private static final String GET_TOWN_BY_NAME = " SELECT t.id FROM towns AS t WHERE t.name = ? ";
    private static final String INSERT_INTO_TOWNS = " INSERT INTO towns(name) values(?) ";
    private static final String PRINTF_TOWN = "Town %s was added to the database.%n";
    private static final String ID_COLOMN_LABEL = "id";


    private static final String GET_VILLIAN_BY_NAME = " SELECT v.id FROM villains AS v " +
            " WHERE v.name = ? ";
    private static final String INSERT_INTO_villains =
            " INSERT INTO villains(name, evilness_factor) VALUES (?,?)";
    private static final String VILLAIN_ADDED_FORMAT ="Villain %s was added to the database.%n";
    private static final String EVILNESS_FACTOR = "evil";

    private static final String INSERT_INTO_MIN_villains =" INSERT INTO minions_villains(minion_id, villain_id) VALUES (?,?)";


    private static final String SELECT_LAST_MINION = " SELECT m.id FROM minions m ORDER BY m.id DESC LIMIT 1";
    private static final String INSERT_INTO_MINIONS = "INSERT INTO minions(name, age, town_id) VALUES (?, ?, ?)";

    private static final String RESULT_FORMAT = "Successfully added %s to be minion of %s%n";



    public static void main(String[] args) throws SQLException {
        final Connection connection = Utils.getSQLConnection();

        final Scanner scan = new Scanner(System.in);

        final String[] minionInfo = scan.nextLine().split(" ");

        final String minName = minionInfo[1];
        final int minAge = Integer.parseInt(minionInfo[2]);
        final String minTown = minionInfo[3];

        final String villainName = scan.nextLine().split(" ")[1];

        final int townId = getId(connection,
                List.of(minTown),
                GET_TOWN_BY_NAME,
                INSERT_INTO_TOWNS,
                PRINTF_TOWN);

        final int villainId = getId(connection,
                List.of(villainName, EVILNESS_FACTOR),
                GET_VILLIAN_BY_NAME,
                INSERT_INTO_villains,
                VILLAIN_ADDED_FORMAT);

        final PreparedStatement insertMinionStatement = connection.prepareStatement(INSERT_INTO_MINIONS);

        insertMinionStatement.setString(1, minName);
        insertMinionStatement.setInt(2, minAge);
        insertMinionStatement.setInt(3, townId);

        insertMinionStatement.executeUpdate();

        final PreparedStatement lastMinion = connection.prepareStatement(SELECT_LAST_MINION);

        final ResultSet lastMinionResultSet = lastMinion.executeQuery();
        lastMinionResultSet.next();

        final int lastMinionId = lastMinionResultSet.getInt(ID_COLOMN_LABEL);

        PreparedStatement insertInto_minions_villains = connection.prepareStatement(INSERT_INTO_MIN_villains);

        insertInto_minions_villains.setInt(1, lastMinionId);
        insertInto_minions_villains.setInt(2, villainId);

        insertInto_minions_villains.executeUpdate();

        System.out.printf(RESULT_FORMAT, minName, villainName);

        connection.close();


    }

    private static int getId(Connection connection,
                             List<String> arguments,
                             String selectQuery,
                             String insertQuery,
                             String printFormat) throws SQLException {

        final String name = arguments.get(0);

        PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
        selectStatement.setString(1, name);

        final ResultSet resultSet = selectStatement.executeQuery();

        if(!resultSet.next()) {
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            for (int index = 1; index <= arguments.size() ; index++) {
                insertStatement.setString(index, arguments.get(index-1));
            }

            insertStatement.executeUpdate();
            final ResultSet newResultState = selectStatement.executeQuery();
            newResultState.next();

            System.out.printf(printFormat, name);

            return newResultState.getInt(ID_COLOMN_LABEL);
        }
        return resultSet.getInt(ID_COLOMN_LABEL);
    }
}


