package com.borisov.cube.parser;

import com.borisov.cube.validator.ValueValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CubeDataParser {
    private static final String REGEX_DELIMITER = "\\s+";
    static Logger logger = LogManager.getLogger();


    public List<Double> parseLineToDouble(String line) {
        line = line.trim();
        String[] valuesStr = line.split(REGEX_DELIMITER);
        List<Double> values = new ArrayList<>();
        double value;
        for (String valueStr : valuesStr) {
            value = Double.parseDouble(valueStr);
            values.add(value);
        }
        return values;
    }

    public List<List<Double>> parseData(List<String> lines) {
        List<List<Double>> valuesList = new ArrayList<>();
        ValueValidator valueValidator = new ValueValidator();

        int counter = 0;
        for (String line : lines) {
            counter++;
            if (valueValidator.isValidLine(line)) {
                List<Double> values = parseLineToDouble(line);
                logger.info(String.format("Line #%d is parsed", counter));
                valuesList.add(values);
            } else {
                logger.error(String.format("Invalid line #%d", counter));
            }
        }
        return valuesList;
    }
}
