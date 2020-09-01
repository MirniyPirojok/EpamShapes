package com.borisov.cube.validator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ValueValidatorTest {

    @Test(dataProvider = "dataForTest")
    public void isValidLineTest(String string, boolean expected) {
        ValueValidator valueValidator = new ValueValidator();
        boolean actual = valueValidator.isValidLine(string);
        Assert.assertEquals(actual, expected);
    }

    @DataProvider(name = "dataForTest")
    public Object[][] createDataForTest() {
        return new Object[][]{
                {"1 1 1 1", false},
                {"aa bb ss dd", false},
                {"0.1 2.0 3.0 -4.0", false},
                {"2.0", false},
                {"3.0 4.0", false},
                {"5.0 6.0 5.0", false},
                {"1.0a 1.0 1.0 1.0", false},
                {"2.0E2 1.0 1.0 1.0", false},
                {"7.0 7.0 7.0 7.0", true},
                {"-0.1 -2.0 -3.0 4.0", true}
        };
    }
}
