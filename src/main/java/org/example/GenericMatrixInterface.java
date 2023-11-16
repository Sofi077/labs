package org.example;
public interface GenericMatrixInterface<T> {
    int getRows();

    int getColumns();

    T getElement(int row, int column);

    void setElement(int row, int column, T value);

    GenericMatrix<T> add(GenericMatrix<T> other);
}

