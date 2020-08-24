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
        final String YZ ="YZ";

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
            String volumesRatioByXZ = (side * side * cutSide1 + " : " + side * side * cutSide2);
            logger.info(String.format(VOLUMES_RATIO, cubeId, XZ, volumesRatioByXZ));
            return volumesRatioByXZ;
        }
        logger.info(String.format(CUBE_NOT_CUT, cubeId, XZ));
        return null;
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
