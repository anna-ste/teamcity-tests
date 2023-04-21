package org.workshop.api.requests;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.workshop.api.models.NewProjectDescription;
import org.workshop.api.specs.Specs;

import static io.restassured.RestAssured.given;

public class Request {
    private static final String AUTHENTICATION_ENDPOINT = "/authenticationTest.html?csrf";
    private static final String PROJECT_ENDPOINT = "/app/rest/projects";
    private final Specs spec = new Specs();
    public Response getCsrfToken() {
        return RestAssured.get(AUTHENTICATION_ENDPOINT);
    }

    public Response createProject(NewProjectDescription project) {
        return given().spec(spec.reqSpec()).body(project).post(PROJECT_ENDPOINT);

    }
}
