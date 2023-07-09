// Bar Chart
/*
 Input:
   5 -> 3,2,1,5,1

  Output:
         *
         *
   *     *
   * *   *
   * * * * *

 */

import java.util.*;

public class Quest1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter n for Array");
        int n = scn.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter values in Array");
        int max = -1;
        for(int i=0 ; i<arr.length ; i++){
            arr[i] = scn.nextInt();
            if(max<arr[i])
                max = arr[i];
        }

        for(int m=max ; m>=1 ; m--) {
            for (int i = 0; i < arr.length; i++) {
                if (m <= arr[i]) {
                    System.out.print(" * ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }
}
