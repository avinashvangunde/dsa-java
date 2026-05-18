import java.util.Scanner;

/**
 *  recursion with Strings
 */

public class lec08 {
    public static void main(String[] args) {
        //String str = "Avinash";
        // substring method
        // System.out.println(str.substri ng(1, 4));  // 1,2,3 index of str

        // remove all occurrences of 'a' from string
        String s = "abcdaa";
        System.out.println(removeOcc(s,0));

        // remove all occurences of a without index parameter
        System.out.println(removeA(s));

        // reverse a string
        System.out.println(reverse(s));

        // check if string is palindrome
        String str = "dad";
        String str1 = "cool";
        System.out.println(palindrome(str1));

        // without reverse palindrome
        System.out.println(palindromeOp(str,0,str.length()-1));

    }

     static boolean palindromeOp(String s , int l ,int r){
        if(l>=r){
            return true;
        }

        return s.charAt(l) == s.charAt(r) && palindromeOp(s,l+1 ,r-1);
     }

    static boolean palindrome(String s){
        String rev = reverse(s);
        if(rev.equals(s))
            return true;
        return false;
    }

    static String reverse(String s){
        if(s.length() == 0){
            return "";
        }

        String sub = reverse(s.substring(1));
        return sub+s.charAt(0);
    }



    static String removeA(String s){
        if(s.length() == 0){
            return " ";
        }

        String sub = removeA(s.substring(1));
        char ch = s.charAt(0);
        if(ch != 'a'){
            return ch+sub;
        }
        return sub;
    }

    static String removeOcc(String str,int i){
        if(i == str.length()){    // base case
            return " ";
        }

        String sub = removeOcc(str,i+1);   // sub problem /faith

        char ch = str.charAt(i);    // self work
        if(ch!= 'a'){
            return ch+sub;
        }

        return sub;
    }

}
