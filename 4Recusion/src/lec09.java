import java.util.ArrayList;

/**
 *  subsequence of string
 *   "abc" -> { abc, bc, ab , ac ,a, b , c }   ... order of characters should be maintained
 */

public class lec09 {
    public static void main(String[] args) {
        // find all subsequences in string return in arraylist
        String str = "abc";
        System.out.println(getSSQ(str));

        // without arraylist
        getSSQOp(str,"");

        System.out.println();

        // get sum of all subsets from array
        int[] a = {2,4,5};
        subsetSum(a,0,0);
    }

    static void subsetSum(int[] a,int idx ,int ans){
        if(idx == a.length){
            System.out.print(ans+" ");
            return;
        }
        subsetSum(a,idx+1,ans+a[idx]);
        subsetSum(a,idx+1,ans);
    }

    static void getSSQOp(String s,String ans){
        if(s.length() == 0){
            System.out.print(ans+" ");
            return;
        }

        char curr = s.charAt(0); // a
        String remString = s.substring(1); // bc

        // curr char chooses to be part of ans
        getSSQOp(remString,ans+curr);  // bc, a

        // curr char does not choose to be part of ans
        getSSQOp(remString,ans); // bc, " "
    }

    static ArrayList<String> getSSQ(String s){
        ArrayList<String> list = new ArrayList<>();
        if(s.length() == 0){
             list.add(" ");
             return list;
        }

        char ch = s.charAt(0);  // a
        ArrayList<String> sub = getSSQ(s.substring(1));  // ["bc" , "b", "c" ," " ]
        for(String str : sub){
            list.add(str);
            list.add(ch+str); //  ["bc","abc","b","ab","c","ac" ,"" ,"a" ]
        }
        return list;
    }
}
