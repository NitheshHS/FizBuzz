package dsa.linkedlist;

import javax.swing.*;

public class MainClass {
    public static void main(String[] args) {
        MyLinkedList list=new MyLinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);
        /*list.insertFirst(1);
        list.insertFirst(200);
        list.insertAt(1,100);*/
        list.display();
        System.out.println("=========");
        /*list.deleteAt(3);
        list.display();*/
        list.delete(30);
        list.display();

    }
}
