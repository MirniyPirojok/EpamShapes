package com.borisov.cube.validator;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ValueValidatorTest {
    ValueValidator valueValidator;

    @BeforeClass
    public void setUp() {
        valueValidator = new ValueValidator();
    }

    @AfterClass
    public void tierDown() {
        valueValidator = null;
    }

    @Test
    public void isValidLineTestTrue() {
        String value = "-0.1 2.0 3.0 4.0";
        boolean actual = valueValidator.isValidLine(value);
        Assert.assertTrue(actual);
    }

    @Test
    public void isValidLineIntegerTestFalse() {
        String value = "1 2 3 4";
        boolean actual = valueValidator.isValidLine(value);
        Assert.assertFalse(actual);
    }

    @Test
    public void isValidLineLettersTestFalse() {
        String value = "aa bb ss dd";
        boolean actual = valueValidator.isValidLine(value);
        Assert.assertFalse(actual);
    }

    @Test
    public void isValidLineNegativeSideTestFalse() {
        String value = "0.1 2.0 3.0 -4.0";
        boolean actual = valueValidator.isValidLine(value);
        Assert.assertFalse(actual);
    }
}
