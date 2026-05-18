import java.util.*;

public class Basic {

    public static void MapInterface(){
        Hashtable<String,Integer> ht = new Hashtable<>();  // any order ele are inserted
        ht.put("Ind",1);
        ht.put("Aus",2);
        ht.put("Eng",3);
        ht.put("Afg",4);
        System.out.println(ht);

        Map<String,Integer> hm = new HashMap<>();
        hm.put("Ind",1);
        hm.put("Aus",2);
        hm.put("Eng",3);
        hm.put("Afg",4);
        System.out.println(hm);

        LinkedHashMap<String,Integer> lhm = new LinkedHashMap<>();  // order is preserved
        lhm.put("Ind",1);
        lhm.put("Aus",2);
        lhm.put("Eng",3);
        lhm.put("Afg",4);
        System.out.println(lhm);
    }

    public static void SetInterface(){
        // Set Interface <--- HashSet , linkedHashSet ,  SortedSetInterface <-- treeSet
        HashSet<Integer> hs = new HashSet<>();   // unordered , unique and uses hashing internally
        hs.add(2);
        hs.add(20);
        hs.add(2);  // will not be allowed to add
        hs.add(200);
        hs.add(13);
        hs.add(23);
        hs.add(25);
        System.out.println(hs);


        LinkedList<Integer> lhs = new LinkedList<>(); // ordered insertions , not unique
        lhs.add(2);
        lhs.add(20);
        lhs.add(2);
        lhs.add(200);
        lhs.add(13);
        lhs.add(23);
        lhs.add(25);
        System.out.println(lhs);

        TreeSet<Integer> tst = new TreeSet<>();
        tst.add(33);
        tst.add(12);
        tst.add(2);
        tst.add(11);
        tst.add(22);
        System.out.println(tst);  // preserves element in sorted order  (ascending order)
    }


    public static void QueueInterface(){
        // Queue interface  <-- (implements) LinkedList , Priority Queue , Dequeue
        LinkedList<Integer> q = new LinkedList<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        System.out.println(q);
        System.out.println(q.peek());
        System.out.println(q.poll());
        System.out.println(q);

        // priority queue  --> priority based processing
        PriorityQueue<Integer> pq = new PriorityQueue<>();  // min priority queue smallest ele has the highest priority
        pq.add(14);
        pq.add(100);
        pq.add(10);
        pq.add(2);
        System.out.println(pq.peek());
        System.out.println(pq);

        // max priority Queue
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Comparator.reverseOrder());
        pq1.add(14);
        pq1.add(100);
        pq1.add(10);
        pq1.add(2);
        System.out.println(pq1.peek());
        System.out.println(pq1);

        //Dequeue --> doubly ended queue
        Deque<Integer> dq = new LinkedList<>();
        dq.add(10);
        dq.add(20);
        dq.add(30);
        dq.add(40);
        dq.add(50);
        System.out.println(dq);
        System.out.println(dq.peek());
        System.out.println(dq.peekLast());
        dq.addFirst(1);
        dq.addLast(3);
        System.out.println(dq);

    }

    public static void main(String[] args) {
        // wrapper classes
        Integer num = Integer.valueOf(7);
        System.out.println(num);

        // syntax
        ArrayList<Integer> lst = new ArrayList<>();
        // add ele
        lst.add(1);
        lst.add(2);
        lst.add(3);
        lst.add(4);

        // get ele at index i
        System.out.println(lst.get(0));

        // print using for
        for(int ele: lst){
            System.out.print(ele+" ");
        }
        System.out.println();

        // adding at index i
        lst.add(1,100);
        System.out.println(lst);


        //modify at index i
        lst.set(1,200);
        System.out.println(lst);

        // remove an ele at index i
        lst.remove(2);
        System.out.println(lst);

        // if you don't specify datatype you can add anything in the list
        ArrayList l = new ArrayList();
        l.add(1);
        l.add("Avinash");
        l.add('A');
        System.out.println(l);


         // reverse an arraylist
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        a.add(0);
        a.add(10);
        a.add(5);
        a.add(2);
        a.add(8);


        for(int i=a.size()-1 ; i>=0 ;i--){
            b.add(a.get(i));
        }
        System.out.println(a);
        System.out.println(b);


        Collections.reverse(a);
        System.out.println("Using Collection:" +a);



        // Sort an arraylist  in asc order
        Collections.sort(a);
        System.out.println(a);

        // sort in desc order
        Collections.sort(a,Collections.reverseOrder());
        System.out.println(a);

        // String sorting uses lexicography
        ArrayList<String> arr = new ArrayList<>();
        arr.add("Hello");
        arr.add("I");
        arr.add("Am");
        arr.add("Avi");
        System.out.println("Original:" +arr);
        Collections.sort(arr);
        System.out.println("ASC :"+ arr);
        Collections.sort(arr,Collections.reverseOrder());
        System.out.println("DESC: "+ arr);


        // Queue interface example <-- (implements) LinkedList , Priority Queue , Dequeue
        QueueInterface();

        SetInterface();

        MapInterface();
    }
}