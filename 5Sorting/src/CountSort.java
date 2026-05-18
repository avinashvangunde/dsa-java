public class CountSort {
    public static void main(String[] args) {
        int[] a = {4,3,5,3,7,1};
      //  basicCountSort(a);   // basic version of count sort algorithm

        // stable count sort algo using prefix sum method
        int[] b = {4,3,5,3,7,1};
        countSort(b);
    }

    static void countSort(int[] b){
        int n = b.length;
        int[] ans = new int[n];
        int max = Integer.MIN_VALUE;
        for(int ele: b){
            if(ele > max)
                max = ele;           // T.C --> n
        }

        // creating frequency array
        int[] count = new int[max+1];
        for(int i=0 ;i<n ;i++){
            count[b[i]]++;           // T.C --> n
        }

        // creating prefix sum array
        for(int i=1 ;i<count.length ;i++){
            count[i]+=count[i-1];
        }                            // T.C --> max

        for(int i=n-1 ;i>=0 ;i--){
            int pos = count[b[i]]-1;
            ans[pos] = b[i];           // T.C --> n
            count[b[i]]--;
        }
        disp(ans);

        // T.C --> n+n+max+n   = O(n+max)
    }



    static void basicCountSort(int[] a){
        // find the largest ele from the array
        int max = Integer.MIN_VALUE;
        for(int val : a){
            if(val > max)
                max = val;
        }

        // create frequency array
        int[] freq = new int[max+1];
        for(int i =0 ;i<a.length ;i++){
            freq[a[i]]++;
        }

        disp(freq);
        int k=0;
        for(int i=0 ;i<freq.length ;i++){
            for(int j=0;j<freq[i];j++){
                a[k++] = i;
            }
        }

        disp(a);
    }

    static void disp(int[] a){
        for(int ele: a){
            System.out.print(ele+" ");
        }
        System.out.println();
    }
}
