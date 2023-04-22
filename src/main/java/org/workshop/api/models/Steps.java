package org.workshop.api.models;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Steps {
    private List<Step> step;
}
