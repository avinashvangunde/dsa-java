import java.util.ArrayList;

public class lec07 {
    public static void main(String[] args) {
        // linear search using recursion
        int[] a = {5,6,4,12,34,3};
        //System.out.println(search(a,0,12));

        // return all the indices with the given target value with extra space
        int[] arr = {5,6,4,2,4,4};
        ArrayList list = new ArrayList<>();
        findAllIndex(arr,0,4,list);
        System.out.println(list);

        // return all the indices with the given target value with extra space
        ArrayList lst = findAllIndexOp1(arr,0,4);
        System.out.println(list);


        // return all the indices with the given target value without extra space
        findAllIndexOp(arr,0,4);

    }

    static ArrayList<Integer> findAllIndexOp1(int[] a , int idx , int target){
        ArrayList<Integer> ans = new ArrayList<>();
        if(idx == a.length){
            return ans;
        }

        if(a[idx] == target){
            ans.add(idx);
        }

        ArrayList<Integer> sub = findAllIndexOp1(a,idx+1 ,target);
        ans.addAll(sub);
        return ans;
    }


    static void findAllIndexOp(int arr[] ,int idx , int target){
        if(idx == arr.length){
            return;
        }

        if(arr[idx] == target){
            System.out.print(idx+" ");
        }

         findAllIndexOp(arr,idx+1 , target);
    }

    static int findAllIndex(int arr[] ,int idx , int target ,ArrayList list ){
        if(idx == arr.length){
            return -1;
        }

        if(arr[idx] == target){
            list.add(idx);
        }

        return findAllIndex(arr,idx+1 , target ,list);
    }

    static boolean search(int[] a ,int i,int x){
        if(i == a.length){
            return false;
        }

        if(a[i] == x){
            return true;
        }

        return search(a,i+1,x);
    }
}
