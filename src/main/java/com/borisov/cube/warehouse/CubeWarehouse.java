package com.borisov.cube.warehouse;

import java.util.HashMap;
import java.util.Map;

public class CubeWarehouse {
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
        return parametersMap.put(cubeId, cubeParameters);
    }

    public CubeParameters putIfAbsent(Long cubeId, CubeParameters cubeParameters) {
        return parametersMap.putIfAbsent(cubeId, cubeParameters);
    }

    public CubeParameters remove(Long cubeId) {
        return parametersMap.remove(cubeId);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CubeWarehouse");
        sb.append(parametersMap);
        return sb.toString();
    }
}
