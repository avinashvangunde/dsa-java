public class Basics {
    public static class Node{
        int data;   // value of curr node
        Node next;  // address of next node
        Node(int data){
            this.data = data;
        }
    }



    public static void main(String[] args) {
        Node a = new Node(3);
        Node b = new Node(5);
        Node c = new Node(4);
        Node d = new Node(8);
        Node e = new Node(1);

        //  3->5->4->8->1

        System.out.println(a);
        System.out.println(a.next);
        System.out.println(a.next = b);   // address of node b stored in a
        System.out.println(b);
        System.out.println(a.next.data);
        System.out.println();
        b.next = c;
        c.next = d;
        d.next = e;

        // function display --> printing linked lists
        display(a);    // iterative
        System.out.println();
        disp(a);        // recursive

        // find length of linked list
        System.out.println();
        System.out.println(len(a));

     }

     static int len(Node a){
        if(a==null){
            return 0;
        }

        return 1+len(a.next);
     }

     static void disp(Node a){
        if(a.next == null){
            System.out.print(a.data);
            return;
        }

         System.out.print(a.data+" ");
         disp(a.next);
     }

     static void display(Node a){
        Node temp = a;
        while(temp!= null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
     }
}
