package org.workshop.api.generators;

import org.workshop.api.models.NewProjectDescription;
import org.workshop.api.models.ParentProject;

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
                .build();
    }
}
