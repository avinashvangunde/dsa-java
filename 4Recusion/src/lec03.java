public class lec03 {
    public static void main(String[] args) {
        // sum of digits for given 'n'
        //System.out.println(sumOfDigit(1234));

        // count no of digits
       // System.out.println(cntDigtits(543));


        // find pow of p^q
        System.out.println(pow(2,3));

        // better approach for p^q
        /**
         *   relation
         *   p^q =  p^q/2 * p^q/2      for q even
         *   p^q =  p^q/2 * p^q/2 * p  for q odd
         */

        System.out.println(power(2,4));
    }

    static int power(int p, int q){
        if(q==0){
            return 1;
        }

        int ans = power(p,q/2);
        if(q%2==0){  // q is even
            return ans * ans;
        }else{  // q is odd
            return ans * ans * p;
        }
    }

    static int pow(int p , int q){
        if(q==0){
            return 1;
        }

        return pow(p,q-1)*p;
    }


    static int cntDigtits(int n){
        if(n==0){
            return 0;
        }

        return cntDigtits(n/10)+1;
    }

    static int sumOfDigit(int n){
        if(n>=0 && n<=9){          // if(n == 0)  --> return 0;
            return n;
        }

       return sumOfDigit(n/10) + n%10;
    }
}
