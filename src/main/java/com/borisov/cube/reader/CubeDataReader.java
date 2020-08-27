package com.borisov.cube.reader;

import com.borisov.cube.exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class CubeDataReader {
    static Logger logger = LogManager.getLogger();

    public List<String> readData(String filePath) throws CustomException {
        List<String> lines;
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            lines = bufferedReader.lines().collect(Collectors.toList());
            logger.info("File was read");

        } catch (FileNotFoundException e) {
            logger.error("File not found.", e);
            throw new CustomException("File not found.", e);

        } catch (IOException e) {
            logger.error("Cannot read file.", e);
            throw new CustomException("Cannot read file.", e);
        }
        return lines;
    }
}
