/**
 *    Transpose of matrix
 *    Rotation of matrix
 *    Pascal's triangle
 */



public class lec02 {
    public static void main(String[] args) {

        // find transpose of given matrix ** swap column with row
        //transposeMatrix();

        // transpose matrix  inplace
        //transposeInPlace();

        // rotate a given square matrix by 90 degree
        // rotateBy90();

         // Pascal's triangle
        Pascal(7);

    }

    static void Pascal(int n){
        int[][] pas = new int[n][];

        for(int i=0 ;i<pas.length ;i++){
            // ith row has i+1 columns

            pas[i] = new int[i+1];

            // every rows first and last ele is 1
            pas[i][0] = pas[i][i] = 1;

            for(int j = 1 ;j<i ; j++){
                pas[i][j] = pas[i-1][j] + pas[i-1][j-1];
            }
        }

        print(pas);

    }

    static void rotateBy90(){
        int[][] arr = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        print(arr);

        for(int i=0 ;i<arr[0].length ;i++){
            for(int j=i ;j<arr.length ;j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        System.out.println("AT");
        print(arr);

        for(int i=0; i<arr.length ;i++){
            revArray(arr[i]);
        }

        System.out.println("AR");
        print(arr);
    }


    static void revArray(int[] a){
        for(int i=0,j=a.length-1 ; i<j ;i++ ,j--){
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    static void transposeInPlace(){
        int[][] arr = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };


        print(arr);
        for(int i =0; i<arr[0].length ; i++){
            for(int j=i ; j<arr.length ; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        System.out.println();
        print(arr);

    }

    static void transposeMatrix(){
//        int[][] arr = {
//                {1,2,3},
//                {4,5,6},
//                {7,8,9}
//        };

        int[][] arr = {{2,1},
                       {1,3},
                       {1,1}};
        int[][] transpose = new int[arr[0].length][arr.length];    // [ cXr ]

        for(int i=0; i<arr[0].length ;i++){
            for(int j=0; j<arr.length ;j++){
                transpose[i][j] = arr[j][i];
            }
        }
        print(arr);
        System.out.println();
        print(transpose);
    }

    static void print(int[][] a){
        for(int i=0 ;i<a.length ;i++){
            for(int j=0 ; j<a[i].length;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }

}
