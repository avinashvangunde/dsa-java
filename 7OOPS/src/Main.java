import OOPS.Student;

import java.util.Arrays;

public class Main {

    public static void mod(int x){
         x = 7;
    }

    public static void modArr(int[] a){
        a[2] = 3;
    }

    public static void main(String[] args) {
        Student s1  = new Student();
        s1.name = "Avinash";
        s1.setRno(1);
        System.out.println(s1.getRno());
        s1.percent = 91.2;
        System.out.println(s1.school);

        Student s2  = new Student();
        s2.name = "Klassen";
        s2.setRno(2);
        System.out.println(s2.getRno());
        s2.percent = 45.2;
        System.out.println(s2);
        System.out.println();


        // pass by value
        int x =5;
        System.out.println(x);
        mod(x);
        System.out.println(x);


        // pass by ref
        int[] a = {1,2,4,4};
        System.out.println(Arrays.toString(a));
        modArr(a);   // we pass reference to array
        System.out.println(Arrays.toString(a));



    }
}