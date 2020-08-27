package com.borisov.cube.observer;

import com.borisov.cube.action.CubeAction;
import com.borisov.cube.entity.Cube;
import com.borisov.cube.warehouse.CubeParameters;
import com.borisov.cube.warehouse.CubeWarehouse;

public class CubeObserver implements Observer {

    @Override
    public void actionPerformed(Cube cube) {
        CubeAction cubeAction = new CubeAction();
        double area = cubeAction.calculateArea(cube);
        double volume = cubeAction.calculateVolume(cube);

        CubeParameters cubeParameters = new CubeParameters(area, volume);
        CubeWarehouse cubeWarehouse = CubeWarehouse.getInstance();

        cubeWarehouse.put(cube.getCubeId(), cubeParameters);
    }
}
