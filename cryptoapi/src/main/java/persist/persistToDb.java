package persist;

import API.apiMain;
import data.coinData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Queue;

public class persistToDb implements Runnable{
    private Queue<Object> coinDataQueue;
    public persistToDb(Queue<Object> coinDataQueue) {
        this.coinDataQueue = coinDataQueue;
    }

    @Override
    public void run() {
        Logger logger = LogManager.getLogger(apiMain.class);
        logger.info("Inside PersistDb thrad");
        do {
            synchronized (coinDataQueue) {
                Object data = coinDataQueue.poll();
                System.out.println("second thread data: " + data);
                if(data instanceof coinData){
                    coinData cd =(coinData) data;
                    coinDao dao= new coinDao();
                    dao.insertcoinDao(cd);
                }

            }
        }while(true);

    }
}
