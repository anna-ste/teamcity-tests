package org.workshop.api.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Property {
    private String name;
    private String id;
    private String value;
}
