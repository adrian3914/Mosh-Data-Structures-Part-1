package ca.adrian;

import java.util.*;
import java.util.LinkedList;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
       int[] numbers = {1, 2,2, 3, 3, 3, 4, 5, 5, 5, 5};
       var result = HashTableExercises.mostFrequent(null);
        System.out.println(result);
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


