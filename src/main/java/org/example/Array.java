package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Array <T extends Comparable<T>>{
    private Object[] elements;

    public Array(int size){
        elements = new Object[size];
    }

    public void fillFromArrayInput(){
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < elements.length; i++) {
            System.out.print("Enter element at index " + i + ": ");
            elements[i] = scanner.next();
        }
    }

    public void fillWithRandomNumbers(T max, T min){
        Random random = new Random();
        if(max instanceof Integer && min instanceof Integer){
            for (int i = 0; i < elements.length; i++) {
                elements[i] = random.nextInt((Integer) max - (Integer) min + 1) + (Integer) min;
            }
        }
        else if(max instanceof Double && min instanceof Double){
            for (int i = 0; i < elements.length; i++) {
                elements[i] = random.nextDouble((Double) max - (Double) min + 1) + (Double) min;
            }
        }
        else if(max instanceof Float && min instanceof Float){
            for (int i = 0; i < elements.length; i++) {
                elements[i] = random.nextFloat((Float) max - (Float) min + 1) + (Float) min;
            }
        }
    }

    public void printArray(){
        System.out.println(Arrays.toString(elements));;
    }

    public T findMax(){
        T max = (T) elements[0];
        for (Object elem : elements) {
           if(((T)elem).compareTo(max) > 0){
               max = (T) elem;
           }
        }

        return max;
    }

    public T findMin(){
        T min = (T) elements[0];
        for (Object elem : elements) {
            if(((T)elem).compareTo(min) < 0){
                min = (T) elem;
            }
        }

        return min;
    }

    public double calculateAverage(){
        double sum = 0.0;
        for (Object elem: elements) {
            sum += Double.parseDouble(elem.toString());
        }
        return sum / elements.length;
    }

    public void sortAscending(){
        Arrays.sort(elements);
    }

    public void sortDescending(){
        Arrays.sort(elements, (a, b) -> ((T)b).compareTo((T)a));
    }

    public int binarySearch(T value) {
        int left = 0;
        int right = elements.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            T midValue = (T) elements[mid];
            int comparison = (midValue.toString()).compareTo(value.toString());

            if (comparison == 0) {
                return mid;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public void replaceValue(Object oldValue, Object newValue) {
        for (int i = 0; i < elements.length; i++) {
            if (String.valueOf(oldValue).equals(elements[i])) {
                elements[i] = newValue;
            }
        }
    }
}
