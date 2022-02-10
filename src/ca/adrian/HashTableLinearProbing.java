/*
    4- Build a hash table from scratch.
    Use linear probing strategy for handling collisions.
    Implement the following operations:
    -put(int, String)
    -get(int)
    -remove(int)
    -size()
 */
package ca.adrian;

import java.util.Arrays;

public class HashTableLinearProbing {
    private class Entry{
        private int key;
        private String value;

        public Entry(int key, String value) {
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

        @Override
        public String toString() {
            return "{" +
                    "key=" + key +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

    private Entry[] entries;
    private int count;

    public HashTableLinearProbing(int capacity){
        this.entries = new Entry[capacity];
    }

    public void put(int key, String value){
        int index = getHash(key);
        int last = -1;

        while (true){
            if (isSlotFull())
                throw new IllegalStateException("Hash Table is full");

            if (entries[index] != null){

                if(entries[index].key == key){
                    entries[index].value = value;
                    break;
                }

                last = index + 1 ;
                index = (index + 1) % entries.length;
                continue;
            }

            entries[index] = new Entry(key, value);
            count++;
            break;
        }
    }

    public String get(int key){

        for (var entry: entries){

            if (entry !=null){
                if (entry.key == key)
                    return entry.value;
            }
        }
        return null;
    }

    public void remove(int key){
        // [1:A, 3:B, 7:U]
        if (isSlotFull()){
            for(int i = 0; i < entries.length; i++){
                if (entries[i].key == key){
                    entries[i] = null;
                    count--;
                    return;
                }
            }
        }
    }

    public int size(){
        return count;
    }

    public void print(){
        System.out.println(Arrays.toString(entries));
    }

    private boolean isSlotFull() {
        for(var entry: entries)
             if (entry == null)
                 return false;

        return true;
    }

    private int getHash(int key) {
        return key % entries.length;
    }

}
