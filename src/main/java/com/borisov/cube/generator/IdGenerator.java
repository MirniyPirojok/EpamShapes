package com.borisov.cube.generator;

public class IdGenerator {
    private static long id = 0;

    public static long generateId() {
        return id++;
    }
}
