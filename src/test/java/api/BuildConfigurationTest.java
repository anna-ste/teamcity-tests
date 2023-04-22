package api;

import org.testng.annotations.Test;
import org.workshop.api.models.Build;
import org.workshop.api.models.BuildType;
import org.workshop.api.models.Project;
import org.workshop.api.models.VcsRoot;
import org.workshop.api.requests.CheckedRequest;


public class BuildConfigurationTest extends BaseTest {
    @Test
    public void xbuildConfigurationTest() {

        var testData = testDataGenerator.generate();
        var checkedRequest = new CheckedRequest();

        // create project
        var project = checkedRequest.createProject(testData.getNewProjectDescription());

        // update test data to use created project id
        BuildType buildType = testData.getBuildType();
        buildType.setProject(Project.builder().id(project.getId()).build());
        VcsRoot vcsRoot = testData.getVcsRoot();
        vcsRoot.setProject(Project.builder().id(project.getId()).build());

        // create vcs root
        checkedRequest.createVcsRoot(vcsRoot);

        // create and run build configuration
        checkedRequest.createBuildConfiguration(buildType);
        var createdBuildType = checkedRequest.runBuildConfiguration(Build.builder().buildType(testData.getBuildType()).build());

        // wait until build finished and assert build status
        var build = checkedRequest.getBuild(createdBuildType.getId());
        checkedRequest.waitUntilBuildFinished(build.getId());
        softy.assertThat(build.getStatus()).isEqualTo("SUCCESS");


    }
}
