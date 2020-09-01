package com.borisov.cube.comparator;

import com.borisov.cube.entity.Cube;
import com.borisov.cube.entity.Point;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CubeComparatorTest {

    Cube cube1;
    Cube cube2;
    Cube cube3;
    CubeComparator cubeComparator;

    @BeforeClass
    public void setUp() {
        cube1 = new Cube(1, new Point(1.0, 2.0, 3.0), 4.5);
        cube2 = new Cube(1, new Point(1.0, 2.0, 3.0), 4.5);
        cube3 = new Cube(2, new Point(3.0, 4.0, 5.0), 6.5);
    }

    @AfterClass
    public void tierDown() {
        cube1 = null;
        cube2 = null;
        cube3 = null;
    }

    @Test
    public void idComparePositiveTest() {
        cubeComparator = CubeComparator.ID;
        int actual = cubeComparator.compare(cube1, cube2);
        int expected = 0;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void sideComparePositiveTest() {
        cubeComparator = CubeComparator.SIDE;
        int actual = cubeComparator.compare(cube1, cube2);
        int expected = 0;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void xComparePositiveTest() {
        cubeComparator = CubeComparator.X;
        int actual = cubeComparator.compare(cube1, cube2);
        int expected = 0;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void yComparePositiveTest() {
        cubeComparator = CubeComparator.Y;
        int actual = cubeComparator.compare(cube1, cube2);
        int expected = 0;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void zComparePositiveTest() {
        cubeComparator = CubeComparator.Z;
        int actual = cubeComparator.compare(cube1, cube2);
        int expected = 0;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void idCompareNegativeTest() {
        cubeComparator = CubeComparator.ID;
        int actual = cubeComparator.compare(cube1, cube3);
        int expected = 0;
        Assert.assertNotEquals(actual, expected);
    }

    @Test
    public void sideCompareNegativeTest() {
        cubeComparator = CubeComparator.SIDE;
        int actual = cubeComparator.compare(cube1, cube3);
        int expected = 0;
        Assert.assertNotEquals(actual, expected);
    }

    @Test
    public void xCompareNegativeTest() {
        cubeComparator = CubeComparator.X;
        int actual = cubeComparator.compare(cube1, cube3);
        int expected = 0;
        Assert.assertNotEquals(actual, expected);
    }

    @Test
    public void yCompareNegativeTest() {
        cubeComparator = CubeComparator.Y;
        int actual = cubeComparator.compare(cube1, cube3);
        int expected = 0;
        Assert.assertNotEquals(actual, expected);
    }

    @Test
    public void zCompareNegativeTest() {
        cubeComparator = CubeComparator.Z;
        int actual = cubeComparator.compare(cube1, cube3);
        int expected = 0;
        Assert.assertNotEquals(actual, expected);
    }
}
