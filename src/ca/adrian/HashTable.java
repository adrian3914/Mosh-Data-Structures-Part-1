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
    private LinkedList<Entry>[] entries;

    public HashTable(int capacity) {
        this.entries = new LinkedList[capacity];
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
        var index = hash(key);

        if (isSlotEmpty(index))
            entries[index] = new LinkedList<>();

        var bucket = entries[index];

        for(var entry: bucket){
            if (entry.key == key){
                entry.value = value;
                return;
            }
        }
        bucket.addLast(new Entry(key, value));
    }

    public String get(int key){
        int i = hash(key);
        var list = entries[i];
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
        var list = entries[i];
        if (list == null)
            return;
        entries[i] = null;
    }

    private boolean isSlotEmpty(int i){
        return entries[i] == null;
    }


    private int hash(int key){
        return key % entries.length;
    }

    public void print(){
        // [ll, ll, ll]
        //  ^
        // [[{}, {}, {}], ]
        int i = 0;
        System.out.print('[');
        for (i = 0; i < entries.length; i++){
            var list = entries[i];

            if (list == null)
                continue;;

            for (int j = 0; j < list.size(); j++){
                System.out.print(entries[i].get(j).value + " ");
            }
        }
        System.out.print(']');
    }
}
