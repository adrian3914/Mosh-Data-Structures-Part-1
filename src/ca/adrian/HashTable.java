/*
    Implement a hashTable using a linkedList
        - put(k, v)
        - get(k): v
        - remove(k)
        - k: int
        - v: String
        - Collisions: Chaining
        - LinkedList[]
        - [LL, LL, LL, LL]
     Developed by: Adrian Paz Alonso
     Script date: 08-Feb-2022

 */

package ca.adrian;

import java.util.LinkedList;

public class HashTable{
    private LinkedList<Entry>[] array;

    public HashTable(int capacity) {
        this.array = new LinkedList[capacity];
    }

    private class Entry{
        private int key;
        private String value;

        public Entry(int key, String value){
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public void put(int key, String value){
        // [LL, LL, LL, LL]
        // [LL {E -> E -> E}, ...]
        var newEntry = new Entry(key, value);
        var i = hash(key);

        if (isSlotEmpty(i)){
            LinkedList<Entry> linkedList = new LinkedList<>();
            linkedList.addFirst(newEntry);
            array[i] = linkedList;
            return;
        }

        array[i].addLast(newEntry);
    }

    public String get(int key){
        int i = hash(key);
        var list = array[i];
        var buffer = new StringBuffer();
        var next = list.getFirst();

        for (int j = 0; j < list.size(); j++){
            if (list.get(j).key == key)
                buffer.append(list.get(i).value);
        }

        return buffer.toString();
    }

    public void remove(int k){
        // [ll, ll, ll]
        //  ^
        // [{E, E, E}, {E, E, E}, {E, E}]
        int i = hash(k);
        var list = array[i];
        if (list == null)
            return;
        array[i] = null;
    }

    private boolean isSlotEmpty(int i){
        return array[i] == null;
    }


    private int hash(int key){
        return key % array.length;
    }

    public void print(){
        // [ll, ll, ll]
        //  ^
        // [[{}, {}, {}], ]
        int i = 0;
        System.out.print('[');
        for (i = 0; i < array.length; i++){
            var list = array[i];

            if (list == null)
                continue;;

            for (int j = 0; j < list.size(); j++){
                System.out.print(array[i].get(j).value + " ");
            }
        }
        System.out.print(']');
    }
}
