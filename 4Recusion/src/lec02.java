public class lec02 {
    public static void main(String[] args) {
        // find factorial of n
        // System.out.println(fact(4));

        // find n th term in fibonacci series
        System.out.println(fibonacci(6));
    }

    static int fibonacci(int n){
        if(n==1){
            return 1;
        }
        if(n==0){
            return 0;
        }

        return fibonacci(n-1)+fibonacci(n-2);
    }

    static int fact(int n){
        if(n==1) {
            return 1;
        }
        return n*fact(n-1);
    }

}
