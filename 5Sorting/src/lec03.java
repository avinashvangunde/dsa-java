/**
 *  Insertion sort algorithm
 */
public class lec03 {
    public static void main(String[] args) {
        // Insertion sort
         int[] a = {8,3,6,2,4,5};
         insertionSort(a);
         for (int ele: a){
             System.out.print(ele+" ");
         }
    }

    static void insertionSort(int[] a){
        int n = a.length;
        for(int i=1; i<n ;i++){
           for(int j=i; j>0 ;j--){
               if(a[j] < a[j-1]){
                   int temp = a[j];
                   a[j] = a[j-1];
                   a[j-1] = temp;
               }
           }
        }
    }
}
