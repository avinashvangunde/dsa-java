/**
 *  Selection sort algorithm
 *
 */
public class lec02 {
    public static void main(String[] args) {
        // selection sort code
        int[] a = {5,4,2,3,7,1};
        selectionSort(a);
        for(int ele : a){
            System.out.print(ele+" ");
        }
    }

    static void selectionSort(int[] a){
        int n = a.length;
        for(int i=0 ; i<n-1 ;i++){
            int min_index = i;
            for(int j=i+1; j<n ;j++){
                if(a[j] < a[min_index]){
                    min_index = j;
                }
            }
            // swap min.index with i
            int temp = a[i];
            a[i] = a[min_index];
            a[min_index] = temp;
        }
    }
}
