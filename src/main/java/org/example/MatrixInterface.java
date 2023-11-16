package org.example;
import java.util.ArrayList;
public interface MatrixInterface {
    double[][] GetMatrix();
    int GetRows();
    int GetCols();
    void print2D();
    double[][] matrixFilling(ArrayList<Double> value);
    double[] matrixGetRows(int given_rows);
    double[] matrixGetColums(int given_cols);
    double matrixGetElement(int rows_element, int cols_element);
    int[] dimension();
    boolean equal(double n2);
    boolean equal(double[] n1);
    String getClassIdentifier();
    boolean equal(MatrixInterface m2);
}
