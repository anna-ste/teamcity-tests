package org.workshop.api.generators;

import lombok.Builder;
import lombok.Data;
import org.workshop.api.models.NewProjectDescription;
@Builder
@Data
public class TestData {
    private NewProjectDescription newProjectDescription;

}
