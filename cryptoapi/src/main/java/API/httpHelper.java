package API;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.List;

public class httpHelper {
    Logger logger = LogManager.getLogger(apiMain.class);

    public void getLatestPricesForListOfCoins(List<String> coinList) {
        try {

            final File configFile = new File("cmcApi.cfg");
            final Configurations configurations = new Configurations();
            final FileBasedConfigurationBuilder<PropertiesConfiguration> builder = configurations
                    .propertiesBuilder(configFile);
            PropertiesConfiguration configuration = builder.getConfiguration();
            String coinMarketCapApiKey = configuration.getString("coinMarketCapApiKey");
            String apibaseurl = configuration.getString("apibaseurl");
            String parmCoin = "?symbol=" + String.join(",", coinList);
            String endpoint=configuration.getString("quoteLatest");

            String finalUrl = apibaseurl + endpoint + parmCoin;
            logger.info("Final URL is :" + finalUrl);

            HttpClient client = HttpClients.createDefault();
            HttpGet request = new HttpGet(finalUrl);
            request.addHeader("X-CMC_PRO_API_KEY", coinMarketCapApiKey);
            logger.info("fetching values for coins");
            HttpResponse response = client.execute(request);
            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            logger.info("please" + line);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}