import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Get_Minions_Names {
    private static final String GET_MINION_NAME_AND_AGE_BY_VILLIAN_ID = "SELECT m.name, m.age" +
            " FROM minions AS m" +
            " JOIN minions_villains mv on m.id = mv.minion_id" +
            " WHERE mv.villain_id = ?";

    private static final String VILLAN_NAME_BY_ID = " SELECT v.name FROM villains AS v" +
            " WHERE v.id = ? ";

    private static String NO_VILLLIAN = "No villain with ID %d exists in the database.";
    private static final String VILLAIN_FORMAT = "Villain: %s%n";
    private static String MINIOT_FORMAT = "%d. %s %d%n";
    private static final String COLOMN_AGE = "age";

    public static void main(String[] args) throws SQLException {
        final Connection connection = Utils.getSQLConnection();

        final int villian_Id = new Scanner(System.in).nextInt();

        final PreparedStatement villianStatement = connection.prepareStatement(VILLAN_NAME_BY_ID);

        villianStatement.setInt(1, villian_Id);

        final ResultSet villianSet = villianStatement.executeQuery();

        if (!villianSet.next()) {
            System.out.printf(NO_VILLLIAN, villian_Id);
            connection.close();
            return;
        }

        final String villanName = villianSet.getString(Constraints.COLOMN_LABEL_NAME);

        System.out.printf(VILLAIN_FORMAT, villanName);

        final PreparedStatement minionsStatement = connection.prepareStatement(GET_MINION_NAME_AND_AGE_BY_VILLIAN_ID);

        minionsStatement.setInt(1, villian_Id);

        final ResultSet minionsSet = minionsStatement.executeQuery();

        for (int index = 1; minionsSet.next(); index++) {
            final String minionName = minionsSet.getString(Constraints.COLOMN_LABEL_NAME);
            final int minionAge = minionsSet.getInt(COLOMN_AGE);

            System.out.printf(MINIOT_FORMAT, index, minionName, minionAge);
        }
        connection.close();
    }
}

