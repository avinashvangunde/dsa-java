
public class Lambda {
    public static void hello(){
         System.out.println("Hello World");
    }


    public static void main(String[] args) {
        hello();
        Runnable helloWorld = () -> {
            System.out.println("Hello Lambda");
        };
    }
}