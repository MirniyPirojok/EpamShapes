package com.borisov.cube.repository;

import com.borisov.cube.comparator.CubeComparator;
import com.borisov.cube.entity.Cube;
import com.borisov.cube.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CubesRepository {
    static Logger logger = LogManager.getLogger();
    private static CubesRepository instance;
    private final List<Cube> repositoryCubeList = new ArrayList<>();

    private CubesRepository() {
    }

    public static CubesRepository getInstance() {
        if (instance == null) {
            instance = new CubesRepository();
        }
        logger.info("Cubes repository is created.");
        return instance;
    }

    public List<Cube> query(Specification specification) {
        List<Cube> resultListCube = new ArrayList<>();
        for (Cube cube : repositoryCubeList) {
            if (specification.specify(cube)) {
                resultListCube.add(cube);
            }
        }
        return resultListCube;
    }

    public boolean add(Cube cube) {
        logger.info(String.format("Cube id%d was added to repository", cube.getCubeId()));
        return repositoryCubeList.add(cube);
    }

    public boolean addAll(List<Cube> cubeList) {
        logger.info("All cubes were added to repository.");
        return repositoryCubeList.addAll(cubeList);
    }

    public boolean remove(Cube cube) {
        logger.info(String.format("Cube id%d was removed from repository", cube.getCubeId()));
        return repositoryCubeList.remove(cube);
    }

    public void clear() {
        repositoryCubeList.clear();
    }

    public void sort(CubeComparator cubeComparator) {
        logger.info(String.format("Cubes were sorted in repository by %s", cubeComparator.name()));
        repositoryCubeList.sort(cubeComparator);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CubesRepository{");
        sb.append("repositoryCubeList=").append(repositoryCubeList);
        sb.append('}');
        return sb.toString();
    }
}
