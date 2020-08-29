package com.borisov.cube.action;

import com.borisov.cube.entity.Cube;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeAction {
    static Logger logger = LogManager.getLogger();

    static final int SURFACES_COUNT = 6;
    static final int PLANES_COUNT = 3;

    public double calculateArea(Cube cube) {
        double area = (SURFACES_COUNT * cube.getSide() * cube.getSide());
        logger.info(String.format("Cube id%d area: %s", cube.getCubeId(), area));
        return area;
    }

    public double calculateVolume(Cube cube) {
        double volume = Math.pow(cube.getSide(), 3);
        logger.info(String.format("Cube id%d volume: %s", cube.getCubeId(), volume));
        return volume;
    }

    //TODO: to do this method better
    public double[] volumesRatio(Cube cube) {
        double[] coordinates = cube.getVertex().getCoordinates();
        double[] ratioArray = new double[PLANES_COUNT];

        for (int i = 0; i < PLANES_COUNT; i++) {
            if (isCubeCut(cube, coordinates[i])) {
                ratioArray[i] = calculateRatio(cube, coordinates[i]);
            }
        }

        logger.info(String.format("Cube volumes ratio. By plane YZ: %s. By plane XZ: %s. By plane XY: %s.",
                ratioArray[0], ratioArray[1], ratioArray[2]));

        return ratioArray;
    }

    private boolean isCubeCut(Cube cube, double coordinate) {
        return (coordinate < 0) && (-coordinate < cube.getSide());
    }

    private double calculateRatio(Cube cube, double coordinate) {
        double cutSide1 = -coordinate;
        double cutSide2 = cube.getSide() + coordinate;
        return (cutSide1 / cutSide2);
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
