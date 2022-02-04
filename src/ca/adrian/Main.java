package ca.adrian;

import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
       var arrayQueue = new ArrayQueue(5);

       arrayQueue.enqueue(10);
       arrayQueue.enqueue(20);
       arrayQueue.enqueue(30);
       arrayQueue.enqueue(40);

        System.out.println(arrayQueue.isEmpty());
        System.out.println(arrayQueue.isFull());


       System.out.println(arrayQueue);

    }

    public static void reverse(Queue<Integer> queue){
        Stack<Integer> stack = new Stack<>();

        while (!queue.isEmpty())
            stack.push(queue.remove());

        while (!stack.isEmpty())
            queue.add(stack.pop());
    }

    public static String stringReverser(String str){
        if (str == null)
            throw new IllegalArgumentException("Value cannot be null");

        Stack<Character> stack = new Stack<>();

        for (char ch: str.toCharArray())
            stack.push(ch);

        StringBuffer buffer = new StringBuffer();

        while (!stack.isEmpty())
            buffer.append(stack.pop());

        return buffer.toString();
    }

    public static void reverseArray(int[] array){
        if (array == null)
            throw new IllegalArgumentException("Array cannot be null");

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < array.length; i++){
            stack.push(array[i]);
        }

        for (int j = 0; j < array.length; j++){
            array[j] = stack.pop();
        }

    }
}


