public class lec04 {
    public static void main(String[] args) {
        // print k multiples of num
        //mul(5,3 );


        // series sum for  given n
        //System.out.println(seriesSum(5)) ;

        // alternating series for given n
        System.out.println(alternatingSeries(10));
    }

    static int alternatingSeries(int n){
        if(n == 0){
            return 0;
        }
        if(n%2 == 0){
            return alternatingSeries(n-1)-n;
        }else{
            return alternatingSeries(n-1)+n;
        }
    }

    static int seriesSum(int n){
        if(n == 0){
            return 0;
        }
        return seriesSum(n-1)+n;
    }

    static void mul(int num , int k){
        if(k == 1){  // base work
            System.out.println(num);
            return;
        }

        // recursive work
        mul(num , k-1 );

        // self work
        System.out.println(num*k+" ");
    }


}
