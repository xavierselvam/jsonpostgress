package API;

import data.coinData;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class apiMain implements Runnable {
    private Queue<Object> coinDataQueue;

    public apiMain(Queue<Object> coinDataQueue) {
        this.coinDataQueue = coinDataQueue;
    }

    @Override
    public void run() {
        try {
            do {
                Logger logger = LogManager.getLogger(apiMain.class);
                logger.info("API Fetches started & running");


                final File configFile = new File("cmcApi.cfg");
                final Configurations configurations = new Configurations();
                final FileBasedConfigurationBuilder<PropertiesConfiguration> builder = configurations
                        .propertiesBuilder(configFile);
                PropertiesConfiguration configuration = builder.getConfiguration();
                //Fetch List of coins for which prices required
                List<String> coinList = Arrays.asList(configuration.getString("ListOfCoins").split(","));

                //Establish things needed for http call

                httpHelper hh = new httpHelper();
                String jsonData = hh.getLatestPricesForListOfCoins(coinList);
                jsonParser jsonparser = new jsonParser();
                List<coinData> conins = jsonparser.convertJsonToObject(coinList, jsonData);

                for (coinData data : conins) {
                    synchronized (coinDataQueue) {
                        coinDataQueue.add(data);
                    }
                }
                Thread.sleep(15 * 1 * 1000); // 15 minutes in milliseconds
            } while (true);
        }
        catch(Exception e){
                e.printStackTrace();
        }

    }
}
