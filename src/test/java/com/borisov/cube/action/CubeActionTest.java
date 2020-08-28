package com.borisov.cube.action;

import com.borisov.cube.entity.Cube;
import com.borisov.cube.entity.Point;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CubeActionTest {
    CubeAction cubeAction;
    Point testVertex;
    Cube testCube;

    @BeforeClass
    public void setUp() {
        cubeAction = new CubeAction();
        testVertex = new Point(-4.0, 0.0, -4.0);
        testCube = new Cube(testVertex, 8.0);
    }

    @AfterClass
    public void tierDown() {
        cubeAction = null;
        testVertex = null;
        testCube = null;
    }

    @Test
    public void calculateAreaPositiveTest() {
        double expected = 384.0;
        double actual = cubeAction.calculateArea(testCube);
        Assert.assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void calculateAreaNegativeTest() {
        double expected = 0;
        double actual = cubeAction.calculateArea(testCube);
        Assert.assertNotEquals(expected, actual, 0.0001);
    }

    @Test
    public void calculateVolumePositiveTest() {
        double expected = 512.0;
        double actual = cubeAction.calculateVolume(testCube);
        Assert.assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void calculateVolumeNegativeTest() {
        double expected = 0;
        double actual = cubeAction.calculateVolume(testCube);
        Assert.assertNotEquals(expected, actual, 0.0001);
    }

    @Test
    public void isOnPlanePositiveTest() {
        Assert.assertTrue(cubeAction.isOnPlane(testCube));
    }

    @Test
    public void volumesRatioPositiveTest() {
        double[] expected = {1.0, 0, 1.0};
        double[] actual = cubeAction.volumesRatio(testCube);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void volumesRatioNegativeTest() {
        double[] expected = {0, 0, 0};
        double[] actual = cubeAction.volumesRatio(testCube);
        Assert.assertNotEquals(expected, actual);
    }
}
