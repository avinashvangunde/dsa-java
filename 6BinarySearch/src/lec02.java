/**
 *   Binary Search Problems -->
 *          Pattern : Searching in  Rotated sorted array
 *
 */
public class lec02 {
    public static void main(String[] args) {
        // Pattern Searching in Rotated sorted array

        // Quest1 :find index of min on rotated sorted array
        int[] a= {10,11,12,1,2,3,4,5,6,7,8,9 };
        System.out.println(findMinIdx(a));

        // Quest2: find target in rotated sorted array
        System.out.println(findTarget(a,
                5));

        // Quest3: search ele in rotated sorted array and return true / false  // duplicate elements are present
        int[] b= {1,1,1,1,2,2,3,1,1};
        System.out.println(findTargetDup(b,2));
    }

    static boolean findTargetDup(int[] a, int x){
        int st=0, end = a.length-1;

        while(st<=end){
            int  mid = st+(end-st)/2;


            if(a[mid] == x ){
                return true;
            }else if(a[st]==a[mid] && a[mid]==a[end]){
                st++;
                end--;
            } else if (a[mid] <= a[end]){  // mid -> end is sorted
                if(x > a[mid] && x<=a[end])
                    st = mid + 1;
                else              // target is in first half part
                    end = mid-1;
            } else if (a[st] > a[mid]){  // st -> mid is sorted
                if(x>=a[st] && x<a[mid])
                    end = mid-1;
                else
                    st = mid+1;   // target is in seconf half part
            }
        }
        return false;
    }

    static int findTarget(int[] a,int x){
        int st=0, end = a.length-1;

        while(st<=end){
            int  mid = st+(end-st)/2;

            if(a[mid] == x ){
                return mid;
            } else if (a[mid] < a[end]){  // mid -> end is sorted
                if(x > a[mid] && x<=a[end])
                    st = mid + 1;
                else              // target is in first half part
                    end = mid-1;
            } else if (a[st] > a[mid]){  // st -> mid is sorted
                if(x>=a[st] && x<a[mid])
                    end = mid-1;
                else
                    st = mid+1;   // target is in seconf half part
            }
        }
        return -1;
    }


    static int findMinIdx(int[] a){
        int st = 0 ,end = a.length-1 ,ans = -1;

        while(st<=end){
            int mid = st+(end-st)/2;

            if(a[mid]>a[end]){
                st = mid+1;
            }else{   // a[mid] <= a[end]
                ans = mid;
                end = mid-1;
            }
        }
        return ans;
    }
}
