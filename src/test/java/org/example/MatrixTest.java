package org.example;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class MatrixTest {
    @Test
    public void testMatrix() {
        ArrayList<Double> value = new ArrayList<>();
        double[] handValues = {2.0, -4.0, 3.0, 0.0, 5.0, 1.0, -1.0, 4.0, 6.0, 7.0, 2.0, 1.0, -5.0, 7.0, 2.0, 1.0};
        for (double values : handValues) {
            value.add(values);
        }
        //створюємо пусту матрицю
        Matrix matrix_1 = new Matrix(4, 4);
        matrix_1.matrixFilling(value);  //заповнюємо значеннями

        //детермінаннт
        double determinant = matrix_1.determinantOfMatrix(matrix_1);
        assertEquals(1287.0, determinant, 0.0001);

        //ось тут ми покроково шукаємо обрену матрицю
        Matrix matrix_2 = new Matrix(matrix_1.algebraicComplement());  //алгебраїчні доповнення
        matrix_2 = matrix_2.transpose();  //транспонуємо
        matrix_2 = matrix_2.scalarM(1 / determinant); //ділимо на обернений визначний

        //тут обернена матриця в одному методі
        Matrix matrix_3 = new Matrix(matrix_1.reversed());
        //тут створюємо матрицю, яка заповнена обернинеми значеннями
        ArrayList<Double> value2 = new ArrayList<>();
        double[] handValues2 = {
                0.0, -0.0, 0.09090909090909091, -0.09090909090909091,
                -0.07692307692307693, -0.02564102564102564, 0.07226107226107226, 0.030303030303030304,
                0.23076923076923078, -0.03418803418803419, 0.035742035742035744, 0.10101010101010101,
                0.07692307692307693, 0.24786324786324787, -0.12276612276612277, 0.13131313131313133

        };
        for (double values2 : handValues2) {
            value2.add(values2);
        }
        Matrix matrix_reserved = new Matrix(4, 4);
        matrix_reserved.matrixFilling(value2);  //заповнюємо значеннями

        boolean v = matrix_reserved.equal(matrix_3);  //тут запишеться резульата порівнняння
        assertTrue(v);  //і чи він true
        boolean vv = matrix_reserved.equal(matrix_2);
        assertTrue(vv);


        Matrix matrix_w = new Matrix();
        matrix_w =  matrix_2.multi(matrix_reserved);   //множення
        Matrix matrix_e = new Matrix();
        matrix_e =  matrix_2.addMatrix(matrix_1); //додавання

        double element = matrix_2.matrixGetElement(2,2);
        double element2 = matrix_2.matrixGetElement(4,2);
        boolean doub_equel_el = matrix_e.equal(element2);
        assertFalse(doub_equel_el);
        double rows[] = matrix_2.matrixGetRows(2);
        double cols[] = matrix_2.matrixGetColums(3);

        Matrix matrix_unit = matrix_1.unitM(4);

        matrix_1.dimension();
        Matrix matrix_row = matrix_1.matrixRow(value);
        Matrix matrix_col = matrix_1.matrixCol(value);
        boolean doub_equel = matrix_row.equal(matrix_col);  //тут запишеться резульата порівнняння
        assertFalse(doub_equel);  //і чи він false
        Matrix matrix_diagonal = matrix_1.diagonalMatrix(value);


        //GenericMatrix  для чисел
        GenericMatrix<Double> matrix1 = new GenericMatrix<>(3, 3);
        ArrayList<Double> value1 = new ArrayList<>();
        double[] handValues1 = {3.0, -1.0, 2.0, 8.0, 2.0, -2.0, 4.0, 5.0, 3.0};
        for (double values1 : handValues1) {
            value1.add(values1);
        }
        matrix1.matrixFilling(value1);


        GenericMatrix<Double> matrix2 = new GenericMatrix<>(3, 3);
        ArrayList<Double> value7 = new ArrayList<>();
        double[] handValues7 = {4.0, -7.0, 3.2, 10.0, -5.0, -2.2, 4.5, 5.0, 0.0};
        for (double values7 : handValues7) {
            value7.add(values7);
        }
        matrix2.matrixFilling(value7);

        //додавання
        GenericMatrix<Double> matrix12sum = matrix1.add(matrix2);
        assertEquals(Double.valueOf(7.0), matrix12sum.getElement(0, 0));  //перший елеемнт порівнюємо

        matrix_2.print2D();
        //GenericMatrix з String
        GenericMatrix<String> matrix3 = new GenericMatrix<>(3, 3);
        ArrayList<String> value3 = new ArrayList<>();
        String[] handValues3 = {"a1", "b1", "c1", "d1", "f1", "e1", "g1", "m1", "v1"};
        for (String values3 : handValues3) {
            value3.add(values3);
        }
        matrix3.matrixFilling(value3);

        GenericMatrix<String> matrix4 = new GenericMatrix<>(3, 3);
        ArrayList<String> value4 = new ArrayList<>();
        String[] handValues4 = {"a2", "b2", "c2", "d2", "f2", "e2", "g2", "m2", "v2"};
        for (String values4 : handValues4) {
            value4.add(values4);
        }
        matrix4.matrixFilling(value4);
        GenericMatrix<String> matrix34sum = matrix3.add(matrix4);
        assertEquals(("a1a2"), matrix34sum.getElement(0, 0));  //иак само порівнюємо перший елемент матриці
                                                                          //яка є конкетенацією
        matrix4.print2D();

        // transpose
        GenericMatrix<String> matrix3Transposed = matrix3.transpose();
        assertEquals("a1", matrix3Transposed.getElement(0, 0));


    }
}
