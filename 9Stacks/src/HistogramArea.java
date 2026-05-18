import java.util.Stack;

public class HistogramArea {

    // next smaller element
    public static int[] nse(int[] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] nse = new int[n];
        nse[n-1] = n;
        st.push(n-1);
        for(int i=n-2; i>=0 ;i--){
            while(st.size()>0 && arr[st.peek()] >= arr[i])
                st.pop();

            if(st.size()==0)
                nse[i] = n;
            else
                nse[i] = st.peek();

            st.push(i);
        }
        return nse;
    }


    // prev smaller element
    public static int[] pse(int[] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] pse = new int[n];
        pse[0] = -1;
        st.push(0);
        for(int i=1; i<n ;i++){
            while(st.size()>0 && arr[st.peek()] >= arr[i])
                st.pop();

            if(st.size()==0)
                pse[i] = -1;
            else
                pse[i] = st.peek();

            st.push(i);
        }
        return pse;
    }


    public static void main(String[] args) {
        /**
         *  largest Rectangle Area
         */

        int[] heights = {1, 1};
        int[] nse = nse(heights);
        int[] pse = pse(heights);
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int area = heights[i] * (nse[i] - pse[i] - 1);
            if (area > maxArea)
                maxArea = area;
        }
        System.out.println(maxArea);
    }
}
