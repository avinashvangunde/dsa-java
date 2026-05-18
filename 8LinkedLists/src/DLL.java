/**
 *
 *  Doubly linked lists
 */


public class DLL {
    public static class Node{
        int data;
        Node next;
        Node prev;
        Node(int val){
            data = val;
        }
    }

    public static void disp(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    static void dispRev(Node tail){
        Node temp = tail;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.prev;
        }
    }

    static Node insertAtHead(Node a,int val){
        Node node = new Node(val);
        if(a == null){
            return node;
        }else{
            node.next = a;
            a.prev = node;
            return node;
        }
    }

    public static void main(String[] args) {
        Node a = new Node(10);
        Node b = new Node(20);
        Node c = new Node(30);
        Node d = new Node(40);
        Node e = new Node(50);

        a.next = b;
        a.prev = null;

        b.next = c;
        b.prev = a;

        c.next = d;
        c.prev = b;

        d.next = e;
        d.prev = c;

        e.next = null;
        e.prev = d;
        disp(a);
        dispRev(e);

        // insert at head
        Node head = insertAtHead(a,5);
        System.out.println();
        disp(head);

    }
}
