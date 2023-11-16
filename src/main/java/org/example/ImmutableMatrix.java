package org.example;
import java.util.ArrayList;

public final class ImmutableMatrix implements MatrixInterface {
    private final double[][] matrix;
    private final int rows;
    private final int cols;
    private final String classIdentifier = "ImmutableMatrix";
    public double[][] GetMatrix() {
            return matrix;
        }
        public int GetRows() {
            return rows;
        }
        public int GetCols() {
            return cols;
        }

        //конструктор для порожньої матриці
        public ImmutableMatrix() {
            this.rows = 0;  //посилаємося на поле об'єкта, а не на параметр методу
            this.cols = 0;
            matrix = new double[0][0];
        }
        //конструктор для створення матриці заданого розміру
        public ImmutableMatrix(int rows, int cols) {
            this.rows = rows;
            this.cols = cols;
            matrix = new double[rows][cols];
        }

        //конструктор для створення копії іншої матриці
        public ImmutableMatrix(MatrixInterface m)
        {
            int r,c;
            r=m.GetRows();
            c=m.GetCols();
            this.rows = r;
            this.cols = c;
            matrix = new double [r][c];
            for(int i=0;i<r;i++)
            {
                for(int j=0;j<c;j++)
                {
                    matrix[i][j]=m.GetMatrix()[i][j];
                }
            }
        }
        public void print2D() {
            for (int i = 0; i < this.matrix.length; i++) {
                for (int j = 0; j < this.matrix[i].length; j++) {
                    System.out.print(this.matrix[i][j] + " ");
                }
                System.out.println();
            }
        }

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


        public int[] dimension(){
            int row = this.matrix.length;
            int column = this.matrix[0].length;
            System.out.println(String.format("dimension matrix[%d][%d]", row, column));
            int[] dimensions = {row, column};

            return dimensions;

        }




        double n1;
        public boolean equal(double n2){   //два елементи
            if (this.n1 == n2) {
                return true;
            }else {
                return false;
            }
        }
        double[] n2;
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


}
