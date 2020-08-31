package com.borisov.cube.specification;

import com.borisov.cube.entity.Cube;
import com.borisov.cube.specification.impl.CubeSpecificationById;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SpecificationByIdTest {
    CubeSpecification specification;
    Cube cube;

    @BeforeClass
    public void setUp() {
        cube = new Cube();
    }

    @AfterClass
    public void tierDown(){
        cube = null;
    }

    @Test
    public void specifyPositiveTest(){
        specification = new CubeSpecificationById(cube.getCubeId());
        boolean actual = specification.specify(cube);
        Assert.assertTrue(actual);
    }

    @Test
    public void specifyNegativeTest(){
        specification = new CubeSpecificationById(3L);
        boolean actual = specification.specify(cube);
        Assert.assertFalse(actual);
    }

}
