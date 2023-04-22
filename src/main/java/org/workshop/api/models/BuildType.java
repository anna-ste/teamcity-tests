package org.workshop.api.models;

//TODO add fields

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BuildType {
    private String id;
    private String name;
    private Project project;
    private BuildTypes templates;
    private Properties parameters;
    private Steps steps;

}
