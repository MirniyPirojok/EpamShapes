package com.borisov.cube.specification.impl;

import com.borisov.cube.entity.Cube;
import com.borisov.cube.entity.Point;
import com.borisov.cube.specification.CubeSpecification;

public class CubeSpecificationByVertex implements CubeSpecification {
    private final Point vertex;

    public CubeSpecificationByVertex(Point vertex) {
        this.vertex = vertex;
    }

    @Override
    public boolean specify(Cube cube) {
        return cube.getVertex().equals(this.vertex);
    }
}
