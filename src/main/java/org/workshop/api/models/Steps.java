package org.workshop.api.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Steps {
    private List<Step> step;
}
