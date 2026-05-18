import java.util.Arrays;
import java.util.Stack;

/**
 *  Leetcode Questions on stacks
 */

public class lec01 {
    public static int[] removeSeq(int[] a){
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<a.length; i++){
            if(st.size() == 0){
                st.push(a[i]);
            }else{
                if(st.peek() == a[i]){
                    if(a[i] != a[i+1]){
                        st.pop();
                    }
                }else{
                    st.push(a[i]);
                }
            }
        }

        int[] res = new int[st.size()];
        for(int i=res.length-1 ; i>=0 ;i--){
            res[i] = st.pop();
        }

        return res;
    }


    public static boolean checkBalanced(String str){
        Stack<Character> st = new Stack<>();

        for(char ch : str.toCharArray()){
            if(ch == '('){
                st.push(ch);
            }else {
                if(st.size()>0 && st.peek() == '(' )
                    st.pop();
                else if(st.size() == 0)
                    return false;
            }
        }

        return st.isEmpty();
    }

    public static int[] ngele(int[] arr){
        Stack<Integer> st = new Stack<>();
        int n =arr.length;
        int[] res = new int[n];
        res[n-1] = -1; // last ele is always -1
        st.push(arr[n-1]);

        for(int i=n-2 ;i>=0 ;i--){
            while(st.size()>0 && st.peek()<arr[i])
                st.pop();

            if(st.size() == 0)
                res[i] = -1;  // the number has no next greater ele
            else
                res[i] = st.peek();

            st.push(arr[i]);
        }
        return res;
    }

    public static int[] findStockSpans(int []prices) {
        Stack<Integer> st = new Stack<>();
        int n = prices.length;
        int[] ans = new int[n];
        ans[0] = 1;
        st.push(0);

        for(int i=1; i<n ;i++){
            while(st.size()>0 && prices[i] > prices[st.peek()])
                st.pop();
            if(st.size()>0)
                ans[i] = i - st.peek();
            else
                ans[i] = i+1;
            st.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        // check if brackets is balanced or not
        String str = "(())())";
        System.out.println(checkBalanced(str));


        // Remove Consecutive Subsequences
        int[] a = {1,2,2,3,3,10,10,10,4,4,4,5,7,7,2};
        int[] res = removeSeq(a);
        System.out.println(Arrays.toString(res));

        // next greater element
        int[] arr = {1,3,2,1,8,6,3,4};

        // solved using arrays  --> T.C. == O(n^2)
        int[] ans =  new int[arr.length];

        for(int i=0 ;i< arr.length ;i++){
            ans[i] = -1;
            for(int j=i+1 ;j< arr.length; j++){
                if(arr[j] > arr[i]) {
                    ans[i] = arr[j];
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(ans));


        // Using stacks  --> T.C == O(n)
        int[] result = ngele(arr);
        System.out.println(Arrays.toString(result));


        // stock span
        int[] a1 = {2, 1, 2, 4};
        int[] output = findStockSpans(a1);
        System.out.println(Arrays.toString(output));
    }
}
