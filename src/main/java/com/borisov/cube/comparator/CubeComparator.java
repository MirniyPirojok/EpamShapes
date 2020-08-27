package com.borisov.cube.comparator;

import com.borisov.cube.entity.Cube;

import java.util.Comparator;

public enum CubeComparator implements Comparator<Cube> {
    ID {
        @Override
        public int compare(Cube o1, Cube o2) {
            return Long.compare(o1.getCubeId(), o2.getCubeId());
        }
    },
    SIDE {
        @Override
        public int compare(Cube o1, Cube o2) {
            return Double.compare(o1.getSide(), o2.getSide());
        }
    },
    X {
        @Override
        public int compare(Cube o1, Cube o2) {
            return Double.compare(o1.getVertex().getX(), o2.getVertex().getX());
        }
    },
    Y {
        @Override
        public int compare(Cube o1, Cube o2) {
            return Double.compare(o1.getVertex().getY(), o2.getVertex().getY());
        }
    },
    Z {
        @Override
        public int compare(Cube o1, Cube o2) {
            return Double.compare(o1.getVertex().getZ(), o2.getVertex().getZ());
        }
    }
}
