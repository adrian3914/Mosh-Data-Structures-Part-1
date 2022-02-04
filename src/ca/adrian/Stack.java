package ca.adrian;

import java.util.Arrays;

public class Stack {
    private int[] items = new int[5];
    private int count;

    // Push
    public int push(int item){
        if (items.length == count){
            // increase array size
            int[] newArray = new int[count * 2];

            // copy all elements from one array to the next
            for (int i = 0; i < count; i++){
                newArray[i] = items[i];
            }

            items = newArray;
            items[count++] = item;
        }else {
            items[count++] = item;
        }

        return item;
    }

    // pop -> removes the element from the top of the stack last-in and returns it
    public int pop(){
        if (isEmpty())
            throw new IllegalStateException("Stack is empty");

        var top = items[count - 1];
        items[--count] = 0;
        return top;
    }

    // peek =- returns the element from the top of the stack but does not remove it
    public int peek(){
        if (isEmpty())
            throw new IllegalStateException("Stack is empty");

        return items[count - 1];
    }

    // isEmpty
    public boolean isEmpty(){
        return count == 0;
    }

    public String toString(){
        var content = Arrays.copyOfRange(items, 0, count);
        return Arrays.toString(content);
    }

    public int getCount() {
        return count;
    }
}
