package org.umtools.math;

public interface NumpyClone<T> {
    int getRows();

    int getCols();

    NumpyClone<T> add(NumpyClone<T> nc);

    NumpyClone<T> subtract(NumpyClone<T> nc);

    NumpyClone<T> multiply(NumpyClone<T> nc);

    NumpyClone<T> divide(NumpyClone<T> nc);
}
