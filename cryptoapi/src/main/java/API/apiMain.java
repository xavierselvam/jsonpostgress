package API;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
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
            List<String> coinList = configuration.getList(String.class, "ListOfCoins");

            //Establish things needed for http call
            String coinMarketCapApiKey = configuration.getString("coinMarketCapApiKey");
            String apibaseurl = configuration.getString("apibaseurl");
            String newListEndPoint = configuration.getString("newListing");
            newListEndPoint = configuration.getString("quoteLatest");


            String endpoint = apibaseurl + newListEndPoint;
            endpoint = endpoint + "?symbol=BTC";

            //Call http & get json response





            // Parse JSON response
            JsonObject jsonResponse = JsonParser.parseString(result.toString()).getAsJsonObject();
            // Extract and process the data from the JSON

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
