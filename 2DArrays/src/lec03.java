public class lec03 {
    public static void main(String[] args) {

        // Spiral order traversal in matrix
        int[][] matrix = {
                {1,2,3,10},
                {4,5,6,11},
                {7,8,9,12}
        };
       // printSpiral(matrix);


        // generate n*n spiral matrix
        generateSpiral(10);

    }

    static void generateSpiral(int n){
        int[][] matrix = new int[n][n];
        int curr = 1;
        int tr = 0 , br = n-1 , lc = 0 , rc =n-1;

        while(curr<=n*n){
            // top row = tr -> rc
            for(int j=tr ; j<=rc  && curr<=n*n;j++){
                matrix[tr][j] = curr;
                curr++;
            }
            tr++;

            // right col = tr -> rc
            for(int i = tr ; i<=rc  && curr<=n*n;i++){
                matrix[i][rc] = curr;
                curr++;
            }
            rc--;

            // bottom row = rc -> lc
            for(int j =rc ; j>=lc  && curr<=n*n; j--){
                matrix[br][j] = curr;
                curr++;
            }
            br--;

            // left col = br -> tr
            for(int i=br ;i>=tr  && curr<=n*n ; i--){
                matrix[i][lc] = curr;
                curr++;
            }
            lc++;
        }

        print(matrix);

    }

    static void printSpiral(int[][] matrix){
        int r = matrix.length;
        int c = matrix[0].length;

        int tr = 0 ,br = r-1 , lc = 0 ,rc = c-1;
        int ele = 0;
        while(ele<r*c){
            // top row -> lc to rc
                for(int j = lc ; j<=rc && ele<r*c; j++){
                    System.out.print(matrix[tr][j]+" ");
                    ele++;
                }
                tr++;

            // right col -> tr to br
            for(int i = tr ; i<=br && ele<r*c ;i++){
                System.out.print(matrix[i][rc]+" ");
                ele++;
            }
            rc--;

            // bottom row -> rc to lc
            for(int j = rc ; j>=lc && ele<r*c ;j--){
                System.out.print(matrix[br][j]+" ");
                ele++;
            }
            br--;

            // left col -> br to tr
            for(int i = br ; i>=tr ;i--){
                System.out.print(matrix[i][lc]+" ");
                ele++;
            }
            lc++;
        }

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
