package dsa.linkedlist.doublyLinkedList;

public class MainClass {

    public static void main(String[] args) {
        Node a=new Node(10);
        Node b= new Node(20);
        Node c= new Node(30);
        Node d= new Node(40);
        Node e= new Node(50);
        Node f= new Node(60);
        a.prev = null;
        a.next = b;
        b.prev = a;
        b.next = c;
        c.prev = b;
        c.next = d;
        d.prev = c;
        d.next = e;
        e.prev=d;
        e.next = f;
        f.prev = e;
        f.next = null;

//        display(a);
//        Node insertHead = insertAtHead(a, 100);
//        display(insertHead);
//        Node insertTail = insertAtTail(d, 200);
//        displayRev(insertTail);
        //displayRev(d);
//        insertTail(a, 500);
//        insertTail(a, 600);
        insertAt(a, 3, 1000);
        display(a);
        display(deleteHead(a));
        display(deleteTail(a));
        display(deleteAt(a, 4));
    }
    public static void display(Node node){
        Node temp=node;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void displayRev(Node node){
        Node temp = node;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.prev;
        }
        System.out.println();
    }

    public static Node insertAtHead(Node head, int val){
        Node newNode = new Node(val);
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        return head;
    }

    public static Node insertAtTail(Node tail, int val){
        Node newNode = new Node(val);
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
        return tail;
    }

    public static void insertTail(Node head, int val){
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        Node tailNode=new Node(val);
        tailNode.prev = temp;
        temp.next = tailNode;
        temp = tailNode;
    }

    public static void insertAt(Node head,int index, int val){
        Node temp=head;
        int indexNum=0;
        for(int i=1;i<index-1;i++){
            temp = temp.next;
        }
        Node newNode = new Node(val);
        Node end = temp.next;
        newNode.prev = temp;
        temp.next = newNode;
        newNode.next = end;
        end.prev = newNode;
    }

    public static Node deleteHead(Node head){
        Node temp=head;
        temp = temp.next;
        temp.prev = null;
        head = temp;
        return head;
    }

    public static Node deleteTail(Node head){
        Node storeHead= head;
        Node temp=head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp = temp.prev;
        temp.next = null;
        return storeHead;
    }

    public static Node deleteAt(Node head, int index){
        Node storeHead = head;
        Node start = head;
        for(int i=1;i<index-1;i++) {
            start = start.next;
        }
        start.next = start.next.next;
        start.next.prev = start;
        System.out.println("===========");
        System.out.println(start.val);
        System.out.println(start.next.val);
        System.out.println(start.prev.val);
        return storeHead;
    }
}
