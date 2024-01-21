package main.problem_232_Queue_Stacks;

public class Test {

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);

        int param_3 = obj.peek();
        int param_2 = obj.pop();
        boolean param_4 = obj.empty();
    }
}
