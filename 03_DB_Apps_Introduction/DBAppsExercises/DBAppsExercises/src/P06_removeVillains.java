import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class P06_removeVillains {

    private static final String GET_VILLAIIN_BY_ID = "";
    private static final String NO_SUCH_VILLAIN = "No such villain was found";
    private static final String GET_MINION_COUNT_BY_VILLAINS_ID = "";
    private static final String COLOMN_LABEL_MINION_COUNT = "";

    public static void main(String[] args) throws SQLException {
        final Connection connection = Utils.getSQLConnection();

        final int villainId = new Scanner(System.in).nextInt();

        PreparedStatement selectedVillain = connection.prepareStatement(GET_VILLAIIN_BY_ID);
        selectedVillain.setInt(1,villainId);

        final ResultSet villainSet = selectedVillain.executeQuery();

        if(!villainSet.next()) {
            System.out.println(NO_SUCH_VILLAIN);
            return;
        }

        final String villainName = villainSet.getString(Constants.COLOMN_LABEL_NAME);

        final PreparedStatement selectAllMinions = connection.prepareStatement(GET_MINION_COUNT_BY_VILLAINS_ID);
        selectAllMinions.setInt(1, villainId);

        final ResultSet countOfminionsSet = selectAllMinions.executeQuery();
        countOfminionsSet.next();

        final int countOfDeletedMinions = countOfminionsSet.getInt(COLOMN_LABEL_MINION_COUNT);

        try () {

        } catch (SQLException e) {
            e.printStackTrace();

            connection.rollback();
        }

        connection.close();

    }
}
