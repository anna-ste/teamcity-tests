package api;

import org.testng.annotations.Test;
import org.workshop.api.requests.CheckedRequest;


public class BuilConfigurationTest extends BaseTest {
    @Test
    public void buildConfigurationTest() {
        var testData = testDataGenerator.generate();
        new CheckedRequest().createVcsRoot(testData.getNewVcsRoot());
    }
}
