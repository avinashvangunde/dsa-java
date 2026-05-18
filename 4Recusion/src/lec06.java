/**
 *   Recursion with arrays
 */


public class lec06 {
    public static void main(String[] args) {
        // given an array print all its values recursively
         int[] a = {5,6,3,2,1};
         //printArray(a,0);

        // print max value of array
        //System.out.println(maxArr(a,0));


        // print sum of array
        System.out.println(sumArr(a,0));
    }

    static int sumArr(int[] a , int i){
//        if(i == a.length-1){   // this base case cannot avoid empty array case
//            return a[i];
//        }

        if(i == a.length){
            return 0;
        }

        return a[i]+ sumArr(a,i+1);
    }

    static int maxArr(int[] a, int i){
        if(i == a.length-1){
            return a[i];
        }

        return Math.max(a[i],maxArr(a,i+1));
    }


    static void printArray(int[] a , int idx){
        if(idx == a.length){
            return;
        }
        System.out.print(a[idx]+" ");
        printArray(a,idx+1);
    }
}
