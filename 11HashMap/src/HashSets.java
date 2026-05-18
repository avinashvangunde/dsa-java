import java.util.*;

public class HashSets {

    // finding the longest sequence continuous elements
    static void longestSeqArrOp(int[] a){
        HashSet<Integer> hs = new HashSet<>();
        for(int ele : a)
            hs.add(ele);

        int maxLen =0;
        for(Integer val : hs){
            int len = 0;
            if(!hs.contains(val-1)){
                while(hs.contains(val)) {
                    len++;
                    val++;
                }
                maxLen = Math.max(maxLen,len);
            }
        }

        System.out.println(maxLen);
    }


    static void findMaxOnTable(int[] a){
        HashSet<Integer> table = new HashSet<>();

        int maxLen = 0;
        for(int ele: a){
            if(table.contains(ele)){  // out of bag / element on table
                maxLen = Math.max(table.size(),maxLen);
                table.remove(ele);
            }else{   // inside the bag
                table.add(ele);
            }
        }
        System.out.println(maxLen);
    }

    public static void main(String[] args) {

        // HashSets ... no duplicate elements are allowed to be entered

        HashSet<Integer> hs = new HashSet<>();
        hs.add(10);
        hs.add(20);
        hs.add(30);
        hs.add(10);
        hs.add(50);

        // find the longest sequence  Optimised approach

        /**
         *  find longest consecutive sequence in array
         *
         *  arr-> 10 5 9 1 11 8 6 15 3 12 2
         *  seq:
         *     1 2 3
         *     5 6
         *     8 9 10 11 12
         *     15
         *
         *  output:
         */

        int[] a = {100,4,200,1,3,2,1};
        int[] arr = {10 ,5 ,9 ,1 ,11 ,8 ,6 ,15 ,3 ,12 ,2};
        longestSeqArrOp(a);


        // find max numbers on table at any given time
        int[] b = {2,1,1,3,2,3};
        findMaxOnTable(b);
    }
}
