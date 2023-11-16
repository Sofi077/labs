package org.example;
import java.util.ArrayList;
// приймає параметр типу T
// клас буде обробляти абстрактний тип T, який може бути будь-яким класом або інтерфейсом
public class GenericMatrix<T> implements GenericMatrixInterface<T> {

    private int rows;
    private int columns;
    private T data[][];

    public GenericMatrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        //this.data = (T[][]) Array.newInstance(Object.class, rows, columns);
        //щоб приховати попередження компілятора щодо небезпечного використання неконтрольованого (unchecked) перетворення типів
        @SuppressWarnings("unchecked") T[][] array = (T[][]) new Object[rows][columns];
        data = array;
    }

    @Override
    public int getRows() {
        return rows;
    }

    @Override
    public int getColumns() {
        return columns;
    }

    @Override
    public T getElement(int row, int column) {
        return (T) data[row][column];
    }

    @Override
    public void setElement(int row, int column, T value) {
        data[row][column] = value;   //це щоб змінити певне значення
    }

    @Override
    public GenericMatrix<T> add(GenericMatrix<T> other) {
        GenericMatrix<T> result = new GenericMatrix<>(rows, columns);
        try {
            if ((this.getRows() != other.getRows()) || (this.getColumns() != other.getColumns())) {
                throw new ExceptionE("додавання не можливе. розміри матриць невалідні");
            }

            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < columns; c++) {
                    result.setElement(r, c, add(this.getElement(r, c), other.getElement(r, c)));
                }
            }
        }catch (ExceptionE e){
            System.err.println("Помилка: " + e.getMessage());
            System.exit(0);
        }
        return result;
    }

    private T add(T a, T b) {
        if (a instanceof Number && b instanceof Number) {
            //щоб додати числа
            return (T) Double.valueOf(((Number) a).doubleValue() + ((Number) b).doubleValue());
        } else {
            // щоб додтаи букви
            return (T) (a.toString() + b.toString());
        }

        //return (T) (a.toString() + b.toString());

    }

    public void matrixFilling(ArrayList<T> values) {
        int valueIndex = 0;

        try {
            if (this.data.length * this.data[0].length != values.size()) {
                throw new ExceptionE("Кількість значень не відповідає розмірності матриці, яка заповнюється");
            }
            for (int r = 0; r < this.data.length; r++) {
                for (int c = 0; c < this.data[r].length; c++) {
                    this.data[r][c] = values.get(valueIndex);
                    valueIndex++;
                }
            }
        } catch (ExceptionE e) {
            System.err.println("Помилка: " + e.getMessage());
            System.exit(0);
        }
    }


    public void print2D() {
        for (int i = 0; i < this.data.length; i++) {
            for (int j = 0; j < this.data[i].length; j++) {
                System.out.print(this.data[i][j] + " ");
            }
            System.out.println();
        }
    }
    public GenericMatrix<T> transpose() {
        int rows = this.data.length;
        int columns = this.data[0].length;

        GenericMatrix<T> transpose = new GenericMatrix<>(columns, rows);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transpose.data[j][i] = this.data[i][j];
            }
        }

        return transpose;
    }

}

