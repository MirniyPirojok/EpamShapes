package com.borisov.cube.creator;

import com.borisov.cube.entity.Cube;
import com.borisov.cube.entity.Point;
import com.borisov.cube.generator.IdGenerator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CubeCreatorTest {
    CubeCreator cubeCreator;
    Cube cube1;
    Cube cube2;
    List<Double> rightValues = new ArrayList<>();
    List<Double> wrongValues = new ArrayList<>();
    List<List<Double>> valuesList = new ArrayList<>();

    @BeforeClass
    public void setUp() {
        cubeCreator = new CubeCreator();
        cube1 = new Cube(1L, new Point(1.0, 1.0, 1.0), 1.0);
        cube2 = new Cube(2L, new Point(1.0, 1.0, 1.0), 1.0);

        rightValues.add(1.0);
        rightValues.add(1.0);
        rightValues.add(1.0);
        rightValues.add(1.0);

        wrongValues.add(2.0);
        wrongValues.add(2.0);
        wrongValues.add(2.0);
        wrongValues.add(2.0);
    }

    @AfterClass
    public void tierDown() {
        cubeCreator = null;
        cube1 = null;
        cube2 = null;
        rightValues = null;
        wrongValues = null;
        valuesList = null;
    }

    @BeforeMethod
    public void setUpMethod() {
        IdGenerator.setId(1);
        valuesList = new ArrayList<>();
    }


    @Test
    public void createPositiveTest() {
        Cube expected = cube1;
        Cube actual = cubeCreator.create(rightValues);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void createNegativeTest() {
        Cube expected = cube1;
        Cube actual = cubeCreator.create(wrongValues);

        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void createCubesPositiveTest() {
        List<Cube> expected = new ArrayList<>();
        expected.add(cube1);
        expected.add(cube2);

        valuesList.add(rightValues);
        valuesList.add(rightValues);
        List<Cube> actual = cubeCreator.createCubes(valuesList);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void createCubesNegativeTest() {
        List<Cube> expected = new ArrayList<>();
        expected.add(cube1);
        expected.add(cube2);

        valuesList.add(rightValues);
        valuesList.add(wrongValues);
        List<Cube> actual = cubeCreator.createCubes(valuesList);

        Assert.assertNotEquals(expected, actual);
    }
}
