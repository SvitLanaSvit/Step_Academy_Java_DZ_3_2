package org.example;

import java.util.Random;
import java.util.Scanner;

public class Matrix <T extends  Comparable<T>>{
    private Object[][] elements;
    private int columns;
    private int rows;

    public Matrix(int rows, int columns){
        this.columns = columns;
        this.rows = rows;
        elements = new Object[rows][columns];
    }

    public void fillFromArrayInput(){
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++){
                System.out.print("Enter element at index [" + i + "][" + j + "]: ");
                elements[i][j] = scanner.next();
            }
        }
    }

    public void fillWithRandomNumbers(T max, T min){
        Random random = new Random();
        if(max instanceof Integer && min instanceof Integer){
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    elements[i][j] = random.nextInt((Integer)max - (Integer)min + 1) +(Integer) min;
                }
            }
        }
        else if(max instanceof Double && min instanceof Double){
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    elements[i][j] = random.nextDouble((Double)max - (Double)min + 1) +(Double) min;
                }
            }
        }
        else if(max instanceof Float && min instanceof Float){
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    elements[i][j] = random.nextFloat((Float)max - (Float)min + 1) +(Float) min;
                }
            }
        }
    }

    public void printMatrix(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(elements[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public T findMax(){
        T max = (T) elements[0][0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(((T)elements[i][j]).compareTo(max) > 0){
                    max = (T) elements[i][j];
                }
            }
        }

        return max;
    }

    public T findMin(){
        T min = (T) elements[0][0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(((T)elements[i][j]).compareTo(min) < 0){
                    min = (T) elements[i][j];
                }
            }
        }

        return min;
    }

    public Matrix<T> add(Matrix<T> other){
        if(other.rows != this.rows || other.columns != this.columns){
            throw new IllegalArgumentException("Matrices must have the same dimensions for addition.");
        }

        Matrix<T> result = new Matrix<>(rows, columns);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.elements[i][j] = addElements((T)this.elements[i][j], (T)other.elements[i][j]);
            }
        }

        return result;
    }

    public Matrix<T> subtract(Matrix<T> other){
        if(other.rows != this.rows || other.columns != this.columns){
            throw new IllegalArgumentException("Matrices must have the same dimensions for addition.");
        }

        Matrix<T> result = new Matrix<>(rows, columns);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.elements[i][j] = subtractElements((T)this.elements[i][j], (T)other.elements[i][j]);
            }
        }

        return result;
    }

    public Matrix<T> multiply(Matrix<T> other){
        if (this.columns != other.rows) {
            throw new IllegalArgumentException("Number of columns in the first matrix must be equal to the number of rows in the second matrix for multiplication.");
        }

        Matrix<T> result = new Matrix<>(rows, other.columns);

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.columns; j++) {
                result.elements[i][j] = multiplyElements(i, j, other);
            }
        }

        return result;
    }

    private T addElements(T a, T b) {
        if (b instanceof Integer) {
            return (T) Integer.valueOf(((Integer) a) + ((Integer) b));
        } else if (b instanceof Double) {
            return (T) Double.valueOf(((Double) a) + ((Double) b));
        }else if (b instanceof Float) {
            return (T) Float.valueOf(((Float) a) + ((Float) b));
        } else {
            throw new IllegalArgumentException("Unsupported numeric type");
        }
    }

    private T subtractElements(T a, T b) {
        if (b instanceof Integer) {
            return (T) Integer.valueOf(((Integer) a) - ((Integer) b));
        } else if (b instanceof Double) {
            return (T) Double.valueOf(((Double) a) - ((Double) b));
        }else if (b instanceof Float) {
            return (T) Float.valueOf(((Float) a) - ((Float) b));
        } else {
            throw new IllegalArgumentException("Unsupported numeric type");
        }
    }

    private T multiplyElements(int rows, int columns, Matrix<T> other){
        T sum = null;

        for (int k = 0; k < this.columns; k++) {
            T elementA = (T) elements[rows][k];
            T elementB = (T) other.elements[k][columns];

            if (sum == null) {
                sum = multiplyElements(elementA, elementB);
            } else {
                sum = addElements(sum, multiplyElements(elementA, elementB));
            }
        }

        return sum;
    }

    private T multiplyElements(T a, T b) {
        if (b instanceof Integer) {
            return (T) Integer.valueOf(((Integer) a) * ((Integer) b));
        } else if (b instanceof Double) {
            return (T) Double.valueOf(((Double) a) * ((Double) b));
        } else if (b instanceof Float) {
            return (T) Float.valueOf(((Float) a) * ((Float) b));
        } else {
            throw new IllegalArgumentException("Unsupported numeric type");
        }
    }
}