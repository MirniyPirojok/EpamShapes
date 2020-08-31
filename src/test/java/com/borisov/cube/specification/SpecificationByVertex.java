package com.borisov.cube.specification;

import com.borisov.cube.entity.Cube;
import com.borisov.cube.entity.Point;
import com.borisov.cube.specification.impl.CubeSpecificationByVertex;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SpecificationByVertex {
    CubeSpecification specification;
    Cube cube;

    @BeforeClass
    public void setUp(){
        cube = new Cube(new Point(1.0, 1.0, 1.0), 2.0);
    }

    @AfterClass
    public void tierDown(){
        cube = null;
    }

    @Test
    public void specifyPositiveTest(){
        Point vertex = new Point(1.0, 1.0, 1.0);
        specification = new CubeSpecificationByVertex(vertex);
        boolean actual = specification.specify(cube);
        Assert.assertTrue(actual);
    }

    @Test
    public void specifyNegativeTest(){
        Point vertex = new Point(2.0, 1.0, 1.0);
        specification = new CubeSpecificationByVertex(vertex);
        boolean actual = specification.specify(cube);
        Assert.assertFalse(actual);
    }

}
