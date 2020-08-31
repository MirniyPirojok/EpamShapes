package com.borisov.cube.creator;

import com.borisov.cube.entity.Cube;
import com.borisov.cube.entity.Point;
import com.borisov.cube.generator.IdGenerator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CubeCreatorTest {
    CubeCreator cubeCreator;
    Cube cube1;
    Cube cube2;

    @BeforeClass
    public void setUp() {
        cubeCreator = new CubeCreator();
        cube1 = new Cube(1L, new Point(1.0, 1.0, 1.0), 1.0);
        cube2 = new Cube(2L, new Point(1.0, 1.0, 1.0), 1.0);
    }

    @AfterClass
    public void tierDown() {
        cubeCreator = null;
        cube1 = null;
        cube2 = null;
    }

    @BeforeMethod
    public void setUpMethod(){
        IdGenerator.setId(1);
    }

    @Test
    public void createPositiveTest() {
        Cube expected = cube1;
        List<Double> values = new ArrayList<>();
        values.add(1.0);
        values.add(1.0);
        values.add(1.0);
        values.add(1.0);

        Cube actual = cubeCreator.create(values);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void createNegativeTest() {
        Cube expected = cube1;
        List<Double> values = new ArrayList<>();
        values.add(2.0);
        values.add(1.0);
        values.add(1.0);
        values.add(1.0);

        Cube actual = cubeCreator.create(values);

        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void createCubesPositiveTest() {
        List<Cube> expected = new ArrayList<>();
        expected.add(cube1);
        expected.add(cube2);

        List<Double> values1 = new ArrayList<>();
        values1.add(1.0);
        values1.add(1.0);
        values1.add(1.0);
        values1.add(1.0);

        List<Double> values2 = new ArrayList<>();
        values2.add(1.0);
        values2.add(1.0);
        values2.add(1.0);
        values2.add(1.0);

        List<List<Double>> valuesList = new ArrayList<>();
        valuesList.add(values1);
        valuesList.add(values2);

        List<Cube> actual = cubeCreator.createCubes(valuesList);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void createCubesNegativeTest() {
        List<Cube> expected = new ArrayList<>();
        expected.add(cube1);
        expected.add(cube2);

        List<Double> values1 = new ArrayList<>();
        values1.add(1.0);
        values1.add(1.0);
        values1.add(1.0);
        values1.add(1.0);

        List<Double> values2 = new ArrayList<>();
        values2.add(2.0);
        values2.add(1.0);
        values2.add(1.0);
        values2.add(1.0);

        List<List<Double>> valuesList = new ArrayList<>();
        valuesList.add(values1);
        valuesList.add(values2);

        List<Cube> actual = cubeCreator.createCubes(valuesList);

        Assert.assertNotEquals(expected, actual);
    }
}
