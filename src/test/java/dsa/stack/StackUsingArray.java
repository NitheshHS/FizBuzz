package dsa.stack;

import java.util.Arrays;

public class StackUsingArray {
    public static class Stack{
        private int[] arr = new int[10];
        private int index = 0;

        public void push(int num){
            arr[index] = num;
            index++;
        }

        public void display(){
           for(int i=0; i< index;i++){
               System.out.printf("%d, ", arr[i]);
           }
            System.out.println();
        }

        public int peek(){
            return arr[index-1];
        }

        public int pop(){
            int lastElement = arr[index-1];
            lastElement=0;
            index--;
            return lastElement;
        }
        public int size(){
            return index;
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();
        //System.out.println(stack.peek());
        System.out.println(stack.size());
        stack.pop();
        stack.display();
        System.out.println(stack.size());
    }
}
