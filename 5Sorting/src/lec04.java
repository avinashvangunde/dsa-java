public class lec04 {
    public static void main(String[] args) {
        // move all 0's at last of array and maintain sequence for other digits
        int[] a = {0,5,0,3,4,2};
        sort0(a);
        for(int ele : a){
            System.out.print(ele+" ");
        }

        // Given an array of fruits you are supposed to sort it in lexicographical order using selection sort
        /**
         *   i/p  ["papaya" ,"lime" ,"apples" ,"watermelon" ,"kiwi","mango"]
         *   o/p  [ "apples", "kiwi","lime" ,"mango" ,"papaya","watermelon" ]
         */
        System.out.println();;
        String[] fruits = {"papaya" ,"lime" ,"apples" ,"watermelon" ,"kiwi","mango"};
        sortFruits(fruits);
        for(String ele : fruits){
            System.out.print(ele+" ");
        }
    }

    static void sortFruits(String[] fruits){
        int n = fruits.length;
        for(int i=0 ;i<n-1 ; i++){
            int min_index = i;
            for(int j=i+1 ; j<n ; j++){
                if(fruits[j].compareTo(fruits[min_index]) < 0){
                    min_index = j;
                }
            }

            // swap min.index with i
            String temp = fruits[i];
            fruits[i] = fruits[min_index];
            fruits[min_index] = temp;
        }
    }

    static  void sort0(int[] a){
        int n = a.length;
        for(int i=0 ; i<n-1 ;i++){
            boolean flag = false;
            for(int j=0 ; j<n-i-1 ; j++){
                if(a[j]==0 && a[j+1]!=0){
                    a[j] = a[j+1];
                    a[j+1] = 0;
                    flag = true;
                }
            }
            if(flag == false)
                return;
        }
    }
}
