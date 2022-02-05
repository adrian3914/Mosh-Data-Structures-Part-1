package ca.adrian;

import java.util.Stack;

public class QueueWithTwoStacks {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int item){
        stack1.push(item);
    }

    public int dequeue(){
       if (isEmpty())
           throw new IllegalStateException();

        moveStack1ToStack2();

        return stack2.pop();
    }

    public int peek(){
       if (isEmpty())
           throw new IllegalStateException();

        moveStack1ToStack2();

        return stack2.peek();
    }

    public boolean isEmpty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }

    private void moveStack1ToStack2() {
        if (stack2.isEmpty())
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
    }

}

/*
         ALGORITHM
         Q  [40, 50]
         S1 [40, 50] // enqueue
         S2 []       // dequeue, whenever the S2 is empty we should pass all items from S1 -> S2
 */