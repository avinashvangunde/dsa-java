import java.util.ArrayList;
import java.util.List;

/**
 *
 *   Target Sum Arrays
 *
**/

public class lec01 {

    public static void main(String[] args) {

        // int[] arr = {4,6,3,5,8,2,6,3,5,8};
        // targetSum(arr,7);  // target two sum

        // tripletSum(new int[]{1,4,5,6,3} ,12);  //triplet sum


        // find second max
//        int[] arr = {5,4,1,6,2};
//        int max = findMax(arr);
//        for(int i=0;i<arr.length ;i++){
//            if(arr[i]==max){
//                arr[i] = Integer.MIN_VALUE;
//            }
//        }
//        System.out.println("Second max value is : "+findMax(arr));



        // find Unique from a array not repeating twice
       //  findUnique(arr);


        // find first repeating number
         int[] arr = {4,6,3,5,3,2,1};
        System.out.println(findFirstRepeat(arr));

    }


    static int findFirstRepeat(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1 ; j<arr.length;j++){
                if(arr[i]==arr[j]){
                    return arr[i];
                }
            }
        }
        return -1;
    }

    static void findUnique(int[] arr){
        for(int i=0 ;i<arr.length ;i++){
            for(int j=i+1; j<arr.length;j++){
                if(arr[i]==arr[j]){
                   arr[i]=-1;
                   arr[j]=-1;
                }
            }
        }
        for(int ele:arr){
            if(ele!=-1){
                System.out.print(ele+" ");
            }
        }
    }

    static void targetSum(int[] arr, int target) {
        int ans = 0;
        List<Integer> lst = new ArrayList<>();
        for(int i=0; i<arr.length ;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]+arr[j]==target){
                    lst.add(arr[i]);
                    lst.add(arr[j]);
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }




    static void tripletSum(int[] arr, int target) {
        int ans = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                for(int k=j+1;k<arr.length;k++) {
                    if (arr[i]+arr[j]+arr[k]==target){
                        System.out.println(arr[i]+" "+arr[j]+" "+arr[k]);
                        ans++;
                    }
                }
            }
        }

        System.out.println(ans);
    }





    private static int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int j : arr) {
            if (j > max) {
                max  = j;
            }
        }
        return max;
    }


}