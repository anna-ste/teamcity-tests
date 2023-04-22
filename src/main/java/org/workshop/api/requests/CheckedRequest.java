package org.workshop.api.requests;

import org.apache.http.HttpStatus;
import org.workshop.api.models.BuildType;
import org.workshop.api.models.NewProjectDescription;
import org.workshop.api.models.Project;
import org.workshop.api.models.VcsRoot;

public class CheckedRequest {
    private final Request request = new Request();

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
        return request.createBuildConfiguration(buildType).then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().response().as(BuildType.class);
    }

}
