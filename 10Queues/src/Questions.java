import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Questions {
    static void revQ(Queue<Integer> q){
        System.out.println(q);
        System.out.println(q.peek());
        Stack<Integer> st = new Stack<>();
        while(q.size()>0){
            st.push(q.remove());
        }

        System.out.println(st.peek());
        while (st.size()>0){
            q.add(st.pop());
        }
        System.out.println(q);
    }

    static void revKQ(Queue<Integer> q,int k){
        System.out.println(q);
        Stack<Integer> st = new Stack<>();
        while(k--!=0){
            st.push(q.remove());
        }

        System.out.println(st);
        while (st.size()>0){
            q.add(st.pop());
        }
        System.out.println(q);
        int n = q.size() - k+1;
        while(n--!=0){
            q.add(q.remove());
        }
        System.out.println(q);
    }

    public static void main(String[] args) {
        // reverse given queue
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        revQ(q);

        // reverse first k elements in queue
        revKQ(q,3);

    }
}
