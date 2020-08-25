package com.borisov.cube.action;

import com.borisov.cube.exception.CustomException;
import com.borisov.cube.parser.CubeDataParser;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CubeDataParserTest {

    @Test
    public void parseDataTest() throws CustomException {
        List<String> incomingData = new ArrayList<>();
        incomingData.add("aa fdf 44");
        incomingData.add("1.0 2.0 3.0 4.0");
        incomingData.add("1 2 3 4");
        incomingData.add("-4.0 -4.0 -4.0 7.0");

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

        CubeDataParser cubeDataParser = new CubeDataParser();
        List<List<Double>> actual = cubeDataParser.parseData(incomingData);

        Assert.assertEquals(expected, actual);
    }

}
