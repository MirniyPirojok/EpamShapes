package com.borisov.cube.warehouse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CubeWarehouse {
    static Logger logger = LogManager.getLogger();
    private static CubeWarehouse instance;
    private final Map<Long, CubeParameters> parametersMap;

    private CubeWarehouse() {
        parametersMap = new HashMap<>();
    }

    public static CubeWarehouse getInstance() {
        if (instance == null) {
            instance = new CubeWarehouse();
        }
        return instance;
    }

    public CubeParameters get(Long cubeId) {
        return parametersMap.get(cubeId);
    }

    public CubeParameters put(Long cubeId, CubeParameters cubeParameters) {
        logger.info(String.format("Cube id%d was put to warehouse", cubeId));
        return parametersMap.put(cubeId, cubeParameters);
    }

    public CubeParameters putIfAbsent(Long cubeId, CubeParameters cubeParameters) {
        logger.info(String.format("Cube id%d was put to warehouse", cubeId));
        return parametersMap.putIfAbsent(cubeId, cubeParameters);
    }

    public void putAll(Map<Long, CubeParameters> cubes) {
        logger.info("Cubes were put to warehouse");
        parametersMap.putAll(cubes);
    }

    public CubeParameters remove(Long cubeId) {
        logger.info(String.format("Cube id%d was removed form warehouse", cubeId));
        return parametersMap.remove(cubeId);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CubeWarehouse");
        sb.append(parametersMap);
        return sb.toString();
    }
}
