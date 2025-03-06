/*
 * Copyright (c) 2025 UMTools contribution.
 * This program is made available under the terms of the MIT License.
 */
package org.umtools.util;

import org.apache.commons.lang3.reflect.FieldUtils;

/**
 * A utility class for reflection operations.
 *
 * @author Ng, Zhi Yang
 * @since 1.0
 */
public class ReflectionUtils {
    private ReflectionUtils() {

    }

    /**
     * Read the value of a field from an object
     *
     * @param object    The object to read the field from
     * @param fieldName The name of the field to read
     * @return The value of the field
     * @since 1.0
     */
    public static Object readField(Object object, String fieldName) throws IllegalAccessException {
        return FieldUtils.readField(object, fieldName, true);
    }

    /**
     * Read the value of a field from an object as a string, return "N/A" if the field is not found
     *
     * @param object    The object to read the field from
     * @param fieldName The name of the field to read
     * @return The value of the field as a string
     * @since 1.0
     */
    public static String readFieldAsString(Object object, String fieldName) {
        return readFieldAsString(object, fieldName, "N/A");
    }

    /**
     * Read the value of a field from an object as a string, return the default value if the field is not found.
     *
     * @param object       The object to read the field from
     * @param fieldName    The name of the field to read
     * @param defaultValue The default value to return if the field is not found
     * @return The value of the field as a string
     * @since 1.0
     */
    public static String readFieldAsString(Object object, String fieldName, String defaultValue) {
        try {
            return String.valueOf(readField(object, fieldName));
        } catch (IllegalAccessException e) {
            return defaultValue;
        }
    }
}
