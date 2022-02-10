package ca.adrian;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
       HashTableLinearProbing map = new HashTableLinearProbing(4);
       map.put(1,"A");
       map.put(1,"B");
       map.put(1,"B");
       map.put(1,"B");

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


