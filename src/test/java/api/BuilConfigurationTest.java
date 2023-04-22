package api;

import org.testng.annotations.Test;
import org.workshop.api.models.Build;
import org.workshop.api.requests.CheckedRequest;


public class BuilConfigurationTest extends BaseTest {
    @Test
    public void xbuildConfigurationTest() {

        var testData = testDataGenerator.generate();
        var checkedRequest = new CheckedRequest();
        checkedRequest.createProject(testData.getNewProjectDescription());
        checkedRequest.createVcsRoot(testData.getVcsRoot());
        checkedRequest.createBuildConfiguration(testData.getBuildType());
        var buildType = checkedRequest.runBuildConfiguration(Build.builder().buildType(testData.getBuildType()).build());
        var build = checkedRequest.getBuild(buildType.getId());
        checkedRequest.waitUntilBuildFinished(build.getId());
        softy.assertThat(build.getStatus()).isEqualTo("finished");


    }
}
