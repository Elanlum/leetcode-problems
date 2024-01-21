package main.problem_232;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/implement-queue-using-stacks/
public class MyQueue {
    Deque<Integer> inputStack;
    Deque<Integer> outputStack;

    public MyQueue() {
        inputStack = new ArrayDeque<>();
        outputStack = new ArrayDeque<>();
    }

    public void push(int x) {
        inputStack.push(x);
    }

    public int pop() {
        rearrange();
        return outputStack.isEmpty() ? -1 : outputStack.pop();
    }

    public int peek() {
        rearrange();
        return outputStack.isEmpty()? -1 : outputStack.peek();
    }

    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    private void rearrange() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
    }
}
