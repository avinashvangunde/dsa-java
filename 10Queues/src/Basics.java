import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Basics {
    public static void print(Queue q){
        Queue<Integer> helper = new LinkedList<>();
        while(q.size()>0){
            System.out.print(q.peek()+" ");
            helper.add((int)q.remove());
        }
        while(helper.size()>0){
            q.add(helper.remove());
        }
        System.out.println();
    }

    public static class ArrayQImpl{
        int[] q = new int[100];
        int f ,r = -1;
        int size = 0;
        void add(int val){
            if(r == q.length-1){
                System.out.println("Queue is full");
                return;
            }

            if(f == -1)
                f++;

            q[++r] = val;
            size++;
        }

        int peek(){
            if(size == 0){
                System.out.println("Queue is empty");
                return -1;
            }
            return q[f];
        }

        int remove(){
            if(size == 0){
                System.out.println("Queue is empty");
                return -1;
            }
            f++;
            size--;
            return q[f-1];
        }

        void disp(){
            for(int i=f;i<=r;i++){
                System.out.print(q[i]+" ");
            }
            System.out.println();
            System.out.println("f --> "+q[f]);
            System.out.println("r --> "+q[r]);
        }
    }

    public static class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }

    public static class LLQImpl{
        Node f,r = null;
        int size = 0;

        void add(int n){
            Node node = new Node(n);
            if(f == null){
                f = r  = node;
            } else {
                r.next = node;
                r = r.next;
            }
            size++;
        }

        int remove(){
            if(size == 0){
                System.out.println("Queue is empty! ");
                return -1;
            }
            if(size == 1){
                f = r = null;
                size--;
                return -1;
            }

            int num = f.val;
            f = f.next;
            size--;
            return num;
        }


        int peek(){
            if(size == 0){
                System.out.println("Queue is empty! ");
                return -1;
            }
            return f.val;
        }

        void disp(){
            Node temp = f;
            while(temp!=null){
                System.out.print(temp.val+" ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q  =  new LinkedList<>();
        // add remove peek :
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        print(q);   // user defined print method
        System.out.println(q);
        System.out.println();

        // Array Implementation of queues

        ArrayQImpl arrayQ = new ArrayQImpl();
        arrayQ.add(10);
        arrayQ.add(20);
        arrayQ.add(30);
        arrayQ.add(40);
        arrayQ.add(50);
        arrayQ.disp();
        arrayQ.remove();
        arrayQ.disp();
        System.out.println(arrayQ.peek());

        System.out.println();
        // Linked list implementation of Queues
        LLQImpl llq = new LLQImpl();
        llq.add(10);
        llq.add(20);
        llq.add(30);
        llq.add(40);
        llq.add(50);

        llq.remove();
        llq.disp();
        System.out.println(llq.peek());


        // Deque --> doubly ended queue
        Deque<Integer> dq = new LinkedList<>();
        dq.add(10);
        dq.add(20);
        dq.add(30);
        dq.add(40);
        System.out.println(dq);
        dq.addFirst(500);
        dq.removeLast();
        System.out.println(dq);

    }
}