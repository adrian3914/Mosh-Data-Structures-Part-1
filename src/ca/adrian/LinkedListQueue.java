/*
    Build a queue using a linked list from scratch. Implement the following operations and calculate their runtime complexities.
    Developed By: Adrian Paz Alons
    Script Date: 06-Feb-2022

*/

package ca.adrian;

import java.util.LinkedList;

public class LinkedListQueue {
    private LinkedList<Integer> linkedList = new LinkedList<>();

    // enqueue -> O(1)
    public void enqueue(int item){
        linkedList.addLast(item);
    }

    //dequeue O(1)
    public void dequeue(){
        if (isEmpty())
            throw new IllegalStateException("Queue is empty");

        linkedList.removeFirst();
    }

    //peek O(1)
    public int peek(){
        if (isEmpty())
            throw new IllegalStateException("Queue is empty");

        return linkedList.getFirst();
    }

    // size O(1)
    public int size(){
        return linkedList.size();
    }

    // isEmpty O(1)
    public boolean isEmpty(){
        return linkedList.isEmpty();
    }

    @Override
    public String toString() {
        return ""+linkedList;
    }
}
