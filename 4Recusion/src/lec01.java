/**
 *
 *   Basics of recursion
 *   vvimp topic
 *   rules of recursion
 */

public class lec01 {
    public static void main(String[] args) {
        // write code to print all natural number from 1 to n
        print(5);  // 1 to  n
        System.out.println();
        printRev(5); // n to 1
    }

    static void printRev(int n){
        // print(n) = n, - - - - , 3 , 2 ,1
        //          = n   print(n-1)

        if(n==1){
            System.out.print(n+" ");
            return;
        }
        System.out.print(n+" ");
        printRev(n-1);
    }

    static void print(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        print(n - 1);
        System.out.print(n + " ");
    }


}