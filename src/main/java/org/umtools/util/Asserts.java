/*
 * Copyright (c) 2025 UMTools contribution.
 * This program is made available under the terms of the MIT License.
 */
package org.umtools.util;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;

/**
 * Utility class providing assertion methods for validating conditions.
 *
 * @author Ng, Zhi Yang
 * @since 1.0
 */
public class Asserts {

    private Asserts() {

    }

    // ========================= Dimension Checks =========================
    public static void sameDimension(int[][] matrix1, int[][] matrix2, Class<? extends Exception> clazz, String message) {
        equalInt(matrix1.length, matrix2.length, clazz, message);
        for (int i = 0; i < matrix1.length; i++) {
            equalInt(matrix1[i].length, matrix2[i].length, clazz, message);
        }
    }

    public static void sameDimension(double[][] matrix1, double[][] matrix2, Class<? extends Exception> clazz, String message) {
        equalInt(matrix1.length, matrix2.length, clazz, message);
        for (int i = 0; i < matrix1.length; i++) {
            equalInt(matrix1[i].length, matrix2[i].length, clazz, message);
        }
    }

    public static void sameDimension(int[] array, int[] array2, Class<? extends Exception> clazz, String message) {
        equalInt(array.length, array2.length, clazz, message);
    }

    public static void sameDimension(double[] array, double[] array2, Class<? extends Exception> clazz, String message) {
        equalInt(array.length, array2.length, clazz, message);
    }

    public static void sameColumns(int[] array, int[][] matrix, Class<? extends Exception> clazz, String message) {
        for (int[] intArray : matrix) {
            equalInt(array.length, intArray.length, clazz, message);
        }
    }

    public static void sameColumns(double[] array, double[][] matrix, Class<? extends Exception> clazz, String message) {
        for (double[] doubleArray : matrix) {
            equalInt(array.length, doubleArray.length, clazz, message);
        }
    }

    // ========================= Comparison Checks =========================
    public static void equalInt(int value, int target, Class<? extends Exception> clazz, String message) {
        isTrue(value == target, clazz, message);
    }

    public static void equalDouble(double value, double target, double epsilon, Class<? extends Exception> clazz, String message) {
        isTrue(Math.abs(value - target) < epsilon, clazz, message);
    }

    public static void smallerThan(int value, int target, Class<? extends Exception> clazz, String message) {
        isTrue(value < target, clazz, message);
    }

    public static void greaterThan(int value, int target, Class<? extends Exception> clazz, String message) {
        isTrue(value > target, clazz, message);
    }

    public static void smallerThan(double value, double target, Class<? extends Exception> clazz, String message) {
        isTrue(value < target, clazz, message);
    }

    public static void greaterThan(double value, double target, Class<? extends Exception> clazz, String message) {
        isTrue(value > target, clazz, message);
    }

    public static void geq(int value, int target, Class<? extends Exception> clazz, String message) {
        isTrue(value >= target, clazz, message);
    }

    public static void leq(int value, int target, Class<? extends Exception> clazz, String message) {
        isTrue(value <= target, clazz, message);
    }

    public static void geq(double value, double target, Class<? extends Exception> clazz, String message) {
        isTrue(value >= target, clazz, message);
    }

    public static void leq(double value, double target, Class<? extends Exception> clazz, String message) {
        isTrue(value <= target, clazz, message);
    }

    public static void between(int value, int startInclusive, int endInclusive, Class<? extends Exception> clazz, String message) {
        isTrue(value >= startInclusive && value <= endInclusive, clazz, message);
    }

    public static void between(double value, double startInclusive, double endInclusive, Class<? extends Exception> clazz, String message) {
        isTrue(value >= startInclusive && value <= endInclusive, clazz, message);
    }

    public static void betweenExclusive(int value, int startExclusive, int endExclusive, Class<? extends Exception> clazz, String message) {
        isTrue(value > startExclusive && value < endExclusive, clazz, message);
    }

    public static void betweenExclusive(double value, double startExclusive, double endExclusive, Class<? extends Exception> clazz, String message) {
        isTrue(value > startExclusive && value < endExclusive, clazz, message);
    }

    // ========================= Emptiness Checks =========================
    public static void isEmpty(Collection<?> collection, Class<? extends Exception> clazz, String message) {
        isTrue(CollectionUtils.isEmpty(collection), clazz, message);
    }

    public static void isNotEmpty(Collection<?> collection, Class<? extends Exception> clazz, String message) {
        isTrue(CollectionUtils.isNotEmpty(collection), clazz, message);
    }

    public static void isEmpty(int[] array, Class<? extends Exception> clazz, String message) {
        isTrue(array == null || array.length == 0, clazz, message);
    }

    public static void isNotEmpty(int[] array, Class<? extends Exception> clazz, String message) {
        isTrue(array != null && array.length > 0, clazz, message);
    }

    public static void isEmpty(double[] array, Class<? extends Exception> clazz, String message) {
        isTrue(array == null || array.length == 0, clazz, message);
    }

    public static void isNotEmpty(double[] array, Class<? extends Exception> clazz, String message) {
        isTrue(array != null && array.length > 0, clazz, message);
    }

    public static void isEmpty(Object[] array, Class<? extends Exception> clazz, String message) {
        isTrue(array == null || array.length == 0, clazz, message);
    }

    public static void isNotEmpty(Object[] array, Class<? extends Exception> clazz, String message) {
        isTrue(array != null && array.length > 0, clazz, message);
    }

    // ========================= Positivity Checks =========================
    public static void isNonNegative(double number, Class<? extends Exception> clazz, String message) {
        isTrue(number >= 0, clazz, message);
    }

    public static void isPositive(double number, Class<? extends Exception> clazz, String message) {
        isTrue(number > 0, clazz, message);
    }

    public static void isNonNegative(int number, Class<? extends Exception> clazz, String message) {
        isTrue(number >= 0, clazz, message);
    }

    public static void isPositive(int number, Class<? extends Exception> clazz, String message) {
        isTrue(number > 0, clazz, message);
    }

    // ========================= Null Checks =========================
    public static void isNotNull(Object object, Class<? extends Exception> clazz, String message) {
        isTrue(object != null, clazz, message);
    }

    public static void isNull(Object object, Class<? extends Exception> clazz, String message) {
        isTrue(object == null, clazz, message);
    }

    // ========================= Core Assertion Logic =========================
    public static void isTrue(boolean condition, Class<? extends Exception> clazz, String message) {
        if (!condition) {
            try {
                throw (RuntimeException) clazz.getConstructor(String.class).newInstance(message);
            } catch (Exception e) {
                throw new RuntimeException("Failed to throw exception", e);
            }
        }
    }
}
