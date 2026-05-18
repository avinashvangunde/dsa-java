import java.util.*;
public class Basics {

    public static void swap(int[] arr ,int i , int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void swap(int a ,int b){
        a = a+b;  //14
        b = a-b;  //10
        a = a-b;  // 4
        System.out.println("a:"+a+" b:"+b);
    }

    static void reverse(int[] a){
        for(int i=0,j=a.length-1 ;i<a.length ;i++,j--){
            a[i] = a[i]+a[j];
            a[j] = a[i]-a[j];
            a[i] = a[i]-a[j];
        }
        for(int i:a){
            System.out.print(i+" ");
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[5];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        //System.out.println(arr.length);
        for (int i = 0; i < arr.length; i++) {
            //  System.out.println(arr[i]);
        }

        int[] one = new int[3];
        one[0] = 1;
        one[1] = 2;
        one[2] = 3;

        int[] two = one; // does a shallow copy
        two[0] = 200;

        for (int i = 0; i < one.length; i++) {
//              System.out.println(one[i]);
        }

        for (int i = 0; i < two.length; i++) {
//              System.out.println(two[i]);
        }

        swap(one, 1, 2);   // Shallow copy
        for (int i = 0; i < one.length; i++) {
//              System.out.println(one[i]);
        }


        // Swap two integers
       // swap(10,4);

        // reverse an array
       // reverse(new int[]{1,2,3,4,5});


        // find span of array (max - min)

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter a number");
//        int n = sc.nextInt();
//        int[] a = new int[n];
//
//        System.out.println("Enter values in  array");
//        for (int i = 0; i < n; i++) {
//            a[i] = sc.nextInt();
//        }


//        int max = a[0];
//        int min = a[0];
//
//        for(int i=2 ; i<a.length ; i++){
//            if(max<a[i])
//                max = a[i];
//            if(min>a[i])
//                min = a[i];
//        }
//
//        System.out.println(max);
//        System.out.println(min);


        // find element in array and return its index

//        System.out.println("Enter a number to find in array");
//        int ele = sc.nextInt();
//        int indx = -1;
//        for (int i = 0; i < a.length; i++) {
//            if (ele == a[i]) {
//                indx = i;
//                break;
//            }
//        }
        //System.out.println("index found at " + indx);


        /**
         * 2 D Arrays
         * take input and iteration of 2D arrays
         *  printing of 2D arrays
         */


        int[][] arr2d = new int[3][3];

        for (int i=0; i<arr2d.length; i++) {
            for(int j=0; j<arr2d[i].length ; j++){
                arr2d[i][j] = 7;
            }
        }

        for(int[] Arr : arr2d){
            System.out.println(Arrays.toString(Arr));
        }

    }
}
