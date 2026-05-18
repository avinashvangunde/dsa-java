import java.util.*;

public class HMImplementation {

    static class MyHashMap<K,V>{
        public static  final int DEFAULT_CAPACITY = 4;
        public static  final float LOAD_FACTOR = 0.75f;
        private LinkedList<Node>[] buckets;  // array of linked list
        private int n; // number of entries in map

        private void initBuckets(int N){  // N -- capacity / size of buckets array
            buckets = new LinkedList[N];
            for(int i=0; i< buckets.length ;i++){
                buckets[i] = new LinkedList<>();
            }
        }
        public MyHashMap(){
            initBuckets(DEFAULT_CAPACITY);
        }

        private class Node{
            K key;
            V value;
            Node(K key,V value){
                this.key = key;
                this.value = value;
            }
        }

        private int HashFunction(K key){
            int hc =  key.hashCode();    // can return very big int and even an negative int
            return Math.abs(hc) % buckets.length;
        }

        private int searchInBucket(LinkedList<Node> bucket , K key){
            // traverse the linked list and looks for node with key .. if found return index else returns -1
            for(int i=0; i<bucket.size();i++){
                if(bucket.get(i).key == key) {
                    return i;
                }
            }
            return -1;
        }

        private void reHash(){
            LinkedList<Node>[] oldBuckets = buckets;
            initBuckets(oldBuckets.length*2);
            n = 0;
            for(LinkedList<Node> bucket : oldBuckets){
                for(Node node : bucket)
                    put(node.key, node.value);
            }
        }

        public void put(K key, V value){
            int bi = HashFunction(key);
            LinkedList<Node> currBucket = buckets[bi];
            int ei = searchInBucket(currBucket,key);
            if(ei == -1){  // key doesn't exists
                Node node = new Node(key,value);
                n++;
                currBucket.add(node);
            }else{   // update the value
                Node currNode = currBucket.get(ei);
                currNode.value = value;
            }

            if(n >= buckets.length * DEFAULT_CAPACITY ){
                reHash();
            }
        }

        public int size(){
            return n;
        }

        public V get(K key){
            int bi = HashFunction(key);
            LinkedList<Node> currBucket = buckets[bi];
            int ei = searchInBucket(currBucket,key);
            if(ei == -1){  // key doesn't exists
                return null;
            } else{
                Node currNode = currBucket.get(ei);
                return currNode.value;
            }
        }

        public boolean containsKey(K key){
            int bi = HashFunction(key);
            LinkedList<Node> currBucket = buckets[bi];
            int ei = searchInBucket(currBucket,key);
            if(ei == -1)   // key doesn't exists
                return false;
            else
                return true;
        }

        public V remove(K key){
            int bi = HashFunction(key);
            LinkedList<Node> currBucket = buckets[bi];
            int ei = searchInBucket(currBucket,key);
            if(ei == -1){  // key doesn't exists
                return null;
            } else{
                Node currNode = currBucket.get(ei);
                V val  = currNode.value;
                currBucket.remove(ei);
                n--;
                return val;
            }
        }
    }

    public static void main(String[] args) {
        MyHashMap<String,Integer> hm  = new MyHashMap<>();
        System.out.println("Testing PUT:");
        hm.put("A",1);
        hm.put("B",2);
        hm.put("C",3);
        hm.put("D",4);
        hm.put("E",5);
        hm.put("F",6);
        hm.put("G",7);
        hm.put("G",8);

        System.out.println(hm.size());

        System.out.println("Testing GET:");
        System.out.println(hm.get("A"));
        System.out.println(hm.get("B"));
        System.out.println(hm.get("C"));


        System.out.println(hm.remove("B"));
        System.out.println(hm.get("B"));

     }
}
