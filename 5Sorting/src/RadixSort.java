public class RadixSort  {
    public static void main(String[] args) {
       // radix - count sort algorithm
        int[] a = {170,45,75,40,2,820};
        radixSort(a);
    }


    static void radixSort(int[] a){
        int max = findMax(a);       // TC --> O(n)
        disp(a);
        for(int place = 1; max/place > 0 ; place*=10){   // loop for no of digits
            countSort( a,place);    // TC --> O(n+k) --> O(n+10) ~~ O(n)
        }
        disp(a);
        // TC --> n+dn --> O(dn)  : where d is max number of digits
        // SC --> O(n+10) --> O(n) // n for ans array and 10 for countArray
    }

    static void countSort(int[] a,int place){
        int[] count = new int[10];
        int[] ans = new int[a.length];

        // create frequency array
        for(int i=0 ; i<a.length ;i++){
            count[(a[i]/place)%10]++;         //  (a[i]/place)%10 --> to get units. tens and hundred th placed value
        }

        // finding prefix sum
        for(int i=1;i<count.length ;i++){
            count[i]+=count[i-1];
        }


        for(int i=a.length-1; i>=0 ;i--){
            int pos = count[(a[i]/place)%10] - 1;
            ans[pos] = a[i];
            count[(a[i]/place)%10]--;
        }

        for(int i=0; i<a.length ;i++){
            a[i] = ans[i];
        }

    }


    static int findMax(int[] a){
        int max = Integer.MAX_VALUE;
        for (int ele: a){
            if(ele > max)
                max = ele;
        }
        return max;
    }

    static void disp(int[] a){
        for(int ele : a){
            System.out.print(ele+" ");
        }
        System.out.println();
    }
}
