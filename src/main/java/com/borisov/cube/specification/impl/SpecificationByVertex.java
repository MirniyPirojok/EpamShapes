package com.borisov.cube.specification.impl;

import com.borisov.cube.entity.Cube;
import com.borisov.cube.entity.Point;
import com.borisov.cube.specification.Specification;

public class SpecificationByVertex implements Specification {
    Point vertex;

    public SpecificationByVertex(Point vertex) {
        this.vertex = vertex;
    }

    @Override
    public boolean specify(Cube cube) {
        return cube.getVertex().equals(this.vertex);
    }
}
