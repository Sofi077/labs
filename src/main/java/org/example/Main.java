package org.example;
import java.util.Random;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {


        ArrayList<Double> value = new ArrayList<>();
        //заповнення вручну
        double[] handValues = {2.0, -4.0, 3.0, 0.0, 5.0, 1.0, -1.0, 4.0, 6.0, 7.0, 2.0, 1.0, -5.0, 7.0, 2.0, 1.0};
        for (double values : handValues) {
            value.add(values);
        }


       Matrix matrix_1 = new Matrix(4, 4);
        matrix_1.matrixFilling(value);
        matrix_1.print2D();

        //те що було
        System.out.println("----------------");
        double determinant = matrix_1.determinantOfMatrix(matrix_1);
        Matrix matrix_2 = new Matrix(matrix_1.algebraicComplement());
        matrix_2 = matrix_2.transpose();
        matrix_2 = matrix_2.scalarM(1/determinant);
        matrix_2.print2D();



        //нове добавила
        System.out.println("----------------");
        Matrix matrix_3 = new Matrix(matrix_1.reversed());
        matrix_3.print2D();



        System.out.println("----------------------------------------");


/*

        GenericMatrix<Double> matrixg1 = new GenericMatrix<>(3, 3);
        ArrayList<Double> value7 = new ArrayList<>();
        double[] handValues7 = {4.0, -7.0, 3.2, 10.0, -5.0, -2.2, 4.5, 5.0, 0.0};
        for (double values7 : handValues7) {
            value7.add(values7);
        }

        matrixg1.matrixFilling(value7);
        matrixg1.print2D();
*/














  //   GENERIC
/*
        //створення об'єкту GenericMatrix з Integer
        GenericMatrix<Double> matrix1 = new GenericMatrix<>(3, 3);

        ArrayList<Double> value1 = new ArrayList<>();
        double[] handValues1 = {3.0, -1.0, 2.0, 8.0, 2.0, -2.0, 4.0, 5.0, 3.0};
        for (double values1 : handValues1) {
            value1.add(values1);
        }

        matrix1.matrixFilling(value1);
        System.out.println("Generic Matrix 1:");
        matrix1.print2D();

        GenericMatrix<Double> matrix2 = new GenericMatrix<>(3, 3);
        ArrayList<Double> value7 = new ArrayList<>();
        double[] handValues7 = {4.0, -7.0, 3.2, 10.0, -5.0, -2.2, 4.5, 5.0, 0.0};
        for (double values7 : handValues7) {
            value7.add(values7);
        }
        matrix2.matrixFilling(value7);
        System.out.println("Generic Matrix 2:");
        matrix2.print2D();

        GenericMatrix<Double> matrix1sum = matrix1.add(matrix2);
        System.out.println("Sum");
        matrix1sum.print2D();

        //System.out.println(matrix1.getColumns());
        System.out.println(matrix1.getElement(0,0));

*/
   // Матриця яка заповнена букаваи

        //створення об'єкту GenericMatrix з Integer
        GenericMatrix<String> matrix1 = new GenericMatrix<>(3, 3);

        ArrayList<String> value1 = new ArrayList<>();
        //заповнення вручну
        String[] handValues1 = {"a1", "b1", "c1", "d1", "f1", "e1", "g1", "m1", "v1"};
        for (String values1 : handValues1) {
            value1.add(values1);
        }

        matrix1.matrixFilling(value1);
        System.out.println("Generic Matrix 1:");
        matrix1.print2D();

        GenericMatrix<String> matrix2 = new GenericMatrix<>(3, 3);
        ArrayList<String> value7 = new ArrayList<>();
        String[] handValues7 = {"a2", "b2", "c2", "d2", "f2", "e2", "g2", "m2", "v2"};
        for (String values7 : handValues7) {
            value7.add(values7);
        }
        matrix2.matrixFilling(value7);
        System.out.println("Generic Matrix 2:");
        matrix2.print2D();

        GenericMatrix<String> matrix1sum = matrix1.add(matrix2);
        System.out.println("Sum");
        matrix1sum.print2D();
        System.out.println(matrix1.getElement(0,0));

        GenericMatrix<String> matrix3 = new GenericMatrix<>(3, 3);
        matrix3 = matrix2.transpose();
        matrix3.print2D();

        GenericMatrix<String> matrix_4 = new GenericMatrix<>(3,3);
        matrix_4 = matrix3.add(matrix2);
        matrix_4.print2D();

    }
}