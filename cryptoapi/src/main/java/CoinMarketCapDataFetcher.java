import API.apiMain;

import java.sql.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class CoinMarketCapDataFetcher {
    public static void main(String[] args) throws SQLException {
        apiMain API = new apiMain();
        API.run();

            // Database connection
            String dbUrl = "jdbc:postgresql://localhost:5432/template1";
            String dbUser = "postgres";
            String dbPassword = "password";

//            Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
//
//            // Define and execute SQL insert statements
//            String sql = "INSERT INTO accounts (user_id, username, password,email,created_on,last_login) VALUES (?,?,?,?,?,?)";
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setInt(1,2);
//            preparedStatement.setString(2,"selvax1");
//            preparedStatement.setString(3,"password");
//            preparedStatement.setString(4,"sxaviertk1@gmail.com");
//            Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
//            preparedStatement.setTimestamp(5,currentTimestamp);
//            preparedStatement.setTimestamp(6,currentTimestamp);
//            // Set parameters and execute the prepared statement for each cryptocurrency
//            preparedStatement.execute();
//            // Close the database connection
//            connection.close();


    }
}


