package com.borisov.cube.specification.impl;

import com.borisov.cube.entity.Cube;
import com.borisov.cube.specification.Specification;

public class SpecificationById implements Specification {
    private long id;

    public SpecificationById(long id) {
        this.id = id;
    }

    @Override
    public boolean specify(Cube cube) {
        return cube.getCubeId() == this.id;
    }
}
