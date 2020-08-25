package com.borisov.cube.action;

import com.borisov.cube.entity.Cube;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeAction {
    static Logger logger = LogManager.getLogger();
    static final String VOLUMES_RATIO = "Cube id%d volumes ratio by plane %s: %s";
    static final String CUBE_NOT_CUT = "Cube id%d is not cut by plane %s.";


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

    public String volumesRatioByXY(Cube cube) {
        double z = cube.getVertex().getZ();
        double side = cube.getSide();
        long cubeId = cube.getCubeId();
        final String XY = "XY";

        if (z < 0 && -z < side) {
            double cutSide1 = -z;
            double cutSide2 = side + z;
            String volumesRatioByXY = (side * side * cutSide1 + " : " + side * side * cutSide2);
            logger.info(String.format(VOLUMES_RATIO, cubeId, XY, volumesRatioByXY));
            return volumesRatioByXY;
        }
        logger.info(String.format(CUBE_NOT_CUT, cubeId, XY));
        return null;
    }

    public String volumesRatioByYZ(Cube cube) {
        double x = cube.getVertex().getX();
        double side = cube.getSide();
        long cubeId = cube.getCubeId();
        final String YZ = "YZ";

        if (x < 0 && -x < side) {
            double cutSide1 = -x;
            double cutSide2 = side + x;
            String volumesRatioByYZ = (side * side * cutSide1 + " : " + side * side * cutSide2);
            logger.info(String.format(VOLUMES_RATIO, cubeId, YZ, volumesRatioByYZ));
            return volumesRatioByYZ;
        }
        logger.info(String.format(CUBE_NOT_CUT, cubeId, YZ));
        return null;
    }

    public String volumesRatioByXZ(Cube cube) {
        double y = cube.getVertex().getY();
        double side = cube.getSide();
        long cubeId = cube.getCubeId();
        final String XZ = "XZ";

        if (y < 0 && -y < side) {
            double cutSide1 = -y;
            double cutSide2 = side + y;
            double part1Volume = calculatePartVolume(cube, cutSide1);
            double part2Volume = calculatePartVolume(cube, cutSide2);
            String volumesRatioByXZ = (part1Volume + " : " + part2Volume);
            logger.info(String.format(VOLUMES_RATIO, cubeId, XZ, volumesRatioByXZ));
            return volumesRatioByXZ;
        }
        logger.info(String.format(CUBE_NOT_CUT, cubeId, XZ));
        return null;
    }

//    //TODO: to do this method better, fill arrays in a different way, may be use Map
//    public double[] ratioBetweenVolumes(Cube cube) {
//        int planesCount = 3;
//        double[] coordinates = new double[planesCount];
//        coordinates[0] = cube.getVertex().getX();
//        coordinates[1] = cube.getVertex().getY();
//        coordinates[2] = cube.getVertex().getZ();
//
//        String[] planes = new String[planesCount];
//        planes[0] = "YZ";
//        planes[1] = "XZ";
//        planes[2] = "XY";
//
//        double[] volumesRatioArray = new double[planesCount];
//
//        double side = cube.getSide();
//        long cubeId = cube.getCubeId();
//
//        for (int i = 0; i < planesCount; i++) {
//            if (coordinates[i] < 0 && -coordinates[i] < side) {
//                double cutSide1 = -coordinates[i];
//                double cutSide2 = side + coordinates[i];
//                double part1Volume = calculatePartVolume(cube, cutSide1);
//                double part2Volume = calculatePartVolume(cube, cutSide2);
//                volumesRatioArray[i] = (part1Volume / part2Volume);
//                logger.info(String.format(VOLUMES_RATIO, cubeId, planes[i], volumesRatioArray[i]));
//            } else {
//                logger.info(String.format(CUBE_NOT_CUT, cubeId, planes[i]));
//            }
//        }
//        return volumesRatioArray;
//    }

    private double calculatePartVolume(Cube cube, double cutSide) {
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
