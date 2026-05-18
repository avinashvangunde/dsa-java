public class lec05 {
    public static void main(String[] args) {
        // gcd using iterative method
        gdcBruteForce(15,9);

        // gcd
        igcd(15,9);

        // using recursion
        System.out.println(gcd(15,9));

    }

    static int gcd(int x , int y){
        if(y==0){
            return x;
        }

        return gcd(y,x%y);
    }

    static void igcd(int x ,int y){
        while(x%y!= 0) {
            int rem = x%y ;
            x = y;
            y = rem;
        }
        System.out.println(y);
    }

    static void gdcBruteForce(int x,int y){
        int n = Integer.min(x,y);

        for(int i= n ; n>=1 ; n--){
            if(x%n==0 && y%n ==0){
                System.out.println("GCD is: "+n);
                break;
            }
        }
    }
}
