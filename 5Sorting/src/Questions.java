/**
 *  problems based on Sorting
 */

public class Questions {
    public static void main(String[] args) {
         // Quest 1: Given an array all ele are sorted except two are swapped from its position
        int[] a = {3,8,5,6,7,9,10};
        quest1(a);
        //disp(a);

        // Quest 2: Separate an array of negative and positive numbers in linear time with constant space
        int[] b = {19,-20,7,-4,-13,11,-5,3};
        quest2(b);
        //disp(b);

        // Quest 3: Given an arr of only 0,1,2 sort the arr in ascending order
        int[] c = {0,2,1,2,0,0};
        ques3(c);
        disp(c);

    }

    static void ques3(int[] a){
        int lo =0, hi =a.length-1 ,mid= 0;

        while(mid<=hi){
            if(a[mid] == 0){
                swap(a,mid,lo);
                lo++; mid++;
            }else if(a[mid] == 1)
                mid++;
            else{
                swap(a, mid, hi);
                hi--;
            }
        }
    }


    static void quest2(int[] a){

        int l = 0;
        int r = a.length-1;
        while(l<=r){
            if(a[l]>0 && a[r]<0){
                swap(a,l,r);
                l++;r--;
            }

            if(a[l]<0)
                l++;

            if(a[r]>0)
                r--;
        }
    }

    static void swap(int[] a,int i ,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static void quest1(int[] a){
        int x = -1;
        int y = -1;

        for(int i=1 ;i<a.length ;i++){
            if(a[i] < a[i-1]){
                if(x==-1) {
                    x = i - 1;   // first dip
                    y = i;       // {3,8,5,6,7,9,10};   8,5 are adjacent
                }
                else
                    y = i;     // second dip
            }
        }

        swap(a,x,y);
    }

    static void disp(int[] a){
        for(int ele: a){
            System.out.print(ele+" ");
        }
        System.out.println();
    }
}
