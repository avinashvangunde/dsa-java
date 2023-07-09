// sum of two arrays
/*
   3 ->   3 4 5
   4 -> 2 4 5 1
 ans -> 2 7 9 6
 */

import java.util.*;

public class Quest2 {
    public static void myAns(int[] a1 , int[] a2){
        int sz = Math.max(a1.length,a2.length);
        int[] ans = new int[sz];
        int c = 0;
        int i =  a1.length - 1;
        int j =  a2.length - 1;
        int k = ans.length - 1;
        while(k>=0) {
            int d = c;
            if(i>=0)
                d+=a1[i];
            if(j>=0)
                d+=a2[j];
            c = d/10;
            d = d%10;
            ans[k] = d;
            i--;
            j--;
            k--;
        }
        if(c!=0){
            System.out.print(1+" ");
        }

        for(int a=0 ; a< ans.length ; a++ ){
            System.out.print(ans[a]+" ");
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Size 1");
        int n = scn.nextInt();
        int[] arr1 = new int[n];
        System.out.println("Enter Array 1");
        for(int i=0 ; i< arr1.length ; i++ ){
            arr1[i]= scn.nextInt();
        }
        System.out.println("Enter size 2");
        n = scn.nextInt();
        int[] arr2 = new int[n];
        System.out.println("Enter Array 2");
        for(int i=0 ; i< arr2.length ; i++ ){
            arr2[i]= scn.nextInt();
        }
        myAns(arr1,arr2);

    }
}
