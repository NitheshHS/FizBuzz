package dsa.linkedlist;

public class MyLinkedList {
    Node head;
    public void insert(int data){
        Node newNode=new Node();
        newNode.data = data;
        newNode.next = null;

        if(head == null){
            head = newNode;
        }else{
            Node currNode = head;
            while(currNode.next!=null){
                currNode = currNode.next;
            }
            currNode.next = newNode;
        }
    }

    public void display(){
        Node currNode=head;
        while(currNode.next!=null){
            System.out.println(currNode.data);
            currNode = currNode.next;
        }
        System.out.println(currNode.data);
    }

    public void insertFirst(int data){
        Node newNode=new Node();
        newNode.data = data;
        newNode.next = head;
        head = newNode;
    }

    public void insertAt(int index, int data){
        Node newNode=new Node();
        newNode.data = data;

        Node curNode = head;
        for(int i=0;i<index-1;i++){
           curNode = curNode.next;
        }
        newNode.next = curNode.next;
        curNode.next = newNode;
    }

    public void deleteAt(int index){
        Node currNode=head;
        Node nextNode = null;
        for(int i=0;i<index-1;i++){
            currNode = currNode.next;
        }
        nextNode = currNode.next;
        currNode.next = nextNode.next;
    }

    public void delete(int value){
        Node curNode = head;
        Node prevNode = null;
        while(curNode!=null){
            if(curNode.data == value){
                if(prevNode == null){
                    head = curNode.next;
                }else{
                    prevNode.next = curNode.next;
                }
                curNode.next = null;
                break;
            }
            prevNode = curNode;
            curNode = curNode.next;
        }
    }

    public void deleteValue(int value) {
        Node curNode = head;
        Node prevNode = null;

        while (curNode != null) {
            if (curNode.data == value) {
                if (prevNode == null) {
                    // If the node to be deleted is the head of the list
                    head = curNode.next;
                } else {
                    // Update the next pointer of the previous node to skip the current node
                    prevNode.next = curNode.next;
                }
                // Optional: Set curNode.next to null to disconnect the node from the list
                curNode.next = null;
                break;
            }
            prevNode = curNode;
            curNode = curNode.next;
        }
    }
}
