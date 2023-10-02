package org.example;

public class Main {
    public static void main(String[] args) {
        //Завдання 1:
        //Створіть шаблонний клас Array, що являє собою масив, що дає можливість зберігати об’єкти
        //заданого типу. Необхідно реалізувати:
        // заповнення масиву з клавіатури
        // заповнення масиву випадковими числами
        // вивід масиву
        // пошук максимального значення
        // пошук мінімального значення
        // підрахунок середньо арифметичного значення
        // сортування масиву по зростанню
        // сортування масиву по спаданню
        // пошук значень в масиві, використовуючи бінарний пошук
        // заміна значення в масиві на нове значення
        Array<Float> array = new Array<>(5);
        array.fillWithRandomNumbers(100.0f, 1.0f);
        array.printArray();
        array.fillFromArrayInput();
        array.printArray();
        System.out.println("Max: " + array.findMax());
        System.out.println("Min: " + array.findMin());
        System.out.println("Avg: " + array.calculateAverage());
        array.sortDescending();
        array.printArray();
        array.sortAscending();
        array.printArray();
        System.out.println("Index by search: " + array.binarySearch(5.5f));
        array.replaceValue(5, 9);
        array.printArray();

        //Завдання 2:
        //Створити шаблонний клас Матриця. Необхідно реалізувати:
        // заповнення матриці з клавіатури
        // заповнення випадковими значеннями
        // відображення матриці
        // арифметичні операції +, –, *, / по правилах роботи з матрицями
        // пошук максимального і мінімального елемента
        // підрахунок середньоарифметичного значення
        Matrix<Integer> matrix = new Matrix<>(2, 3);
        matrix.fillWithRandomNumbers(9, 1);
        Matrix<Integer> other = new Matrix<>(2,3);
        other.fillWithRandomNumbers(9, 1);
        matrix.printMatrix();
        System.out.println("Matrix for sum and subtract:");
        other.printMatrix();

        System.out.println("Max: " + matrix.findMax());
        System.out.println("Min: " + matrix.findMin());

        System.out.println("Matrix for multiply:");
        Matrix<Integer> otherMultiply = new Matrix<>(3,2);
        otherMultiply.fillWithRandomNumbers(9,1);
        otherMultiply.printMatrix();

        System.out.println("Result sum:");
        var sumResult = matrix.add(other);
        sumResult.printMatrix();

        System.out.println("Result subtract:");
        var subtractResult = matrix.subtract(other);
        subtractResult.printMatrix();

        System.out.println("Result multiply:");
        var multiply = matrix.multiply(otherMultiply);
        multiply.printMatrix();
    }
}