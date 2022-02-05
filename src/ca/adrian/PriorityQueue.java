package ca.adrian;

import java.util.Arrays;

public class PriorityQueue {
    private int[] items;
    private int count;

    public PriorityQueue(int capacity){
        this.items = new int[capacity];
    }

    // Add
    // [1]
    public boolean add(int item){
        if (isFull())
            throw new IllegalStateException("Priority Queue is full");

        if (isEmpty()){
            items[count++] = item;
            return true;
        }

        // compare from end to beginning
        // item = 3
        // [1, 2, 3, 4, 5]
        for(int i = (count - 1); i >= 0 ; i--){
            if (items[i] > item){
                items[i+1] = items[i];

                if (i == 0)
                   items[i] = item;

                continue;
            }
            else
                items[i + 1] = item;
                break;
        }
        count++;
        return true;

    }

    // Remove
    // [3, 4, 5, 6, 6]
    public boolean remove(){
        if (isEmpty())
            throw new IllegalArgumentException("No items in the queue");

        for (int i = 0; i < count; i++){

            if (i == (items.length -1)){
                items[i] = 0;
                break;
            }

            items[i] = items[i + 1];
        }
        count--;
        return true;
    }

    private boolean isFull() {
        return count == items.length;
    }

    private boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString(){
        var data = Arrays.copyOfRange(items, 0, count);
        return Arrays.toString(data);
    }
}
