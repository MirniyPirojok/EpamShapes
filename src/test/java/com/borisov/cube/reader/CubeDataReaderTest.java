package com.borisov.cube.reader;

import com.borisov.cube.exception.CustomException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CubeDataReaderTest {
    CubeDataReader cubeDataReader;

    @BeforeClass
    public void setUp() {
        cubeDataReader = new CubeDataReader();
    }

    @Test
    public void readDataPositiveTest() throws CustomException {
        List<String> expected = new ArrayList<>();
        expected.add("1.0 2.0 3.0 4.0");

        List<String> actual = cubeDataReader.readData("data/testData.txt");
        Assert.assertEquals(expected, actual);
    }

    @Test(expectedExceptions = {CustomException.class, NullPointerException.class})
    public void readDataNegativeTest() throws CustomException {
        cubeDataReader.readData("data/111");
    }
}