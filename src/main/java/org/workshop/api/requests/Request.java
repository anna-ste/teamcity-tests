package org.workshop.api.requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.workshop.api.models.Build;
import org.workshop.api.models.BuildType;
import org.workshop.api.models.NewProjectDescription;
import org.workshop.api.models.VcsRoot;
import org.workshop.api.specs.Specs;

import static io.restassured.RestAssured.given;

public class Request {
    private static final String AUTHENTICATION_ENDPOINT = "/authenticationTest.html?csrf";
    private static final String PROJECT_ENDPOINT = "/app/rest/projects";
    private static final String VCSROOT_ENDPOINT = "/app/rest/vcs-roots";
    private static final String BUILD_QUEUE_ENDPOINT = "/app/rest/buildQueue";
    private static final String BUILD_TYPE_ENDPOINT = "/app/rest/buildTypes";
    private static final String BUILD_LIST_ENDPOINT = "/app/rest/builds/id:{id}";
    private final Specs spec = new Specs();

    public Response getCsrfToken() {
        return RestAssured.get(AUTHENTICATION_ENDPOINT);
    }

    public Response getBuild(String buildId) {
        return given().spec(spec.reqSpec())
                .pathParam("id", buildId)
                .queryParam("fields", "state,id,buildType,status")
                .when()
                .get(BUILD_LIST_ENDPOINT);
    }

    public Response createProject(NewProjectDescription project) {
        return given().spec(spec.reqSpec()).body(project).post(PROJECT_ENDPOINT);

    }

    public Response createVCS(VcsRoot vcsRoot) {
        return given().spec(spec.reqSpec()).body(vcsRoot).post(VCSROOT_ENDPOINT);

    }

    public Response createBuildConfiguration(BuildType buildType) {
        return given().spec(spec.reqSpec()).body(buildType).post(BUILD_TYPE_ENDPOINT);
    }

    public Response runBuildConfiguration(Build build) {
        return given().spec(spec.reqSpec()).body(build).post(BUILD_QUEUE_ENDPOINT);
    }
}
