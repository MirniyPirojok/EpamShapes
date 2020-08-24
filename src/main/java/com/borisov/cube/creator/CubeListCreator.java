package com.borisov.cube.creator;

import com.borisov.cube.entity.Cube;
import com.borisov.cube.entity.Point;
import com.borisov.cube.validator.CubeValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CubeListCreator {
    static Logger logger = LogManager.getLogger();

    public Cube createCube(List<Double> values) {
        double x = values.get(0);
        double y = values.get(1);
        double z = values.get(2);
        double side = values.get(3);

        Point vertex = new Point(x, y, z);
        Cube cube = new Cube(vertex, side);
        CubeValidator cubeValidator = new CubeValidator();

        if (cubeValidator.isCube(cube)) {
            logger.info(cube.toString());
            return cube;
        } else {
            logger.error("Shape is not cube.");
            return null;
        }
    }

    public List<Cube> createCubes(List<List<Double>> valuesList) {
        List<Cube> cubes = new ArrayList<>();
        for (List<Double> values : valuesList) {
            Cube cube = createCube(values);
            cubes.add(cube);
        }

        if (cubes.isEmpty()) {
            logger.info("Cube list is not created");
        } else {
            logger.info("Cube list is created.");
        }
        return cubes;
    }
}