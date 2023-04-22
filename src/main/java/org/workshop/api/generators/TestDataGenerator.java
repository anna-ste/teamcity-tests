package org.workshop.api.generators;

import org.workshop.api.models.*;

import java.util.Arrays;

public class TestDataGenerator {
    private final RandomData random = new RandomData();

    public TestData generate() {
        return TestData.builder()
                .newProjectDescription(NewProjectDescription.builder()
                        .id(random.getString())
                        .name(random.getString())
                        .parentProject(
                                ParentProject.builder()
                                        .locator("_Root")
                                        .build()
                        )
                        .copyAllAssociatedSettings(random.getBoolean())
                        .build())
                .newVcsRoot(VcsRoot.builder()
                        .vcsName("jetbrains.git")
                        .name(random.getString())
                        .id(random.getString())
                        .project(Project.builder()
                                .id("SpringCoreForQa")
                                .build())
                        .properties(Properties.builder()
                                .property(Arrays.asList(
                                        Property.builder()
                                                .name("authMethod")
                                                .value("ANONYMOUS")
                                                .build(),
                                        Property.builder()
                                                .name("branch")
                                                .value("refs/heads/master")
                                                .build(),
                                        Property.builder()
                                                .name("url")
                                                .value("https://github.com/anna-ste/teamcity-tests")
                                                .build()
                                ))
                                .build())
                        .build())
                .build();

    }
}
