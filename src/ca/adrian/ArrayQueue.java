package ca.adrian;

import java.util.Arrays;

public class ArrayQueue {
    private int[] items;
    private int count;
    private int front;
    private int back;

    public ArrayQueue(int capacity){
        this.items = new int[capacity];
    }

    // enqueue -> adding an item to the back of the queue
    // [10, 20, 30]
    //  F
    public void enqueue(int item){
        if (items.length == count)
            throw new IllegalStateException("Queue is full");

        items[count++] = item;
        back = count;
    }

    // dequeue -> removes an item from the front
    public void dequeue(){
        if (isEmpty())
            throw new IllegalStateException("Queue has no items");
        front = ++front;
    }

    // peek -> returns the value from the front of the queue but does not remove it
    public int peek(){
        if (isEmpty())
            throw new IllegalStateException("Queue has no items");
        return items[front];
    }

    // isEmpty
    public boolean isEmpty(){
        return count == 0;
    }

    // isFull
    public boolean isFull(){
        return items.length == count;
    }

    @Override
    public String toString() {
        if (count == 0)
            return "[]";
        var data = Arrays.copyOfRange(items, front, back);
        return Arrays.toString(data);
    }
}
