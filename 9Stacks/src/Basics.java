/*
 Stacks:
    offers discipline to arraylist i.e we cannot add values to any sides ,can only add  values to top of stack
 operations:
    push ,pop , peek ,size
 */


import java.util.*;

public class Basics {

    public static  class Node{
        int data;
        Node next;
        Node(int  data){
            this.data = data;
        }
    }

    public static class LinkedListStack{
        Node head = null;
        int size = 0;

        void push(int val){
            Node node = new Node(val);
            node.next = head;
            head = node;
            size++;
        }

        int pop(){
            if(head == null)
                return -1;

            int poppedElement = head.data;
            head = head.next;
            size--;
            return poppedElement;
        }

        int stackSize(){
            return size;
        }

        int peek(){
            if(head == null)
                return -1;
            return head.data;
        }

        void dispRec(Node head){
            if(head == null)
                return;
            dispRec(head.next);
            System.out.print(head.data+" ");

        }
        void disp(){
            dispRec(head);
            System.out.println();
        }

        void dispReverse(){
            Node temp = head;
            while(temp!= null){
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
            System.out.println();
        }


    }

    public static class ArrayStack{
        int[] arr = new int[5];
        int pos = 0;

        // push .. pop .. disp .. peek .. size

         void push(int val){
            if(pos == arr.length)
                return;

            arr[pos] = val;
            pos++;
        }

        int pop(){
             if(pos == 0)
                 return -1;

             pos--;
             int top = arr[pos];
             arr[pos] = 0;
             return top;
        }

        void disp(){
             for(int i=0; i<pos; i++){
                 System.out.print(arr[i]+" ");
             }
            System.out.println();
        }


        int peek(){
            if(pos == 0)
                return -1;

            return arr[pos-1];
        }

        int size(){
            if(pos == 0)
                return -1;
             return pos;
        }
    }

    static void dispRec(Stack<Integer> st){
        if(st.isEmpty())
            return;

        int top = st.pop();
        System.out.print(top+" ");
        dispRec(st);
        st.push(top);
    }

    static void pushAtBottom(Stack<Integer> st,int val){
        if(st.size()==0){
            st.push(val);
            return;
        }
        int top = st.pop();
        pushAtBottom(st,val);
        st.push(top);
    }

    static void revStack(Stack<Integer> st){
        if(st.size() == 1)
            return;

        int top = st.pop();
        revStack(st);
        pushAtBottom(st,top);
    }


    public static void main(String[] args) {
        System.out.println("Stacks Basics!");
        Stack<Integer> st = new Stack<>();


        // copy contents of one stack to another stack
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);


        Stack<Integer> temp = new Stack<>();
        Stack<Integer> copy = new Stack<>();

        System.out.println(st);

        while(st.size()>0){
            temp.push(st.pop());
        }

        System.out.println(temp);

        while(temp.size()>0){
            copy.push(temp.pop());
        }

        System.out.println(copy);


        // dispaly stack using recursion
        st.push(1);
        st.push(2);
        st.push(4);
        st.push(5);

        System.out.println("Using recursion: ");
        System.out.println(st);
        dispRec(st);
        System.out.println();

      // insert at any index
        System.out.println(st);

        int idx = 2;
        int val = 3;
        while(st.size() > idx){
            temp.push(st.pop());
        }
        System.out.println(temp);

        st.push(val);
        while (temp.size()>0){
            st.push(temp.pop());
        }

        System.out.println(st);



        // remove from any idx
        while(st.size()>idx){
            temp.push(st.pop());
        }
        if(temp.peek() == val)
            temp.pop();

        while (temp.size()>0){
            st.push(temp.pop());
        }

        System.out.println(st);

        // display stack using arrays
        int n = st.size();
        int[] arr = new int[n];

        int i=0;
        while(st.size()>0){
            arr[i++] = st.pop();
        }
        System.out.println(Arrays.toString(arr));

        for(int j=n-1; j>=0 ;j-- ){
            System.out.print(arr[j]+" ");
        }



//        // Array implementation of stack
//        // pop , push , size , peek

        System.out.println();
        System.out.println();
        ArrayStack  ast  = new ArrayStack();
        ast.push(12);
        ast.push(1);
        ast.push(11);
        ast.push(13);

        System.out.println(ast.pop());
        ast.disp();
        System.out.println(ast.peek());
        System.out.println(ast.size());


        // Reverse a stack using recursion
        st.push(100);
        st.push(200);
        st.push(300);
        st.push(400);
        st.push(500);
        System.out.println(st);

        revStack(st);
        System.out.println(st);



        // Linked Lists implementation of Stacks
        LinkedListStack lst = new LinkedListStack();
        lst.push(10);
        lst.push(20);
        lst.push(30);
        lst.push(40);
        lst.disp();
        lst.pop();
        lst.disp();
        System.out.println(lst.size);
        System.out.println(lst.peek());


    }
}