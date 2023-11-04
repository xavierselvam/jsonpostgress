import API.apiMain;
import persist.persistToDb;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Queue;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class CoinMarketCapDataFetcher {
    public static void main(String[] args) throws SQLException {
        Queue<Object> coinDataQueue = new LinkedList<>();
        apiMain api = new apiMain(coinDataQueue);
        persistToDb db = new persistToDb(coinDataQueue);

        // Create a new thread for the persistToDb instance and start it
        Thread dbThread = new Thread(db);
        dbThread.start();

        // Create a new thread for the apiMain instance and start it
        Thread apiThread = new Thread(api);
        apiThread.start();

    }
}


