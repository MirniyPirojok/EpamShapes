package com.borisov.cube.parser;

import com.borisov.cube.exception.CustomException;
import com.borisov.cube.validator.ValueValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CubeDataParser {
    static final String REGEX_DELIMITER = "\\s+";
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

    public List<List<Double>> parseData(List<String> lines) throws CustomException {
        List<List<Double>> valuesList = new ArrayList<>();

        if (lines.isEmpty()) {
            logger.fatal("There is no data for parsing.");
            throw new CustomException("There is no data for parsing.");
        }

        ValueValidator valueValidator = new ValueValidator();
        long lineNumber = 0;
        for (String line : lines) {
            lineNumber++;
            if (valueValidator.isValidLine(line)) {
                List<Double> values = parseLineToDouble(line);
                logger.info(String.format("Line #%d is parsed", lineNumber));
                valuesList.add(values);
            } else {
                logger.warn(String.format("Invalid line #%d", lineNumber));
            }
        }
        return valuesList;
    }
}