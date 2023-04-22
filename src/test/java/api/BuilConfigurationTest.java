package api;

import org.testng.annotations.Test;
import org.workshop.api.requests.CheckedRequest;


public class BuilConfigurationTest extends BaseTest {
    @Test
    public void xbuildConfigurationTest() {
        var testData = testDataGenerator.generate();
        new CheckedRequest().createVcsRoot(testData.getVcsRoot());
        new CheckedRequest().createBuildConfiguration(testData.getBuildType());
    }
}
