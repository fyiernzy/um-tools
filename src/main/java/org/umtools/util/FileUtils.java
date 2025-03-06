/*
 * Copyright (c) 2025 UMTools contribution.
 * This program is made available under the terms of the MIT License.
 */
package org.umtools.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Utility class for file operations.
 *
 * @author Ng, Zhi Yang
 * @since 1.0
 */
public class FileUtils {

    private FileUtils() {

    }

    /**
     * Writes the content to the file at the given path.
     * Do nothing if the file does not exist.
     *
     * @param filePath the path of the file to write to
     * @param content  the content to write to the file
     * @since 1.0
     */
    public static void writeFile(String filePath, String content) {
        try (PrintWriter writer = new PrintWriter(filePath, StandardCharsets.UTF_8)) {
            writer.println(content);
        } catch (IOException ex) {
            System.out.println("Failed to write to file: " + ex.getMessage());
        }
    }

    /**
     * Reads the content of the file at the given path as string.
     *
     * @param filePath the path of the file to read
     * @return the content of the file as a string, null if the file does not exist
     */
    public static String readFileAsString(String filePath) {
        try {
            return Files.readString(Paths.get(filePath));
        } catch (IOException ex) {
            System.out.println("Failed to read file: " + ex.getMessage());
            return null;
        }
    }

    /**
     * Concatenates the paths with the file separator.
     *
     * @param paths the paths to concatenate
     * @return the concatenated path
     * @since 1.0
     */
    public static String dir(String... paths) {
        return String.join(File.separator, paths);
    }

    /**
     * Returns the extension of the file.
     *
     * @param fileName the name of the file
     * @return the extension of the file
     * @since 1.0
     */
    public static String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    /**
     * Returns the name of the file.
     *
     * @param filePath the path of the file
     * @return the name of the file
     * @since 1.0
     */
    public static String getFileName(String filePath) {
        return filePath.substring(filePath.lastIndexOf("/") + 1);
    }
}
