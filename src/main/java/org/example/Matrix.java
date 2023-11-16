package org.example;
import java.util.ArrayList;
import java.util.Random;

public class Matrix implements MatrixInterface {
    private double[][] matrix;
    private int rows;
    private int cols;
    private final String classIdentifier = "Matrix";
    @Override
    public double[][] GetMatrix() {
        return matrix;
    }
    @Override
    public int GetRows() {
        return rows;
    }
    @Override
    public int GetCols() {
        return cols;
    }

    //конструктор для порожньої матриці
    public Matrix() {
        this.rows = 0;  //посилаємося на поле об'єкта, а не на параметр методу
        this.cols = 0;
        matrix = new double[0][0];
    }
    //конструктор для створення матриці заданого розміру
    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        matrix = new double[rows][cols];
    }

    //конструктор для створення копії іншої матриці
    public Matrix(MatrixInterface m2)
    {
        int r,c;
        //r=m.matrix.length;
        //c=m.matrix[0].length;
        r=m2.GetRows();
        c=m2.GetCols();
        this.rows = r;
        this.cols = c;
        matrix = new double [r][c];
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                //matrix[i][j]=m.matrix[i][j];
                matrix[i][j] = m2.GetMatrix()[i][j];
            }
        }
    }
    @Override
    public void print2D() {
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                System.out.print(this.matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public double[][] matrixFilling(ArrayList<Double> value){  //заповнення матриці
        //на параметр приходить лист значень якими заповнити
        int valueIndex = 0;

        try {

            if (this.matrix.length*this.matrix[0].length!=value.size()){
                throw new ExceptionE("Кількість значень не відповідає розмірності матриці, яка заповнюється");
            }
            for (int r = 0; r < this.matrix.length; r++) {
                for (int c = 0; c < this.matrix[r].length; c++) {
                    this.matrix[r][c] = value.get(valueIndex);
                    valueIndex++;
                }
            }
        }
        catch (ExceptionE e){
            System.err.println("Помилка: " + e.getMessage());
            System.exit(0);
        }
        return matrix;
    }

    public double[][] fillMatrixWithRandomValues() {
        Random random = new Random();
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                double randomValue = -10 + (10 - -10) * random.nextDouble();
                this.matrix[i][j] = Math.round(randomValue * 10.0) / 10.0;
            }

        }
        return matrix;
    }


    @Override
    public double[] matrixGetRows(int given_rows){


        double[] row = new double[0];
        try {
            if (this.matrix.length < given_rows || given_rows<=0){
                throw new ExceptionE("Заданий рядок не відповідає розмірності матриці");
            }
            for (int x = 0; x < this.matrix.length; x++) {
                row = this.matrix[given_rows - 1];
            }
            System.out.println("given rows");
            for (int i = 0; i < row.length; i++) {
                System.out.print(row[i] + " ");
            }
        }catch (ExceptionE e){
            System.err.println("Помилка: " + e.getMessage());
            System.exit(0);
        }
        return row;
    }

    @Override
    public double[] matrixGetColums(int given_cols){

        double[] column = new double[this.matrix.length];
        try {
            if (this.matrix[0].length < given_cols || given_cols<=0){
                throw new ExceptionE("Заданий стовпець не відповідає розмірності матриці");
            }
            for (int i = 0; i < column.length; i++) {
                column[i] = this.matrix[i][given_cols - 1];
            }

            System.out.println("\ngiven cols");
            for (int x = 0; x < column.length; x++) {
                System.out.print(column[x] + " ");
            }
        }
        catch (ExceptionE e){
            System.err.println("Помилка: " + e.getMessage());
            System.exit(0);
        }
        System.out.println();
        return column;
    }
    @Override
    public double matrixGetElement(int rows_element, int cols_element){
        double element=0;
        try {
            if (this.matrix.length<rows_element || this.matrix[0].length< cols_element || rows_element<=0 || cols_element <=0){
                throw new ExceptionE("Заданий елемент не відповідає розмірності матриці");
            }
            for (int i = 0; i < this.matrix.length; i++) {
                for (int j = 0; j < this.matrix[i].length; j++) {
                    element = this.matrix[rows_element - 1][cols_element - 1];
                }
            }
        }
        catch (ExceptionE e){
            System.err.println("Помилка: " + e.getMessage());
            System.exit(0);
        }
        System.out.println(String.format("\ngiven element [%d][%d]  "+ element, rows_element, cols_element));

        return element;
    }


    @Override
    public int[] dimension(){
        int row = this.matrix.length;
        int column = this.matrix[0].length;
        System.out.println(String.format("dimension matrix[%d][%d]", row, column));
        int[] dimensions = {row, column};

        return dimensions;

    }





    double n1;
    @Override
    public boolean equal(double n2){   //два елементи
        if (this.n1 == n2) {
            return true;
        }else {
            return false;
        }
    }
    double[] n2;
    @Override
    public boolean equal(double[] n1) {   //два одновимірні масиви
        if (n1.length != this.n2.length) {  //якщо різної довжини
            return false;
        }

        for (int i = 0; i < n1.length; i++) {
            if (n1[i] != this.n2[i]) {
                return false; //якщо хоча б один елемент не однаковий
            }
        }
        return true;
    }

    @Override
    public String getClassIdentifier() {
        return classIdentifier;
    }
    @Override
    public boolean equal(MatrixInterface m2){   //матриці

        if (!this.classIdentifier.equals(m2.getClassIdentifier())) {
            return false; //матриці різних класів завжди нерівні
        }
        if (this.matrix.length != m2.GetRows()) {  //якщо різної довжини
            return false;
        }
        if (this.matrix[0].length != m2.GetCols()) {  //якщо різної довжини
            return false;
        }
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j=0; j<this.matrix[0].length; j++){
                if (this.matrix[i][j] != m2.GetMatrix()[i][j]) {
                    return false; //якщо хоча б один елемент не однаковий
                }
            }
        }
        return true;
    }




    public Matrix addMatrix(MatrixInterface matrix2) {
        int rows = this.matrix.length;
        int cols = this.matrix[0].length;

        //double[][] result = new double[rows][cols];
        Matrix result = new Matrix(rows, cols);
        try {

            //чи матриці мають однаковий розмір
            if (rows != matrix2.GetRows() || cols != matrix2.GetCols()) {
                throw new ExceptionE("додавання не можливе, невалідний розмір матриць");

            }

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    result.matrix[i][j] = this.matrix[i][j] + matrix2.GetMatrix()[i][j];
                }
            }
        }catch (ExceptionE e){
            System.err.println("Помилка: " + e.getMessage());
            System.exit(0);
        }

        return result;
    }

    public Matrix scalarM(double scalar){

        Matrix scalarMatrix;
        scalarMatrix = new Matrix(this.matrix.length, this.matrix[0].length);
        for (int i=0; i < this.matrix.length; i++)
        {
            for (int j =0; j<this.matrix[i].length; j++)
                scalarMatrix.matrix[i][j] = (double) (this.matrix[i][j]*scalar);
        }
        return scalarMatrix;
    }

    public Matrix multi(MatrixInterface matrix2){
        Matrix result = new Matrix(this.matrix.length, matrix2.GetCols());

        try {
            if (this.matrix[0].length != matrix2.GetRows()) {
                throw new ExceptionE("множення не можливе, невалідний розмір матриць");

            }

            System.out.println("\nmultiplication of two matrices:");
            for (int i = 0; i < this.matrix.length; i++) {
                for (int j = 0; j < matrix2.GetCols(); j++) {
                    result.matrix[i][j] = 0;

                    for (int k = 0; k < this.matrix[0].length; k++) {
                        result.matrix[i][j] += this.matrix[i][k] * matrix2.GetMatrix()[k][j];
                    }

                    System.out.print(result.matrix[i][j] + " ");
                }
                System.out.println();
            }
        }catch (ExceptionE e){
            System.err.println("Помилка: " + e.getMessage());
            System.exit(0);
        }
        return result;
    }



        public Matrix transpose(){
        Matrix transpose = new Matrix(this.matrix[0].length, this.matrix.length);
        for(int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                transpose.matrix[j][i] = this.matrix[i][j];
            }
        }
        return transpose;
    }


    public Matrix diagonalMatrix(ArrayList<Double> vector){
        int n = vector.size();
        Matrix diagonalM= new Matrix(n, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    diagonalM.matrix[i][j] = vector.get(i);
                } else {
                    diagonalM.matrix[i][j] = 0.0;
                }
            }
        }
        return diagonalM;
    }
    public Matrix unitM(int size)
    {
        Matrix unitM = new Matrix(0, 0);
        try {
            if (size <= 0) {
                throw new ExceptionE("невалідне значення");

            }

            unitM= new Matrix(size, size);
            for (int r = 0; r < size; r++) {
                for (int c = 0; c < size; c++) {
                    if (r == c)
                        unitM.matrix[r][c] = 1;
                    else
                        unitM.matrix[r][c] = 0;
                }
            }
        }catch (ExceptionE e){
            System.err.println("Помилка: " + e.getMessage());
            System.exit(0);
        }
        return unitM;
    }

    public Matrix matrixRow(ArrayList<Double> rowValue) {
        int n = rowValue.size();
        Matrix matrixRow = new Matrix(1, n);
        for (int j = 0; j < n; j++) {
            matrixRow.matrix[0][j] = rowValue.get(j);
        }
        return matrixRow;
    }

    public Matrix matrixCol(ArrayList<Double> colValue) {
        int n = colValue.size();
        Matrix matrixCol = new Matrix(n, 1);
        for (int j = 0; j < n; j++) {
            matrixCol.matrix[j][0] = colValue.get(j);
        }
        return matrixCol;
    }





    //обчислення детермінанта матриці
    public Matrix algebraicComplement() {
        int n = this.GetRows();
        Matrix adjugate = new Matrix(n, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Matrix minorMatrix = minor(this, i, j);  //мінорна матриця
                double minorDeterminant = determinantOfMatrix(minorMatrix);  //детермінан мінорної матриці
                double cofactor = Math.pow(-1, i + j) * minorDeterminant;  //алгебраїчне доповнення
                adjugate.GetMatrix()[i][j] = cofactor;
            }
        }

        return adjugate;
    }

    public double determinantOfMatrix(Matrix matrix) {
        int n = matrix.GetRows();
        double det = 0;
        try {
            if (matrix.GetRows()!=matrix.GetCols()) {
                throw new ExceptionE("не можливо знайти визначник. невалідний розмір матриці");

            }

            if (n == 1) {
                return matrix.GetMatrix()[0][0];
            } else if (n == 2) {
                return matrix.GetMatrix()[0][0] * matrix.GetMatrix()[1][1] - matrix.GetMatrix()[0][1] * matrix.GetMatrix()[1][0];
            } else {
                //double det = 0;
                for (int j = 0; j < n; j++) {
                    Matrix minorMatrix = minor(matrix, 0, j);
                    double minorDeterminant = determinantOfMatrix(minorMatrix);
                    det += matrix.GetMatrix()[0][j] * Math.pow(-1, j) * minorDeterminant;
                }
            }
        }catch (ExceptionE e){
            System.err.println("Помилка: " + e.getMessage());
            System.exit(0);
        }
            return det;

    }

    public static Matrix minor(Matrix matrix, int rowToRemove, int colToRemove) {
        int n = matrix.GetRows() - 1;
        Matrix minor = new Matrix(n, n);
        int minorRow = 0, minorCol;

        for (int i = 0; i < matrix.GetRows(); i++) {
            if (i == rowToRemove) continue;
            minorCol = 0;

            for (int j = 0; j < matrix.GetCols(); j++) {
                if (j == colToRemove) continue;
                minor.GetMatrix()[minorRow][minorCol] = matrix.GetMatrix()[i][j];
                minorCol++;
            }

            minorRow++;
        }

        return minor;
    }

    public Matrix reversed() {
        double determinant = this.determinantOfMatrix(this);
        Matrix matrix_2 = this.algebraicComplement();
        matrix_2 = matrix_2.transpose();
        matrix_2 = matrix_2.scalarM(1 / determinant);
        return matrix_2;
    }

}



