package org.workshop.api.requests;

import org.apache.http.HttpStatus;
import org.workshop.api.models.*;

public class CheckedRequest {
    private final Request request = new Request();
    private static final long TIMEOUT = 60_000;

    public Build getBuild(String buildId) {
        return request.getBuild(buildId).then().assertThat().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().response()
                .as(Build.class);

    }

    public String getCsrfToken() {
        return request.getCsrfToken().then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().response().asString();
    }

    public Project createProject(NewProjectDescription project) {
        return request.createProject(project).then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().response().as(Project.class);
    }

    public VcsRoot createVcsRoot(VcsRoot vcsRoot) {
        return request.createVCS(vcsRoot).then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().response().as(VcsRoot.class);
    }

    public BuildType createBuildConfiguration(BuildType buildType) {
        return request.createBuildConfiguration(buildType)
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().response().as(BuildType.class);

    }

    public BuildType runBuildConfiguration(Build build) {
        return request.runBuildConfiguration(build)
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().response().as(BuildType.class);
    }

    public void waitUntilBuildFinished(String buildId) {
        var startTime = System.currentTimeMillis();

        while (System.currentTimeMillis() - startTime < TIMEOUT) {
            if (getBuild(buildId).getState().equals("finished")) {
                break;
            }
        }
    }
}
