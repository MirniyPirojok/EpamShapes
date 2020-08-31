package com.borisov.cube.specification;

import com.borisov.cube.entity.Cube;
import com.borisov.cube.entity.Point;
import com.borisov.cube.specification.impl.CubeSpecificationBySide;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SpecificationBySideTest {
    CubeSpecification specification;
    Cube cube;

    @BeforeClass
    public void setUp() {
        cube = new Cube(new Point(1.0, 2.0, 3.0), 4.0);
    }

    @AfterClass
    public void tierDown() {
        cube = null;
    }

    @Test
    public void specifyPositiveTest() {
        specification = new CubeSpecificationBySide(3.0);
        boolean actual = specification.specify(cube);
        Assert.assertTrue(actual);
    }

    @Test
    public void specifyNegativeTest(){
        specification = new CubeSpecificationBySide(5.0);
        boolean actual = specification.specify(cube);
        Assert.assertFalse(actual);
    }
}
