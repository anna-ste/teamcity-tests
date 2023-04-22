package org.workshop.api.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VcsRoot {
    private String name;
    private String vcsName;
    private String id;
    private Project project;
    private Properties properties;
}
