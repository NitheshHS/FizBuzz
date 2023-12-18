package dsa.linkedlist.prcatice;

import java.util.Date;

public class CustomLinkedList {
    private Node head;
    public void add(int data){
        Node curNode=new Node();
        curNode.data = data;
        curNode.next = null;
        if(head == null){
            head = curNode;
        }else{
            Node current = head;
            while(current.next!=null){
                current = current.next;
            }
            current.next = curNode;
        }
    }

    public void display(){
        Node curNode = head;
        while(curNode!=null){
            System.out.println(curNode.data);
            curNode = curNode.next;
        }
    }

    public void addFirst(int data){
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data){
        Node newNode=new Node();
        newNode.data = data;
        Node current = head;
        while (current.next!=null){
            current = current.next;
        }
        current.next = newNode;
    }

    public void delete(int value){
        Node current = head;
        Node previous = null;
        while(current!=null){
            if(current.data==value){
                if(previous == null){
                    head = current.next;
                }else{
                    previous.next = current.next;
                }
                current.next = null;
                break;
            }
            previous = current;
            current = current.next;
        }
    }

    public int size(){
        Node current = head;
        int size = 0;
        while(current!=null){
            current = current.next;
            size++;
        }
        return size;
    }

    public int indexOf(int data){
        Node current = head;
        int index = 0;
        while(current!=null){
            if(current.data==data){
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }
}
