package com.borisov.cube.action;

import com.borisov.cube.entity.Cube;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeAction {
    static Logger logger = LogManager.getLogger();

    public double calculateArea(Cube cube) {
        int surfacesCount = 6;
        double area = (surfacesCount * cube.getSide() * cube.getSide());
        logger.info(String.format("Cube id%d area: %s", cube.getCubeId(), area));
        return area;
    }

    public double calculateVolume(Cube cube) {
        int sidesNumber = 3;
        double volume = Math.pow(cube.getSide(), sidesNumber);
        logger.info(String.format("Cube id%d volume: %s", cube.getCubeId(), volume));
        return volume;
    }

    //TODO: to do this method better
    static final int PLANES_COUNT = 3;

    public double[] volumesRatio(Cube cube) {
        double[] coordinates = cube.getVertex().getCoordinates();
        double[] ratioArray = new double[PLANES_COUNT];

        for (int i = 0; i < PLANES_COUNT; i++) {
            if (coordinates[i] < 0 && -coordinates[i] < cube.getSide()) {
                ratioArray[i] = calculateRatio(cube, coordinates[i]);
            }
        }
        return ratioArray;
    }

    private double calculateRatio(Cube cube, double coordinate) {
        double cutSide1 = -coordinate;
        double cutSide2 = cube.getSide() + coordinate;
        return cutSide1 / cutSide2;
        //sides ratio is equal to volumes ratio
        // because we count that cube is always parallel to plane
    }

    public boolean isOnPlane(Cube cube) {
        long cubeId = cube.getCubeId();

        boolean cubOnPlane = ((cube.getVertex().getX() == 0)
                || (cube.getVertex().getY() == 0)
                || (cube.getVertex().getZ() == 0));

        logger.info(String.format("Cube id%d is on plane: %b", cubeId, cubOnPlane));
        return cubOnPlane;
    }
}
