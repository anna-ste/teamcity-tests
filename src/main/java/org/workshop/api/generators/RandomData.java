package org.workshop.api.generators;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;
import java.util.UUID;

public class RandomData {
    private final static int STRING_LENGTH = 10;
    private final java.util.Random random = new Random();

    public String getId() {
        return "test_" + RandomStringUtils.randomAlphanumeric(STRING_LENGTH);
    }
    public String getString() {
        return "test_" + RandomStringUtils.randomAlphanumeric(STRING_LENGTH);
    }
    public boolean getBoolean() {
        return random.nextBoolean();
    }
}
