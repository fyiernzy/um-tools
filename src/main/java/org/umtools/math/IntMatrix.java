package org.umtools.math;

public class IntMatrix implements NumpyClone<Integer> {
    private int[][] matrix;

    public IntMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public Integer get(int row, int col) {
        return matrix[row][col];
    }

    public void set(int row, int col, int value) {
        matrix[row][col] = value;
    }

    @Override
    public int getRows() {
        return matrix.length;
    }

    @Override
    public int getCols() {
        return matrix[0].length;
    }

    @Override
    public NumpyClone<Integer> add(NumpyClone<Integer> nc) {
        return null;
    }

    @Override
    public NumpyClone<Integer> subtract(NumpyClone<Integer> nc) {
        return null;
    }

    @Override
    public NumpyClone<Integer> multiply(NumpyClone<Integer> nc) {
        return null;
    }

    @Override
    public NumpyClone<Integer> divide(NumpyClone<Integer> nc) {
        return null;
    }
}
