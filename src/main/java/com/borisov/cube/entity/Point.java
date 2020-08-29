package com.borisov.cube.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Point {
    private double x;
    private double y;
    private double z;

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double[] getCoordinates() { //for calculating ratio between volumes
        return new double[]{x, y, z};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        return new EqualsBuilder()
                .append(x, point.x)
                .append(y, point.y)
                .append(z, point.z)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(x)
                .append(y)
                .append(z)
                .toHashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("(");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append(", z=").append(z);
        sb.append(")");
        return sb.toString();
    }
}
