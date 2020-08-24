package com.borisov.cube.validator;

import com.borisov.cube.entity.Cube;

public class CubeValidator {
    public boolean isCube(Cube cube) {
        return cube.getSide() > 0;
    }
}
