/**
 *  Implementation of singly linked lists
 */

public class Implementation {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    public static class linkedlist{
        Node head , tail = null;

        // insertion in linked lists
         void insertAtEnd(int n){
            Node temp = new Node(n);
            if(head == null)
                head  = temp;
            else
                tail.next = temp;
             tail = temp;
        }

        void insertAtStart(int n){
             Node temp = new Node(n);
             if(head == null)
                 tail = temp;
             else
                 temp.next = head;
            head = temp;
        }

        void insertAtIndex(int idx , int n){
             Node node = new Node(n);
             Node temp = head;

             if(idx<0 || idx>size()){
                 System.out.println("Wrong index");
                 return;
             }

             if(idx == size()){
                 insertAtEnd(n);
                 return;
             } else if (idx == 0) {
                 insertAtStart(n);
                 return;
             }

            for(int i=0;i<idx-1;i++)
                 temp = temp.next;

             node.next = temp.next;
             temp.next = node;
        }

        int getAt(int idx){
            if(idx<0 || idx>size()){
                System.out.println("Wrong index");
                return -1;
            }
             Node temp = head;
             for(int i=0;i<idx;i++)
                 temp = temp.next;

             return temp.data;
        }

        void deleteAtIndex(int idx){
             if(idx<0 || idx>size()){
                 System.out.println("Wrong index");
                 return;
             }

             if(idx == 0) {
                 head = head.next;
                 return;
             }

            Node temp = head;
             for(int i=0;i<idx-1;i++)
                 temp = temp.next;

             temp.next = temp.next.next;
             if(idx == size())
                 tail = temp;
        }

        int size(){
             int cnt=0;
             Node temp = head;
             while(temp!=null){
                 temp = temp.next;
                 cnt++;
             }
             return cnt;
        }

        void disp(){
             Node temp = head;
             while(temp!=null){
                 System.out.print(temp.data+" ");
                 temp = temp.next;
             }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        linkedlist ll = new linkedlist();
        ll.insertAtEnd(5);
        ll.insertAtEnd(15);
        ll.disp();

        // insertion At Start
        ll.insertAtStart(1);
        ll.insertAtStart(2);
        ll.disp();

        // insert node at any index .... zero  based index
        ll.insertAtIndex(4,7);  // this is basically inert at index
        ll.disp();

       ll.insertAtIndex(0,100);
       ll.disp();


       // implement Get methods
        System.out.println(ll.getAt(2));

        // delete at any index
        ll.deleteAtIndex(3);
        ll.disp();


        ll.deleteAtIndex(0);   // delete first index
        ll.disp();

        ll.deleteAtIndex(3);   // delete last index
        ll.disp();
        ll.deleteAtIndex(0);
        ll.deleteAtIndex(0);
        ll.deleteAtIndex(0);
        ll.disp();



        ll.insertAtEnd(100);
        ll.insertAtEnd(13);
        ll.insertAtEnd(4);
        ll.insertAtEnd(5);
        ll.insertAtEnd(12);
        ll.insertAtEnd(10);
        ll.disp();

        // find nth node from end
        int n = 2;
        int pos = ll.size() - n;
        System.out.println(ll.getAt(pos));

    }
}
