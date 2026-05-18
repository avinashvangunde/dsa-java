public class lec04 {
    public static void main(String[] args) {

        int[][] matrix ={
                {1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1},
        };

        // rectangle sum in 2D array brute force approach
        int l1 = 3 ,r1 = 1, l2 = 5 ,r2 =4;
       // rectangleSum(matrix,l1,r1,l2,r2);

        // rectangle sum using prefix sum on rows in matrix
        //rectangleSumPrefix(matrix,l1,r1,l2,r2);


        // best approach --> prefix sum over column and row both
        rectangleSumBestCase(matrix,l1,r1,l2,r2);
    }

    static void rectangleSumBestCase(int[][] matrix,int l1,int r1,int l2,int r2){
        // best approach where matrix prefix sum will be calculated on row and then on column also
        matrixPrefix(matrix);
        matrixPrefixCol(matrix);

        int sum = 0 ,up =0, left =0 , upleft =0;
        if(l1>=1)
            up = matrix[l1-1][r2];
        if(r1>=1)
            left =matrix[l2][r1-1];
        if(l1>=1 && r1>=1)
            upleft = matrix[l1-1][r1-1];

        sum = matrix[l2][r2] - up - left + upleft;
        System.out.println("\n"+sum);
    }


    static void rectangleSumPrefix(int[][] matrix,int l1,int r1,int l2,int r2){
        matrixPrefix(matrix);
        int sum = 0;
        for(int i=l1 ; i<=l2 ;i++){
            if(r1>=1)
                sum+= matrix[i][r2] - matrix[i][r1-1];
            else
                sum+= matrix[i][r2];
        }
        // we can eliminate  this for loop also
        System.out.println(sum);
    }

    static void matrixPrefix(int[][] matrix){
        print(matrix);
        System.out.println();
        for(int i=0; i<matrix.length ;i++){
            for(int j=1 ; j<matrix[0].length ;j++){
                matrix[i][j] += matrix[i][j-1];
            }
        }
        print(matrix);

    }

    static void matrixPrefixCol(int[][] matrix){

        for(int j=0 ;j<matrix[0].length ;j++){
            for(int i=1; i<matrix.length ;i++){
                matrix[i][j]+= matrix[i-1][j];
            }
        }

        System.out.println();
        print(matrix);

    }

    static void rectangleSum(int[][] matrix,int l1,int r1,int l2,int r2){
        // brute force approach
        /**
         *   worst case the dimensions can be l1 = 0 , r1 =0 and l2 = n-1 , r2 = m-1
         *   time complexity is n*m
         */


        int sum = 0;
        for(int i = l1 ; i<=l2 ;i++){
            for(int j = r1 ; j<=r2 ;j++){
                sum+= matrix[i][j];
            }
        }
        System.out.println(sum);
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
