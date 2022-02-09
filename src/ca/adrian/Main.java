package ca.adrian;

import java.util.*;
import java.util.LinkedList;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        HashTable table = new HashTable(5);
        table.put(6, "A");
        table.put(8, "B");
        table.put(11, "C");
        table.put(6, "A+");
        //table.remove(6);
        System.out.println(table.get(10));
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


