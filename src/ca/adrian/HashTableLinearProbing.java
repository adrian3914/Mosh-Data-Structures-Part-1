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
    }

    private Entry[] entries;

    public HashTableLinearProbing(int capacity){
        this.entries = new Entry[capacity];
    }

    public void put(int key, String value){
        int index = getHash(key);
        int last = -1;

        while (true){
            if (isFull())
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

    private boolean isFull() {
        for(var entry: entries)
             if (entry == null)
                 return false;

        return true;
    }

    private int getHash(int key) {
        return key % entries.length;
    }

}
