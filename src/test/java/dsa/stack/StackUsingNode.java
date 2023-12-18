package dsa.stack;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class StackUsingNode {
    public static class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static class Stack{
        Node head;
        public void push(int element){
            Node currNode = new Node(element);
            if(head == null) {
                head = currNode;
                currNode.next = null;
            }else{
                currNode.next = head;
                head = currNode;
            }
        }

        public int peek(){
            if(head!=null){
                return head.val;
            }
            return -1;
        }

        public int pop(){
            if(head!=null){
                Node tempHead = head;
                head = head.next;
                return tempHead.val;
            }else{
                isEmpty();
            }
            return -1;
        }

        public void display(){
            Node tempHead = head;
            while(tempHead!=null){
                System.out.print(head.val+" ");
                tempHead = tempHead.next;
            }
            System.out.println();
        }

        public int size(){
            int val=0;
            while(head!=null){
                head = head.next;
                val++;
            }
            return val;
        }

        public Boolean isEmpty(){
            if(head==null){
                System.out.println("Stack is empty!");
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Stack st=new Stack();
        st.push(10);
        st.push(100);
        st.push(200);
        st.push(400);
        st.display();
        System.out.println(st.peek());
        st.pop();
        st.pop();
        st.pop();
        st.pop();
        st.pop();
        st.display();
        System.out.println(st.size());
    }


}
