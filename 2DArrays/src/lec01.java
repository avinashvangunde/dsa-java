import java.util.Arrays;

/**
 *
 * Basics of 2D
 * Creation of 2dimensional arrays
 * multidimensional array
 *  multiplication of 2 matrices
 *
 */


public class lec01 {
    public static void main(String[] args) {
        // initialize 2 D
        int[][] arr = new int[4][3];  // 2D array of 4 row , 3 columns

//        int[][] a  = {{1,2,3},
//                      {4,5,6},
//                      {7,8,9}
//                     };

        // printing of 2D array
//        for(int i=0; i<a.length ;i++){
//            for(int j=0 ;j<a[i].length ;j++){
//                System.out.print(a[i][j]+" ");
//            }
//            System.out.println();
//        }


        // addition of matrices
//        int[][] A = {
//                {2,3},
//                {4,5},
//        };
//
//        int[][] B = {
//                {1,2},
//                {3,4}
//        };
//
//        matrixAddition(A,B);


        // Matrix Multiplication

        int[][] a = {{1,2,1},{3,1,2}};
        int[][] b = {{2,1},{1,3},{1,1}};
        int r1 = a.length;
        int c1 = a[0].length;

        int r2 = b.length;
        int c2 = b[0].length;
        matrixMultiply(a,b,r1,c1,r2,c2);

    }

    static void matrixMultiply(int[][] a, int[][] b,int r1,int c1,int r2,int c2 ){
        int[][] mul = new int[r1][c2];

        for(int i=0;i<r1;i++){
            for(int j=0;j<c2;j++){
                for(int k=0;k<r2;k++){
                    mul[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        for(int i=0; i<mul.length ;i++){
            for(int j=0;j<mul[i].length ;j++){
                System.out.print(mul[i][j]+" ");
            }
            System.out.println();
        }



    }


    static void matrixAddition(int[][] A,int[][] B ){
        int[][] sum = new int[A.length][A[0].length];

        for(int i=0;i<A.length ;i++){
            for(int j=0;j<A[i].length;j++){
                sum[i][j] = A[i][j]+B[i][j];
            }
        }


        for(int i=0; i<sum.length ;i++){
            for(int j=0;j<sum[i].length ;j++){
                System.out.print(sum[i][j]+" ");
            }
            System.out.println();
        }

    }
}
