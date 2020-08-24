package com.borisov.cube.generator;

public class IdGenerator {
    private static long id = 1;

    public static long generateId() {
        return id++;
    }
}
