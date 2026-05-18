/**
 *  Bubble sort algorithm
 *  TC = 0(n^2)   SC = 0(1) inplace algorithm
 */

public class lec01 {
    public static void main(String[] args) {
      // bubble sort
        int[] a = {5,4,6,7,2,1};
        bubbleSort(a);

        // optimised bubble sort for nearly sorted array
        System.out.println();
        int[] arr = {2,1,3,4,5};
        bubbleSortOp(arr);
        for(int ele : arr){
            System.out.print(ele+" ");
        }
    }


    static void bubbleSortOp(int[] a){
        int n = a.length;
        for(int i=0 ;i<n-1 ; i++){
            boolean flag = false;
            for(int j=0 ;j<n-i-1 ;j++){
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = true;
                }
            }
            if(flag == false){
                return;
            }
        }
    }

    static void bubbleSort(int[] a){
        int n = a.length;
        for(int i=0 ; i<n-1 ; i++){
            for(int j=0 ; j<n-i-1 ;j++){
                if(a[j] > a[j+1]){      // swap adjacent ele
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }

        for(int ele : a){
            System.out.print(ele+" ");
        }
    }
}
