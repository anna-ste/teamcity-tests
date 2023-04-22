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
                .vcsRoot(VcsRoot.builder()
                        .vcsName("jetbrains.git")
                        .name(random.getString())
                        .id(random.getString())
                        .project(Project.builder()
                                .id(random.getString())
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
                .buildType(BuildType.builder()
                        .id(random.getString())
                        .name(random.getString())
                        .project(Project.builder()
                                .id(random.getString())
                                .build())
                        .steps(Steps.builder()
                                .step(Arrays.asList(
                                        Step.builder()
                                                .name("myCommandLineStep")
                                                .type("simpleRunner")
                                                .properties(Properties.builder()
                                                        .property(Arrays.asList(
                                                                Property.builder()
                                                                        .name("script.content")
                                                                        .value("echo 'Hello World!'")
                                                                        .build()
                                                        ))
                                                        .build())
                                                .build()
                                ))
                                .build())

                        .build())
                .build();

    }
}
