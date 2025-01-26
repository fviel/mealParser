package com.fviel.mealParser.meal.services;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

/**
 * This class considers that the file is at src/main/resources
 */
@Service
public class FileService {

    private final String FILENAME = "data.txt";    

    /*
     * Converts ClassPathResource to Path by copying it to a temporary file.
     */
    public Path getFilePathAsPathByMakingAnTempCopy() throws IOException {
        ClassPathResource resource = new ClassPathResource(FILENAME);

        // Create a temporary file
        Path tempFile = Files.createTempFile("data", ".txt");

        // Copy the resource content to the temp file
        try (InputStream inputStream = resource.getInputStream()) {
            Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);
        }
        return tempFile;
    }

    public String getFilePathAsStringByMakingAnTempCopy() throws IOException {
        ClassPathResource resource = new ClassPathResource(FILENAME);

        // Create a temporary file
        Path tempFile = Files.createTempFile("data", ".txt");

        // Copy the resource content to the temp file
        try (InputStream inputStream = resource.getInputStream()) {
            Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);
        }
        return tempFile.toString();
    }
}
