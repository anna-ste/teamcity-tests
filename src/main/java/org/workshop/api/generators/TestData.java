package org.workshop.api.generators;

import lombok.Builder;
import lombok.Data;
import org.workshop.api.models.NewProjectDescription;
import org.workshop.api.models.VcsRoot;

@Builder
@Data
public class TestData {
    private NewProjectDescription newProjectDescription;
    private VcsRoot newVcsRoot;
}
