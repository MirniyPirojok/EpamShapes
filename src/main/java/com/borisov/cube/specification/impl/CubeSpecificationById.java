package com.borisov.cube.specification.impl;

import com.borisov.cube.entity.Cube;
import com.borisov.cube.specification.CubeSpecification;

public class CubeSpecificationById implements CubeSpecification {
    private final long id;

    public CubeSpecificationById(long id) {
        this.id = id;
    }

    @Override
    public boolean specify(Cube cube) {
        return cube.getCubeId() == this.id;
    }
}
