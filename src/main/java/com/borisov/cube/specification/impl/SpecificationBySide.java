package com.borisov.cube.specification.impl;

import com.borisov.cube.entity.Cube;
import com.borisov.cube.specification.Specification;

public class SpecificationBySide implements Specification {
    double minimalSideSize;

    public SpecificationBySide(double minimalSideSize) {
        this.minimalSideSize = minimalSideSize;
    }

    @Override
    public boolean specify(Cube cube) {
        return cube.getSide() >= this.minimalSideSize;
    }
}
