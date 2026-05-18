
public class StringBuilderBasics {

    public  static Boolean isPalindrome(String s){

        boolean flag = true;
        for(int i=0 ,j=s.length()-1 ; i<j ;i++,j--){
            char ith = s.charAt(i);
            char jth = s.charAt(j);
            if(ith != jth) {
                flag = false;
                break;
            }
        }

        return flag;
    }

    public static void main(String[] args) {
        // to make strings mutable and improve performance of strings
        StringBuilder str = new StringBuilder("Avinash");
        str.append(" Vangunde");
        System.out.println(str);
        str.setCharAt(0,'a');
        System.out.println(str);

        // insert(idx ,ch)
        StringBuilder str1 = new StringBuilder("hello");
        str1.insert(2,'y');
        System.out.println(str1);

        // deleteCharAt(idx)
        str1.deleteCharAt(2);
        System.out.println(str1);

        // reverse
        System.out.println(str.reverse());

        // Questions

        // toggle all character from string upper to lower and vice versa   ,, avINasH --> AVinASh
        StringBuilder sb = new StringBuilder("avINasH Va123nGUnde");
        System.out.println(sb);

        for(int i=0; i<sb.length() ;i++){
            char ch = sb.charAt(i);
            if(ch>=65 && ch<=91){   // char is Capital
                sb.setCharAt(i, (char)(ch+(char)32));
            } else if(ch>=97 && ch<=123){     // char is small
                sb.setCharAt(i,(char)(ch-(char)32));
            }
        }
        System.out.println(sb);


        //  given a string return number of palindromic substrings in it
        String s = "abcde";
        int cnt=0;
        for(int i=0 ;i<s.length() ;i++){
            for(int j=i+1 ;j<s.length()+1;j++){
                String sub = s.substring(i,j);
                boolean isPal = isPalindrome(sub);
                if(isPal) {
                    System.out.print(sub+" ");
                    cnt++;
                }
            }
        }
        System.out.println();
        System.out.println(cnt);


        //  reverse each word in String
        /**
         *   ip :  I am from Pune
         *   op : I ma  morf  enup
         */

        String ss  = "I am from Pune";
        String ans = "";
        StringBuilder ssb = new StringBuilder("");
        for(char ch: ss.toCharArray()){
            if(ch!=' ')
                ssb.append(ch);
            else{
                ssb.reverse();
                ans+=ssb+" ";
                ssb = new StringBuilder("");
            }
        }

        System.out.println(ans+ssb.reverse());



        // compress string ,, aaabbc --> a3b2c

        String s2 = "aabbb";
        String ans1 = ""+s2.charAt(0);
        int c = 1;
        for(int i=1 ;i<s2.length();i++){
            char curr = s2.charAt(i);
            char prev = s2.charAt(i-1);
            if(curr != prev){
                if(c>1) ans1+=c;
                ans1+=curr;
                c=1;
            }else{
                c++;
            }
        }


        if(c>1) ans1+=c;
        System.out.println(ans1);
    }
}
