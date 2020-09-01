package com.borisov.cube.parser;

import com.borisov.cube.exception.CustomException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CubeDataParserTest {

    List<String> incomingData;
    CubeDataParser cubeDataParser;

    @BeforeClass
    public void setUpClass() {
        cubeDataParser = new CubeDataParser();
    }

    @AfterClass
    public void tierDownClass() {
        cubeDataParser = null;
    }

    @BeforeMethod
    public void setUpMethod() {
        incomingData = new ArrayList<>();
    }

    @AfterMethod
    public void tierDownMethod() {
        incomingData = null;
    }

    @Test
    public void parseDataPositiveTest() throws CustomException {
        List<Double> outgoingLine1 = new ArrayList<>();
        outgoingLine1.add(1.0);
        outgoingLine1.add(2.0);
        outgoingLine1.add(3.0);
        outgoingLine1.add(4.0);

        List<Double> outgoingLine2 = new ArrayList<>();
        outgoingLine2.add(-4.0);
        outgoingLine2.add(-4.0);
        outgoingLine2.add(-4.0);
        outgoingLine2.add(7.0);

        List<List<Double>> expected = new ArrayList<>();
        expected.add(outgoingLine1);
        expected.add(outgoingLine2);

        incomingData.add("1.0 2.0 3.0 4.0");
        incomingData.add("-4.0 -4.0 -4.0 7.0");
        List<List<Double>> actual = cubeDataParser.parseData(incomingData);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void parseWrongDataNegativeTest() throws CustomException {
        incomingData.add("aa fdf 44");
        incomingData.add("1 2 3 4");
        incomingData.add("1.0 2.0 3.0 4.0e2");

        List<List<Double>> actual = cubeDataParser.parseData(incomingData);

        Assert.assertTrue(actual.isEmpty());
    }

    @Test(expectedExceptions = CustomException.class)
    public void parseNoDataTest() throws CustomException {
        cubeDataParser.parseData(incomingData);
    }
}
