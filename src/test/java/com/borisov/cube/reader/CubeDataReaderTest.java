package com.borisov.cube.reader;

import com.borisov.cube.exception.CustomException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CubeDataReaderTest {

    File testFile;
    CubeDataReader cubeDataReader;

    @BeforeClass
    public void setUp() {
        testFile = new File("testData.txt");
        cubeDataReader = new CubeDataReader();

        try (FileWriter fileWriter = new FileWriter(testFile)) {
            fileWriter.write("1.0 2.0 3.0 4.0");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @AfterClass
    public void tierDown() {
        testFile.delete();
    }

    @Test
    public void readDataPositiveTest() throws CustomException {
        List<String> expected = new ArrayList<>();
        expected.add("1.0 2.0 3.0 4.0");

        String filePath = testFile.getPath();
        List<String> actual = cubeDataReader.readData(filePath);

        Assert.assertEquals(expected, actual);
    }

    @Test(expectedExceptions = CustomException.class)
    public void readDataNegativeTest() throws CustomException {
        cubeDataReader.readData("notExistingFile.txt");
    }
}
