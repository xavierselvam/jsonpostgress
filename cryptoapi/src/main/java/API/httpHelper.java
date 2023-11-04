package API;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class httpHelper {
    private final String endpoint;
    private final List<String> coinList;
    private final String coinMarketCapApiKey;
    Logger logger = LogManager.getLogger(apiMain.class);



    public httpHelper( String endpoint, List<String> coinList, String coinMarketCapApiKey) {
        this.endpoint = endpoint;
        this.coinList = coinList;
        this.coinMarketCapApiKey = coinMarketCapApiKey;
    }

    public void doTheTHing() {
        try{

        HttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet(endpoint);
        request.addHeader("X-CMC_PRO_API_KEY", coinMarketCapApiKey);
        HttpResponse response = client.execute(request);
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        logger.info(reader.lines());
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            result.append(line);
            logger.info(line);
        }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}