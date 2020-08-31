package com.borisov.cube.generator;

public class IdGenerator {
    private static long id = 0;

    private IdGenerator() {
    }

    public static long getId() {
        return id;
    }

    public static void setId(long id) {
        IdGenerator.id = id;
    }

    public static long generateId() {
        return id++;
    }
}
