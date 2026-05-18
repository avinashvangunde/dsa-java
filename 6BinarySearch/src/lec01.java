/**
 *   Binary Search Algorithm
 *
 */

public class lec01 {
    public static void main(String[] args) {
        // Binary search code
        int[] a ={2,4,5,6,15, 20,24,45,50,77};
//        System.out.println(binarySearchItr(a,45));                          // iterative code
//        System.out.println(binarySearchRec(a,45,0,a.length-1));     // using recursion

        // Quest1: find first occurrence of x in sorted arr
        int[] b = {2,5,5,5,6,7,7,8};
        //System.out.println(quest1(b,5));

        // Quest 2: find square root of x , round it off to nearest floor --> x =24  ans = 4
        System.out.println(quest2(24));
    }

    static int quest2(int x){
        int ans = -1;
        int st = 0 ,end = x;
        while (st<=end){
            int mid = st+(end-st)/2;
            int val = mid * mid;

            if(val == x){
                return mid;
            }else if(val > x){
                end = mid-1;
            }else {
                st = mid+1;
                ans = mid;
            }
        }
        return ans;
    }

    static int quest1(int[] a,int x){
        int st = 0 ,end =a.length-1;
        int fo = -1;  // first occurrence
        while (st<=end){
            int mid = st+(end-st)/2;
            if(a[mid] == x){
                fo = mid;
                end = mid-1;
            }else if(a[mid]>x){
                end = mid-1;
            }else{
                st = mid+1;
            }
        }
        return fo;
    }

    static boolean binarySearchRec(int[] a, int target , int st ,int end){
        if(st>end){
            return false;
        }

        int mid = (st+end)/2;
        if(a[mid] == target)
             return true;
        else if(a[mid] > target)
            return binarySearchRec(a,target,st,mid-1);
        else
            return binarySearchRec(a,target,mid+1,end);
    }

    static boolean binarySearchItr(int[] a,int target){
        int n = a.length;
        int st = 0 , end = n-1;

        while(st <= end){
            int mid = st+(end-st)/2;
            if(target == a[mid])
                return true;

            if(target > a[mid]){
                st = mid+1;
            }else if(target < a[mid]){
                end = mid-1;
            }
        }
        return false;
    }
}
