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

    public String volumesRatioByXY(Cube cube) {
        double z = cube.getVertex().getZ();
        double side = cube.getSide();
        long cubeId = cube.getCubeId();
        final String XY = "XY";

        if (z < 0 && -z < side) {
            double cutSide1 = -z;
            double cutSide2 = side + z;
            double part1Volume = calculatePartVolume(cube, cutSide1);
            double part2Volume = calculatePartVolume(cube, cutSide2);
            String volumesRatioByXY = (part1Volume + " : " + part2Volume);
            logger.info(String.format("Cube id%d volumes ratio by plane %s: %s", cubeId, XY, volumesRatioByXY));
            return volumesRatioByXY;
        }
        logger.info(String.format("Cube id%d is not cut by plane %s.", cubeId, XY));
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
            double part1Volume = calculatePartVolume(cube, cutSide1);
            double part2Volume = calculatePartVolume(cube, cutSide2);
            String volumesRatioByYZ = (part1Volume + " : " + part2Volume);
            logger.info(String.format("Cube id%d volumes ratio by plane %s: %s", cubeId, YZ, volumesRatioByYZ));
            return volumesRatioByYZ;
        }
        logger.info(String.format("Cube id%d is not cut by plane %s.", cubeId, YZ));
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
            logger.info(String.format("Cube id%d volumes ratio by plane %s: %s", cubeId, XZ, volumesRatioByXZ));
            return volumesRatioByXZ;
        }
        logger.info(String.format("Cube id%d is not cut by plane %s.", cubeId, XZ));
        return null;
    }

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
