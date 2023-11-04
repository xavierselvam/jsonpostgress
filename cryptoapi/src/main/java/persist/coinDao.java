package persist;

import data.coinData;

import java.sql.*;

public class coinDao {

    String INSERTSTATEMENT="INSERT INTO cryptoPrices (coinName, price, PercentChange1h, PercentChange24h, PercentChange7d, updated)\n" +
            "VALUES (?, ?, ?, ?, ?, ?)";
    String dbUrl = "jdbc:postgresql://localhost:5432/template1";
    String dbUser = "postgres";
    String dbPassword = "password";

    public void insertcoinDao(coinData cd) {
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword)) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERTSTATEMENT);
            preparedStatement.setString(1, cd.getCoinName());
            preparedStatement.setString(2, cd.getPrice());
            preparedStatement.setString(3, cd.getPercentChange1h());
            preparedStatement.setString(4, cd.getPercentChange24h());
            preparedStatement.setString(5, cd.getPercentChange7d());
            preparedStatement.setTimestamp(6, new java.sql.Timestamp(System.currentTimeMillis()));
            int rowsInserted = preparedStatement.executeUpdate();

        } catch(SQLException e){
            e.printStackTrace();
        }

    }
}
