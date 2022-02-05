package ca.adrian;

import java.util.Arrays;

public class ArrayQueue {
    private int[] items;
    private int front;
    private int rear;
    private int count;

    public ArrayQueue(int capacity){
        this.items = new int[capacity];
    }

    // enqueue -> adding an item to the back of the queue
    // [10, 20, 30]
    //  F
    public void enqueue(int item){
        if (count == items.length )
            throw new IllegalStateException("Queue is full");

        items[rear] = item;
        rear = (rear + 1) % items.length; // using circular array
        count++;
    }

    // dequeue -> removes an item from the front
    public int dequeue(){
        if (isEmpty())
            throw new IllegalStateException("Queue has no items");

        var item = items[front];
        items[front] = 0;
        front = (front + 1) % items.length; // using circular array
        count--;
        return item;
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
        return Arrays.toString(items);
    }
}
