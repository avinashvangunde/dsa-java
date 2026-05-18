import java.util.Arrays;
import java.util.Scanner;

public class lec02 {
    public static void main(String[] args) {
        //swap(1,2); // swapping with temp

        // swapping without temp
        //swapWOTemp(3,5);

        // reverse an array
        //int[] arr = {1,2,3,4,5};
        //reverse(arr); // extra space
        //reverseOptimized(arr); // np extra space

        // rotate an array 'k' times
//        int[] arr = {1,2,3,4,5,6,7};
//        int k = 4;
        // int[] ans = rotate(arr,k,arr.length);
        //System.out.println(Arrays.toString(ans));

//        int[] ans = rotateOP(arr,k,arr.length); // optimised approach for k steps rotation of array
//        System.out.println(Arrays.toString(ans));


        // frequency array
        int[] arr = {1,256,3433,4223,3455,6664,7633};
        int[] fq = createFrequencyArr(arr);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of queries: ");
        int query = sc.nextInt();
        while(query>0) {
            System.out.println("Enter query number: ");
            int n = sc.nextInt();
            if (fq[n] > 0) {
                System.out.println("YES");
            } else
                System.out.println("NO");
            query--;
        }

    }

    static int[] createFrequencyArr(int[] arr){
        int[] fq = new int[100005];
        for(int i=0 ;i<arr.length ;i++){
            fq[arr[i]]++;
        }
        return fq;
    }

    static int[] rotateOP(int[] arr , int k ,int n){
        k = k%n;
        rev(arr, 0 ,n-k-1);
        rev(arr,n-k,n-1);
        rev(arr,0,n-1);

        return arr;
    }

    static void rev(int[] arr, int st ,int end){
        for(int i=st,j=end ; i<j ;i++ ,j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }


    static int[] rotate(int[] arr, int k , int n){
        int[] ans = new int[n];
        k = k%n;
        int j =0 ;
        for(int i = n-k ; i<n ;i++ ,j++) {
            ans[j] = arr[i];
        }

        for(int i=0 ;i<n-k ; i++,j++){
            ans[j] = arr[i];
        }

        return ans;
    }

    static void reverse(int[] arr){
        int[] ans = new int[arr.length];
        for(int i=0 ,j =arr.length-1 ; i<arr.length ;i++ ,j--){
            ans[i] = arr[j];
        }
        for(int ele : ans){
            System.out.print(ele+" ");
        }
    }

    static void reverseOptimized(int[] arr){
        for(int i=0, j=arr.length-1 ;i<arr.length/2 ;i++,j--){
            int temp  = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        for(int ele: arr){
            System.out.print(ele+" ");
        }
    }

    static void swap(int a ,int b){
        int temp;
       // System.out.println(a+" , " +b);
        temp = a;
        a = b;
        b = temp;
       // System.out.println(a+" , " +b);
    }

    static void swapWOTemp(int a, int b){
        System.out.println(a+" , " +b);
        a = a+b;
        b = a-b;
        a = a-b;
        System.out.println(a+" , " +b);
    }
}
