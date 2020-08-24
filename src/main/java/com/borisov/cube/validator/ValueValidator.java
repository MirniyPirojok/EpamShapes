package com.borisov.cube.validator;

public class ValueValidator {
    static final String DATA_POINTS =
            "[-]?[\\d]+[.][\\d]+\\s[-]?[\\d]+[.][\\d]+\\s[-]?[\\d]+[.][\\d]+\\s[\\d]+[.][\\d]";

    public boolean isValidLine(String line) {
        return line.matches(DATA_POINTS);
    }
}
