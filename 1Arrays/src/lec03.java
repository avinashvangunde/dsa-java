import java.util.Arrays;

public class lec03 {

    public static void main(String[] args) {

        // sort array  of 0's and 1's
        // sortArray();

        // two pointer method
        // sortTwoPointer();

         // sort array based on odd and even
        // sortOddEven();

        // given an array return squares of values in array
        squaresArray();

    }

    static void squaresArray(){
        int[] arr = {-10, -3,-2 , 1, 4 ,5};
        int[] ans = new int[arr.length];
        System.out.println(Arrays.toString(arr));

        int left = 0;
        int right = arr.length-1;
        int i = right;

        while(left<=right){
            if(Math.abs(arr[left]*arr[left]) > Math.abs(arr[right]*arr[right])){
                ans[i] = arr[left]*arr[left];
                i--;
                left++;
            }else{
                ans[i] = arr[right]*arr[right];
                i--;
                right--;
            }
        }

        System.out.println(Arrays.toString(ans));

    }



    static void sortOddEven(){
        int[] arr = {1,4,2,3,5,6,9};
        System.out.println(Arrays.toString(arr));

        int left = 0;
        int right = arr.length-1;
        while(left<right){

            if(arr[left]%2==1 && arr[right]%2==0 ){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }

            if(arr[left]%2==0){
                left++;
            }
            if(arr[right]%2==1){
                right--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    static void sortTwoPointer(){
        int[] arr = {1,0,1,1,0,0,1,0};
        System.out.println(Arrays.toString(arr));

        int left = 0;
        int right = arr.length-1;
        while(left<right){
            if(arr[left] == 1 && arr[right]==0){
                arr[left] = 0;
                arr[right] = 1;
                left++;
                right--;
            }else {
                left++;
                right--;
            }
        }
        System.out.println(Arrays.toString(arr));

    }


    static void sortArray(){
        int[] arr = {1,0,1,1,0,0,1,0};
        System.out.println(Arrays.toString(arr));
        int cnt=0;
        for(int ele : arr){
            if(ele==0){
                cnt++;
            }
        }


        for(int i =0 ; i<arr.length ;i++){
            if(i<cnt){
                arr[i] = 0;
            }else{
                arr[i] = 1;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
