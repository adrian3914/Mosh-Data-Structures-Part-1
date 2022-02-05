package ca.adrian;

import java.util.Arrays;

public class PriorityQueue {
    private int[] items;
    private int count;

    public PriorityQueue(int capacity){
        this.items = new int[capacity];
    }

    public void add(int item){
        if (isFull())
            throw new IllegalStateException("Priority Queue is full");

        var i = shiftItemsToInsert(item);
        items[i] = item;
        count++;

    }

    public int remove(){
        if (isEmpty())
            throw new IllegalStateException("No items in the queue");

        return items[--count];
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

    private int shiftItemsToInsert(int item) {
        int i;
        for (i = count - 1; i >= 0; i--){
            if (items[i] > item)
                items[i + 1] = items[i];
            else break;
        }
        return i + 1;
    }
}
