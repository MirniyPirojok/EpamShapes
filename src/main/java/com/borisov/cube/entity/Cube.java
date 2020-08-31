package com.borisov.cube.entity;

import com.borisov.cube.generator.IdGenerator;
import com.borisov.cube.observer.Observable;
import com.borisov.cube.observer.Observer;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Cube implements Observable {
    static Logger logger = LogManager.getLogger();

    private long cubeId;
    private Point vertex;
    private double side;
    private final List<Observer> observers = new ArrayList<>();

    public Cube() {
    }

    public Cube(Point vertex, double side) {
        this.cubeId = IdGenerator.generateId();
        this.vertex = vertex;
        this.side = side;
    }

    public Cube(long cubeId, Point vertex, double side) {
        this.cubeId = cubeId;
        this.vertex = vertex;
        this.side = side;
    }

    public long getCubeId() {
        return cubeId;
    }

    public void setCubeId(long cubeId) {
        this.cubeId = cubeId;
        notifyObservers();
        logger.info(String.format("Id of cube id%d was set to %s", this.cubeId, this.cubeId));
    }

    public Point getVertex() {
        return vertex;
    }

    public void setVertex(Point vertex) {
        this.vertex = vertex;
        notifyObservers();
        logger.info(String.format("Vertex of cube id%d was set to %s", this.cubeId, this.vertex));

    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
        notifyObservers();
        logger.info(String.format("Side of cube id%d was set to %s", this.cubeId, this.side));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Cube cube = (Cube) o;

        return new EqualsBuilder()
                .append(cubeId, cube.cubeId)
                .append(side, cube.side)
                .append(vertex, cube.vertex)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(cubeId)
                .append(vertex)
                .append(side)
                .toHashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("cubeId=").append(cubeId);
        sb.append(", vertex").append(vertex);
        sb.append(", side=").append(side);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.actionPerformed(this);
        }
    }
}
