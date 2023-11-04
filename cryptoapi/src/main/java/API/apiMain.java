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

public class apiMain implements Runnable {

    @Override
    public void run() {
        try {
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

            httpHelper hh= new httpHelper();
            String jsonData = hh.getLatestPricesForListOfCoins(coinList);
            jsonParser jsonparser=new jsonParser();
            List<coinData> conins= jsonparser.convertJsonToObject(coinList,jsonData);
            logger.info(conins.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
