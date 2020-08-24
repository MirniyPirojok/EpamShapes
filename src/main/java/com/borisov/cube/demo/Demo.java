package com.borisov.cube.demo;

import com.borisov.cube.action.CubeAction;
import com.borisov.cube.creator.CubeListCreator;
import com.borisov.cube.entity.Cube;
import com.borisov.cube.exception.CustomException;
import com.borisov.cube.parser.CubeDataParser;
import com.borisov.cube.reader.CubeDataReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    static Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws CustomException {

        CubeDataReader cubeDataReader = new CubeDataReader();
        List<String> data = cubeDataReader.readData("data/data.txt");

        CubeDataParser cubeDataParser = new CubeDataParser();
        List<List<Double>> parsedData = cubeDataParser.parseData(data);

        CubeListCreator cubeListCreator = new CubeListCreator();
        List<Cube> cubes = cubeListCreator.createCubes(parsedData);

        CubeAction cubeAction = new CubeAction();
        List<Double> squares = new ArrayList<>();
        double square;
        List<Double> volumes = new ArrayList<>();
        double volume;
        List<String> volumesRatioByXY = new ArrayList<>();
        String volumeRatioXY;
        List<String> volumesRatioByYZ = new ArrayList<>();
        String volumeRatioYZ;
        List<String> volumesRatioByXZ = new ArrayList<>();
        String volumeRatioXZ;
        List<Boolean> areCubesOnPlanes = new ArrayList<>();
        boolean isOnPlane;

        List<double[]> volumesRatioByPlane = new ArrayList<>();
        double[] volumesRatio;

        for (Cube cube : cubes) {
            square = cubeAction.calculateSquare(cube);
            squares.add(square);
            volume = cubeAction.calculateVolume(cube);
            volumes.add(volume);

            volumesRatio = cubeAction.ratioBetweenVolumes(cube);
            volumesRatioByPlane.add(volumesRatio);

            isOnPlane = cubeAction.isOnPlane(cube);
            areCubesOnPlanes.add(isOnPlane);
        }
    }
}//end of class
