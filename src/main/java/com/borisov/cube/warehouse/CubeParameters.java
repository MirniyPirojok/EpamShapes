package com.borisov.cube.warehouse;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class CubeParameters {
    private double area;
    private double volume;

    public CubeParameters(double area, double volume) {
        this.area = area;
        this.volume = volume;
    }

    public CubeParameters() {
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        CubeParameters that = (CubeParameters) o;

        return new EqualsBuilder()
                .append(area, that.area)
                .append(volume, that.volume)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(area)
                .append(volume)
                .toHashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CubeParameters{");
        sb.append("area=").append(area);
        sb.append(", volume=").append(volume);
        sb.append('}');
        return sb.toString();
    }
}
