package ca.adrian;

import java.util.*;
import java.util.LinkedList;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
//        // HashMap Function
//        Map<String, String> map = new HashMap<>();
//        map.put("123456-A", "Adrian");
//        System.out.println(hash(123456));
//        System.out.println(hash("123456-A"));
        HashTable map = new HashTable(5);


        map.put(23, "Adrian");
        map.put(23, "Jose");
        map.put(23, "Cassandra");


        map.remove(23);
        map.print();


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


