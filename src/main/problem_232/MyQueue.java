package main.problem_232;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyQueue {
    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public MyQueue() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    void push(Deque<Integer> topRef, int newData) {
        // Push the data onto the stack
        topRef.push(newData);
    }

    /* Function to pop an item from stack*/
    int pop(Deque<Integer> topRef) {
        /*If stack is empty then error */
        if (topRef.isEmpty()) {
            return -1;
        }

        // pop the data from the stack
        return topRef.pop();
    }

    static int peek(Deque<Integer> topRef) {
        if (topRef.isEmpty()) {
            return -1;
        }

        // pop the data from the stack
        return topRef.peek();
    }

    public void push(int x) {
        push(stack1, x);
    }

    public int pop() {
        if (checkIfNotEmptyAndMove()) return -1;
        return pop(stack2);
    }

    public int peek() {
        if (checkIfNotEmptyAndMove()) return -1;
        return peek(stack2);
    }

    private boolean checkIfNotEmptyAndMove() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return true;
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                int y;
                y = pop(stack1);
                push(stack2, y);
            }
        }
        return false;
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
