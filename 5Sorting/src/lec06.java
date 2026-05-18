/**
 *   Quick Sort Algorithm
 */
public class lec06 {
    public static void main(String[] args) {
        // quick sort code
        int[] a = {7,13,8,5,10,2,4};
        quickSort(a,0,a.length-1);
        for (int ele:a){
            System.out.print(ele+" ");
        }
    }

    static void quickSort(int[] a,int st ,int end){
        if(st >= end){
            return;
        }
        int pivotIndex = partition(a,st,end);
        quickSort(a,st,pivotIndex-1);
        quickSort(a,pivotIndex+1,end);
    }

    static int partition(int[] a,int st,int end){
        int pivot = a[st];
        int eleLTPv = 0;
        for(int i=st+1; i<=end; i++){
            if(a[i]<=pivot)
                eleLTPv++;
        }

        int pivotIndex =  st + eleLTPv;
        swap(a,st,pivotIndex);

        // elements less than pivot shifts to left of pivot && elements greater than pivot shifts to right of pivot
        int i = st , j=end;
        while(i<pivotIndex && j>pivotIndex){
            while(a[i]<=pivot)
                i++;

            while ((a[j]>pivot))
                j--;
            if(i<pivotIndex && j>pivotIndex){
                swap(a,i,j);
                i++;j--;
            }
        }
        return pivotIndex;
    }

    static void swap(int[] arr,int i ,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
