package com.borisov.cube.action;

import com.borisov.cube.entity.Cube;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeAction {
    static Logger logger = LogManager.getLogger();
    static final String VOLUMES_RATIO = "Cube id%d volumes ratio by plane %s: %s";
    static final String CUBE_NOT_CUT = "Cube id%d is not cut by plane %s.";


    public double calculateSquare(Cube cube) {
        int surfacesNumber = 6;
        double square = (surfacesNumber * cube.getSide() * cube.getSide());
        logger.info(String.format("Cube id%d square: %s", cube.getCubeId(), square));
        return square;
    }

    public double calculateVolume(Cube cube) {
        int sidesNumber = 3;
        double volume = Math.pow(cube.getSide(), sidesNumber);
        logger.info(String.format("Cube id%d volume: %s", cube.getCubeId(), volume));
        return volume;
    }

    //TODO: fill arrays in a different way, may be use Map
    public double[] ratioBetweenVolumes(Cube cube) {
        int planesCount = 3;
        double[] coordinates = new double[planesCount];
        coordinates[0] = cube.getVertex().getX();
        coordinates[1] = cube.getVertex().getY();
        coordinates[2] = cube.getVertex().getZ();

        String[] planes = new String[planesCount];
        planes[0] = "YZ";
        planes[1] = "XZ";
        planes[2] = "XY";

        double[] volumesRatioArray = new double[planesCount];

        double side = cube.getSide();
        long cubeId = cube.getCubeId();

        for (int i = 0; i < planesCount; i++) {
            if (coordinates[i] < 0 && -coordinates[i] < side) {
                double cutSide1 = -coordinates[i];
                double cutSide2 = side + coordinates[i];
                double part1Volume = countPartVolume(cube, cutSide1);
                double part2Volume = countPartVolume(cube, cutSide2);
                volumesRatioArray[i] = (part1Volume / part2Volume);
                logger.info(String.format(VOLUMES_RATIO, cubeId, planes[i], volumesRatioArray[i]));
            } else {
                logger.info(String.format(CUBE_NOT_CUT, cubeId, planes[i]));
            }
        }
        return volumesRatioArray;
    }

    private double countPartVolume(Cube cube, double cutSide) {
        double side = cube.getSide();
        return side * side * cutSide;
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
