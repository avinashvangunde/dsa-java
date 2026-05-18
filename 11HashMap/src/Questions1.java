import java.util.*;

public class Questions1 {
    public static void main(String[] args) {

        // find max characters in given string
        String str = "abracadabra";
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0 ;i<str.length() ;i++){
            Character ch = str.charAt(i);
            if(hm.containsKey(ch)){
                int val = hm.get(ch);
                hm.put(ch,val+1);
            }else{
                hm.put(ch,1);
            }
        }

        int max = 0;
        Character maxChar = null;
        for(Character ch : hm.keySet()){
            int val = hm.get(ch);
            if(val>max) {
                max = val;
                maxChar = ch;
            }
        }
//        System.out.println(hm);
//        System.out.println(maxChar);


        /**
         *
         *  Find common elements from arrays
         *    a1 -> 1 1 1 2 4 5
         *    a2 -> 1 2 2 3 5 5 5
         *    o/p -> 1 2 5
         */


        HashMap<Integer,Integer> hm1 = new HashMap<>();
        int[] a1 = {1 ,1 ,1 ,2 ,4 ,5};
        int[] a2 = {1 ,2 ,2 ,3 ,5 ,5 ,5};

        for(int i=0 ; i<a1.length ;i++){
            if(hm1.containsKey(a1[i])){
                int val = hm1.get(a1[i]);
                hm1.put(a1[i],val+1);
            }
            else{
                hm1.put(a1[i],1);
            }
        }


        List<Integer> lst = new ArrayList<>();
        for(int i=0 ; i<a2.length ;i++){
            if(hm1.containsKey(a2[i])){
                lst.add(a2[i]);
                hm1.remove(a2[i]);
            }
        }

        for(int i : lst){
           // System.out.print(i+" ");
        }


        /**
         *
         *   a1 -> 1 1 2 2 2 3 5
         *   a2 -> 1 1 1 2 2 4 5
         *  o/p -> 1 1 2 2 5
         */

        HashMap<Integer,Integer> hm2 = new HashMap<>();
        int[] arr1 = {1 ,1 ,2, 2 ,2 ,3 ,5};
        int[] arr2 = {1 ,1 ,1 ,2 ,2 ,4 ,5};

        for(int i=0 ; i<arr1.length ;i++){
            if(hm2.containsKey(arr1[i])){
                int val = hm2.get(arr1[i]);
                hm2.put(arr1[i],val+1);
            }
            else{
                hm2.put(arr1[i],1);
            }
        }
        System.out.println(hm2);
        List<Integer> list = new ArrayList<>();

        for(int i=0 ; i<arr2.length ;i++){
            if(hm2.containsKey(arr2[i]) && hm2.get(arr2[i])>0){
                int val = hm2.get(arr2[i]);
                hm2.put(arr2[i],val-1);
                list.add(arr2[i]);
            }
        }
        System.out.println(hm2);
        for(int i : list){
             System.out.print(i+" ");
        }

    }
}
