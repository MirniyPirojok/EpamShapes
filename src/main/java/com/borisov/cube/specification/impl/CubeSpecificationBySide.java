package com.borisov.cube.specification.impl;

import com.borisov.cube.entity.Cube;
import com.borisov.cube.specification.CubeSpecification;

public class CubeSpecificationBySide implements CubeSpecification {
    private final double minimalSideSize;

    public CubeSpecificationBySide(double minimalSideSize) {
        this.minimalSideSize = minimalSideSize;
    }

    @Override
    public boolean specify(Cube cube) {
        return cube.getSide() >= this.minimalSideSize;
    }
}
