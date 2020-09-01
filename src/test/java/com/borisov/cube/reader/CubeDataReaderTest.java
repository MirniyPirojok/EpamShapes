package com.borisov.cube.reader;

import com.borisov.cube.exception.CustomException;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class CubeDataReaderTest {

    @Test
    public void readDataPositiveTest() throws CustomException {
        List<String> expected = new ArrayList<>();
        expected.add("1.0 2.0 3.0 4.0");

        CubeDataReader cubeDataReader = new CubeDataReader();
        List<String> actual = cubeDataReader.readData("data/testData.txt");
        Assert.assertEquals(expected, actual);
    }

    @Test(expectedExceptions = CustomException.class)
    public void readDataNegativeTest() throws CustomException {
        CubeDataReader cubeDataReader = new CubeDataReader();
        cubeDataReader.readData("data/111");
    }
}