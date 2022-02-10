package ca.adrian;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
       int[] numbers = {1, 7, 5, 9, 2, 12, 3};
       var result = HashTableExercises.twoSum(numbers, 11);

        System.out.println(Arrays.toString(result));
    }

    public static int hash(int number){
        return number % 10;
    }

    public static int hash(String number){
        int hash = 0;

        for (var ch: number.toCharArray())
            hash += ch;

        return hash % 100;
    }
}


