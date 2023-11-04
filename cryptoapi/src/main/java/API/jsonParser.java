package API;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import data.coinData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class jsonParser {
    Logger logger = LogManager.getLogger(apiMain.class);


    public List<coinData>  convertJsonToObject(List<String> coinList,String data) {
        logger.info(data);
        List<coinData> cdObjList = new ArrayList<>();
        JsonParser jsonParser = new JsonParser();
        JsonObject rootObject = jsonParser.parse(data).getAsJsonObject();

        try {
            for (String coin : coinList) {
                JsonArray Data = rootObject.getAsJsonObject("data").getAsJsonArray(coin);
                JsonObject Info = Data.get(0).getAsJsonObject();
                JsonObject Quote = Info.getAsJsonObject("quote").getAsJsonObject("USD");
                String Price = Quote.get("price").getAsString();
                String PercentChange1h = Quote.get("percent_change_1h").getAsString();
                String PercentChange24h = Quote.get("percent_change_24h").getAsString();
                String PercentChange7d = Quote.get("percent_change_7d").getAsString();
                String currency = "USD";

                coinData cd = new coinData(coin, Price, PercentChange1h, PercentChange24h, PercentChange7d, currency);
                cdObjList.add(cd);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return cdObjList;

    }
}
