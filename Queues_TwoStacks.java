/*
In this challenge, you must first implement a queue using two stacks. Then process  queries, where each query is one of the following  types:

1 x: Enqueue element  into the end of the queue.
2: Dequeue the element at the front of the queue.
3: Print the element at the front of the queue.
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static class MyQueue<T> {
        Stack<T> eqStack = new Stack<T>();
        Stack<T> dqStack = new Stack<T>();
        
        // Start my code
        public void enqueue(T value) { // Push onto newest stack
            eqStack.push(value);
        }

        public T peek() {
            if(dqStack.empty() && !eqStack.empty()){
                while(!eqStack.empty()){
                    dqStack.push(eqStack.pop());
                }
                return dqStack.peek();
            }
            else if(!dqStack.empty())
                return dqStack.peek();
            else
                return null;
        }

        public T dequeue() {
            if(!dqStack.empty())
                return dqStack.pop();
            else if(dqStack.empty() && !eqStack.empty()){
                while(!eqStack.empty()){
                    dqStack.push(eqStack.pop());
                }
                return dqStack.pop();
            }
            else
                return null;
        }
    }
    // End my code
  
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
