package ca.adrian;

import ca.adrian.arrays.Array;
import ca.adrian.linkedList.LinkedList;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        var list = new LinkedList();
//        list.addFirst(1);
//        list.addLast(2);
//        list.addLast(3);
//        list.addLast(4);
        list.printMiddle();



    }

    public void logO1(int[] numbers){
        // O(1)
        // it runs at constant time
        System.out.println(numbers[0]);
    }

    public void voidLogOn(int[] numbers, String[] strings){
        // O(n) -> n = size of the input

        // it grows linearly and in direct proportion to the size of the input
        System.out.println(); // O(1);

        for (int i = 0; i < numbers.length; i++){
            System.out.println(numbers[i]);
        } // O(n)

        for (int i = 0; i < strings.length; i++){
            System.out.println(numbers[i]);
        } // O(m)

        System.out.println(); // O(1);
    }

    public void logOn2(int[] numbers){
        // O(n * n) -> O(n^2)
        // O(n + n^2) -> -> O(n^2)

        for ( int number: numbers) // O(n)
            System.out.println(number);

        // O(n^3)
        for (int first: numbers){ // O(n)
            for (int second: numbers) // O(n)
                System.out.println(first + ", " + second);
            for (int second: numbers) // O(n)
                System.out.println(first + ", " + second);

        }

    }
}


