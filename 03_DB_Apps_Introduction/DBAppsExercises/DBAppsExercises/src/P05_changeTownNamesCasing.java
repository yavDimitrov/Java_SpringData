import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class P05_changeTownNamesCasing {
    private static final String UPDATE_TOWN = "UPDATE towns t SET name = UPPER(name) WHERE t.country = ?";
    private static final String GET_TOWNS_BY_COUNTRY = "SELECT t.name FROM towns AS t WHERE t.country = ?";
    private static final String NO_TOWNS_UPDATED = "No town names were affected.";
    private static final String TOWNS_AFFECTED = "%d town names were affected.%n";

    public static void main(String[] args) throws SQLException {
        final Connection connection = Utils.getSQLConnection();

         final String countryName = new Scanner(System.in).nextLine();

        final PreparedStatement statement = connection.prepareStatement(UPDATE_TOWN);
        statement.setString(1, countryName);

        final int updated = statement.executeUpdate();

        if(updated == 0) {
            System.out.println(NO_TOWNS_UPDATED);
            return;
        }
        System.out.printf(TOWNS_AFFECTED, updated);

        PreparedStatement selectTowns = connection.prepareStatement(GET_TOWNS_BY_COUNTRY);
        selectTowns.setString(1, countryName);

        final ResultSet townsResult = selectTowns.executeQuery();

        ArrayList<String> towns = new ArrayList<>();

        while(townsResult.next()) {
            towns.add(townsResult.getString(Constants.COLOMN_LABEL_NAME));
        }
        System.out.println(towns);

    }
}

