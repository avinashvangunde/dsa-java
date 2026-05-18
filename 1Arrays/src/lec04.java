import java.util.Arrays;

public class lec04 {
    public static void main(String[] args) {

        // for given array find prefix sum
        //prefixSum();

        // space optimized
        //prefixSumOp();

        // queries to print sum of values from l to r
        int l = 3;
        int r = 5;
        //printSum(l,r);

        // check if subarray is possible to form via prefix sum and suffix sum approach
        checkSum();
    }


    static void checkSum(){
        //int[] arr = {5,3,2,6,3,1};
        int[] arr = {1,3,2,4,5};
        int[] pref = new int[arr.length];
        int[] suff = new int[arr.length];
        int n = arr.length;
        pref[0] = arr[0];
        for(int i=1; i< arr.length ;i++){
            pref[i] = pref[i-1] +arr[i];
        }

        suff[n-1] = arr[n-1];
        for(int i = n-2 ; i>=0 ; i--){
            suff[i] = suff[i+1]+arr[i];
        }

        System.out.println(Arrays.toString(pref));
        System.out.println(Arrays.toString(suff));
        int ans=0;
        for(int i=0 ;i<arr.length-1 ;i++){
            if(pref[i]==suff[i+1]) {
                System.out.println("TRUE");
                ans=1;
                break;
            }
        }

        if(ans==0)
            System.out.println("FALSE");

    }

    static void printSum(int l ,int r){
        int[] arr  = {0,2,4,1,3,6,5};
        int[] pref = new int[arr.length];
        pref[1] = arr[1];

        for(int i=2 ;i<arr.length ; i++){
            pref[i] = pref[i-1]+arr[i];
        }

        int sum = pref[r]-pref[l-1];
        System.out.println(sum);
    }


    static void prefixSumOp(){
        int[] a = {2,1,3,4,5};

        if(a.length>1) {
            for (int i = 1; i < a.length; i++) {
                a[i] = a[i-1] + a[i];   // a[i]+= a[i-1]
            }
        }
        System.out.println(Arrays.toString(a));
    }

    static void prefixSum(){
        int[] a = {2,1,3,4,5};
        int[] pref = new int[a.length];
        pref[0] = a[0];

        if(a.length>1) {
            for (int i = 1; i < a.length; i++) {
                pref[i] = pref[i-1] + a[i];
            }
        }

        System.out.println(Arrays.toString(pref));
    }
}
