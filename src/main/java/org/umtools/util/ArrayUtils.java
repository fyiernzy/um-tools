/*
 * Copyright (c) 2025 UMTools contribution.
 * This program is made available under the terms of the MIT License.
 */
package org.umtools.util;

public class ArrayUtils {
    /**
     * Swap two elements in an array
     *
     * @param array the array
     * @param i     index of the first element
     * @param j     index of the second element
     * @since 1.0
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * Swap two elements in an array
     *
     * @param array the array
     * @param i     index of the first element
     * @param j     index of the second element
     */
    public static void swap(double[] array, int i, int j) {
        double temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
