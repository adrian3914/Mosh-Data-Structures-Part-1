package ca.adrian;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class QueueReverser {
    public static void reverser(Queue<Integer> queue, int k){
        Stack<Integer> stack = new Stack<>();
        boolean isKFound = false;

        while (!isKFound){
            var item = queue.remove();
            stack.push(item);
            if (item == k)
                break;
        }

        Queue<Integer> queue1 = new ArrayDeque<>();

        while (!stack.isEmpty())
            queue1.add(stack.pop());

        while (!queue.isEmpty())
            queue1.add(queue.remove());

        while (!queue1.isEmpty())
            queue.add(queue1.remove());

    }
}

        /*
            ALGORITHM
            Input:  Q = [10, 20, 30, 40, 50], K = 3O
            Output: Q = [30, 20, 10, 40, 50]
            Q1 [40, 50]
            S [10, 20 , 30]
            Q2 [30, 20, 10, 40, 50]

         */
