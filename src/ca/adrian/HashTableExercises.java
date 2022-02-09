/*
    1- Find the most repeated element in an array of integers.
    What is the time complexity of this method? (A variation of this exercise is finding the most repeated word in a sentence.
    The algorithm is the same. Here we use an array of numbers for simplicity.)
    Input: [1, 2, 2, 3, 3, 3, 4]
    Output: 3

    Developed by: Adrian Paz Alonso
    Script date: 09-Feb-2022

 */
package ca.adrian;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashTableExercises {

    public static int mostFrequentAdrian(int[] array){
        if (array == null)
            throw new IllegalStateException("Array cannot be null.");
        // [1, 2, 2, 3, 3, 3, 4]
        //  ^
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer>  set = new HashSet<>();

        for (int i = 0; i < array.length; i++){
            var count = map.containsKey(array[i]) ? map.get(array[i]): 0;
            map.put(array[i], count + 1 );
            set.add(array[i]);
        }

        var numbers = set.toArray(new Integer[0]);
        int max = numbers[0];
        int maxIndex = 0;

        for (int j = 1; j < numbers.length; j++){
            if (max < map.get(numbers[j])){
                max = map.get(numbers[j]);
                maxIndex = j;
            }
        }

        return numbers[maxIndex];
    }

    // O(n)
    public static int mostFrequent(int[] numbers) {
        // To find the most frequent item in an array, we have to count the
        // number of times each item has been repeated. We can use a hash
        // table to store the items and their frequencies.

        if (numbers == null)
            throw new IllegalStateException("Array cannot be null.");

        Map<Integer, Integer> map = new HashMap<>();
        for (var number : numbers) {
            var count = map.getOrDefault(number, 0);
            map.put(number, count + 1);
        }

        // Once we've populated our hash table, we need to iterate over all
        // key/value pairs and find the one with the highest frequency.
        int max = -1;
        int result = numbers[0];
        for (var item : map.entrySet()) {
            if (item.getValue() > max) {
                max = item.getValue();
                result = item.getKey();
            }
        }

        // Runtime complexity of this method is O(n) because we have to
        // iterate the entire array to populate our hash table.

        return result;
    }
}
