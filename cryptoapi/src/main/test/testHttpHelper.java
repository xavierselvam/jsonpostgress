import API.httpHelper;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class testHttpHelper {
@Test
    public void testDoTheThing() {
        // Mock your parameters, endpoint, and API key
        String endpoint = "/your/endpoint";
        List<String> parameterValueList = new ArrayList<>();
        parameterValueList.add("BTH");
        parameterValueList.add("ETH");
        String coinMarketCapApiKey = "YOUR_API_KEY";

        // Create an instance of httpHelper
        httpHelper helper = new httpHelper(endpoint, parameterValueList, coinMarketCapApiKey);

        // Call the method you want to test
        helper.doTheThing(endpoint, parameterValueList);

        // Add assertions to check the expected behavior of your method
        // For example, you can assert that specific log messages were printed
        // using a testing framework like JUnit's Assert.assertEquals or Assert.assertTrue.
    }
}
