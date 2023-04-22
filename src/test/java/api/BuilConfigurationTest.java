package api;

import org.testng.annotations.Test;
import org.workshop.api.models.Build;
import org.workshop.api.models.BuildType;
import org.workshop.api.models.Project;
import org.workshop.api.models.VcsRoot;
import org.workshop.api.requests.CheckedRequest;


public class BuilConfigurationTest extends BaseTest {
    @Test
    public void xbuildConfigurationTest() {

        var testData = testDataGenerator.generate();
        var checkedRequest = new CheckedRequest();
        var project = checkedRequest.createProject(testData.getNewProjectDescription());

        BuildType buildType = testData.getBuildType();
        Project buildTypeProject = buildType.getProject();
        buildType.setProject(buildTypeProject.builder().id(project.getId()).build());
        VcsRoot vcsRoot = testData.getVcsRoot();
        Project vcsRootProject = vcsRoot.getProject();
        vcsRoot.setProject(vcsRootProject.builder().id(project.getId()).build());

        checkedRequest.createVcsRoot(vcsRoot);
        checkedRequest.createBuildConfiguration(buildType);
        var createdBuildType = checkedRequest.runBuildConfiguration(Build.builder().buildType(testData.getBuildType()).build());
        var build = checkedRequest.getBuild(createdBuildType.getId());
        checkedRequest.waitUntilBuildFinished(build.getId());
        softy.assertThat(build.getStatus()).isEqualTo("SUCCESS");


    }
}
