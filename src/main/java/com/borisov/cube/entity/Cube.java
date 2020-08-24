package com.borisov.cube.entity;

import com.borisov.cube.generator.IdGenerator;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Cube {
    private long cubeId;
    private Point vertex;
    private double side;

    public Cube() {
    }

    public Cube(Point vertex, double side) {
        this.cubeId = IdGenerator.generateId();
        this.vertex = vertex;
        this.side = side;
    }

    public long getCubeId() {
        return cubeId;
    }

    public void setCubeId(long cubeId) {
        this.cubeId = cubeId;
    }

    public Point getVertex() {
        return vertex;
    }

    public void setVertex(Point vertex) {
        this.vertex = vertex;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
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
}
