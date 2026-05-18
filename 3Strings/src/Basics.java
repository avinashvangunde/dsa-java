import java.util.*;

public class Basics {
    public static void main(String[] args) {

        String a = "Avinash";
        String b = "Avinash";
        System.out.println(a.equals(b));    // interning -- intern pool   ,, a and b points to same string in heap

        String name1 = new String("Avinash");
        String name2 = new String("Avinash");

        System.out.println(name1 == name2);
        System.out.println(name1.equals(name2));

        System.out.println(a.charAt(0));

        System.out.println(Arrays.toString(new int[]{1, 2, 3, 4, 5}));

        // CompareTo     if equals returns 0 ,, if lexicographically str1 greater than  st2 return +ve ,, else str1 < str2 return -ve
        System.out.println(name1.compareTo(name2));

        System.out.println(name1.toLowerCase());
        System.out.println(name1.toUpperCase());
        System.out.println(name1.concat(name2));
        System.out.println(name1+3);   // String add with int
        System.out.println(name1+'V');  // String add with character
        System.out.println(name1+10+20);  // eval from left -> right
        System.out.println(name1+(10+20));

        // Substrings
         String str = "abcd";
        System.out.println(str.substring(0,3));

        // print all substrings of str
        for(int i=0; i<str.length() ;i++){
            for(int j=i+1; j<str.length()+1 ;j++){
                System.out.print(str.substring(i,j)+" ");
            }
         }


        // String are immutable because of interning string pool

    }
}