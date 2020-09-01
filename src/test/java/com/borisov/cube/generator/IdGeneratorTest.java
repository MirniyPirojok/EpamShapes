package com.borisov.cube.generator;

import org.testng.Assert;
import org.testng.annotations.Test;

public class IdGeneratorTest {
    @Test
    public void generateIdNotNullTest() {
        long actual = IdGenerator.generateId();
        Assert.assertNotNull(actual);
    }
}
