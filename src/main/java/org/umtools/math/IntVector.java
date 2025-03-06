package org.umtools.math;

public class IntVector implements NumpyClone<Integer> {
    private int[] array;

    public IntVector(int[] array) {
        this.array = array;
    }

    public Integer get(int index) {
        return array[index];
    }

    public void set(int index, int value) {
        array[index] = value;
    }

    @Override
    public int getRows() {
        return 1;
    }

    @Override
    public int getCols() {
        return array.length;
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
