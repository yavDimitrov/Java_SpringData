package com.jdbcdemo;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Diablo {
    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "");

        Connection connection = DriverManager
                 .getConnection("jdbc:mysql:://localhost:3306/diablo", properties);

        System.out.println("Enter username: ");
        String username = scan.nextLine();

        PreparedStatement query = connection.prepareStatement("SELECT user_name, first_name, last_name, COUNT(ug.id)" +
                "FROM users" +
                "JOIN users_games AS ug ON users.id = ug.user_id" +
                "WHERE user_name = ?");

        query.setString(1, username);

        ResultSet result = query.executeQuery();
        String dbUsername = result.getString("user_name");
        String dbFirstName = result.getString("first_name");
        String dbLastName = result.getString("last_name");
        int dbCountGames = result.getInt("COUNT(ug.id)");

        if(result.next()) {
            System.out.printf("User: %s\n" +
                    "%s %S has played %d games", dbUsername, dbFirstName, dbLastName, dbCountGames);
        } else {
            System.out.println("No such user exists");
        }

    }
}
