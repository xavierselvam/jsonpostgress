import API.apiMain;

import java.sql.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class CoinMarketCapDataFetcher {
    public static void main(String[] args) throws SQLException {
        apiMain api = new apiMain();
        api.run();
           String dbUrl = "jdbc:postgresql://localhost:5432/template1";
            String dbUser = "postgres";
            String dbPassword = "password";



    }
}


