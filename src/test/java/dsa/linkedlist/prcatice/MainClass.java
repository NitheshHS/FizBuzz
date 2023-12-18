package dsa.linkedlist.prcatice;

public class MainClass {
    public static void main(String[] args) {
        CustomLinkedList list=new CustomLinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.addLast(70);
        list.addFirst(40);
        list.delete(30);
        list.display();
        System.out.println(list.size());
        System.out.println(list.indexOf(10));
    }
}
