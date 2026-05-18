import java.util.Stack;

/**
 *   Infix ,prefix and postfix expressions evaluations and conversions
 *
 *   infix evaluation
 *   prefix evaluation
 *   postfix evaluation
 *
 *   infix to postfix
 *   infix to prefix
 *   prefix to infix
 *   postfix to infix
 *
 *   postfix to prefix
 *   prefix to postfix
 *
 */

public class Expressions {

    public static int infixEval(String str){
        Stack<Integer> val = new Stack<>();
        Stack<Character> op = new Stack<>();
        for(char ch : str.toCharArray()) {
            if(ch>=48 && ch<=57) {   //  0 ---> 9   , ch = 5 : ascii = 53 : so num = 5
                val.push(ch-48);
            } else if(op.size() == 0 || ch =='(' || op.peek() =='(') {
                op.push(ch);
            } else {
                if(ch == ')'){      // for brackets '(' and ')'
                    while(op.peek()!='('){
                        int v2 = val.pop();
                        int v1  = val.pop();
                        char sign = op.pop();
                        if(sign =='+') val.push(v1+v2);
                        if(sign =='-') val.push(v1-v2);
                        if(sign =='*') val.push(v1*v2);
                        if(sign =='/') val.push(v1/v2);
                    }
                    op.pop();
                }

                if(ch =='+' || ch =='-'){     // as + and - has least priority no need to check priority of sign
                    int v2 = val.pop();
                    int v1  = val.pop();
                    char sign = op.pop();
                    if(sign =='+') val.push(v1+v2);
                    if(sign =='-') val.push(v1-v2);
                    if(sign =='*') val.push(v1*v2);
                    if(sign =='/') val.push(v1/v2);
                    op.push(ch);
                }

                if(ch=='*' || ch =='/'){
                    if(op.peek()=='*' || op.peek() =='/' ){
                        int v2 = val.pop();
                        int v1  = val.pop();
                        char sign = op.pop();
                        if(sign =='*') val.push(v1*v2);
                        if(sign =='/') val.push(v1/v2);
                    }

                    op.push(ch);   // for '+' and '-' simply push the ch at * and / has high priority
                }
            }

        }
        while(val.size()>1){
            int v2 = val.pop();
            int v1 = val.pop();
            char sign = op.pop();
            if(sign =='+') val.push(v1+v2);
            if(sign =='-') val.push(v1-v2);
            if(sign =='*') val.push(v1*v2);
            if(sign =='/') val.push(v1/v2);
        }

        return val.pop();
    }


    // infix to prefix conversion
    public static String infixToPrefix(String str){
        Stack<String> val = new Stack<>();
        Stack<Character> op = new Stack<>();

        for(char ch : str.toCharArray()){
            if(ch>=48 && ch<=57){
                val.push(""+ch);
            } else if(op.size() == 0 || ch=='(' || op.peek()=='('){
                 op.push(ch);
            } else {
                if(ch==')'){
                    while(op.peek()!='('){
                        String v2 = val.pop();
                        String v1 = val.pop();
                        char sign = op.pop();
                        val.push(sign+v1+v2);   // op + v1 + v2 (prefix exp)
                    }
                    op.pop();
                }

                if(ch=='+' || ch =='-'){
                    String v2 = val.pop();
                    String v1 = val.pop();
                    char sign = op.pop();
                    val.push(sign+v1+v2);   // op + v1 + v2 (prefix exp)
                    op.push(ch);
                }

                if(ch =='*' || ch =='/'){
                    if(op.peek()=='*' || op.peek() == '/'){
                        String v2 = val.pop();
                        String v1 = val.pop();
                        char sign = op.pop();
                        val.push(sign+v1+v2);   // op + v1 + v2 (prefix exp)
                        op.push(ch);
                    }else{
                        op.push(ch);
                    }
                }
            }
        }
        while(val.size()>1){
            String v2 = val.pop();
            String v1 = val.pop();
            char sign = op.pop();
            val.push(sign+v1+v2);   // op + v1 + v2 (prefix exp)
        }

        return val.pop();
    }

    // infix to postfix conversion
    public static String infixToPostfix(String str){
        Stack<String> val = new Stack<>();
        Stack<Character> op = new Stack<>();

        for(int i=str.length()-1 ;i>=0 ;i--){
            char ch = str.charAt(i);
            if(ch>=48 && ch<=57){
                val.push(""+ch);
            } else if(op.size() == 0 || ch==')' || op.peek()==')'){
                op.push(ch);
            } else {
                if(ch=='('){
                    while(op.peek()!=')'){
                        String v1 = val.pop();
                        String v2 = val.pop();
                        char sign = op.pop();
                        val.push(v1+v2+sign);   // v1 + v2 + op (postfix exp)
                    }
                    op.pop();
                }

                if(ch=='+' || ch =='-'){
                    String v1 = val.pop();
                    String v2 = val.pop();
                    char sign = op.pop();
                    val.push(v1+v2+sign);   // v1 + v2 + op (postfix exp)
                    op.push(ch);
                }

                if(ch =='*' || ch =='/'){
                    if(op.peek()=='*' || op.peek() == '/'){
                        String v1 = val.pop();
                        String v2 = val.pop();
                        char sign = op.pop();
                        val.push(v1+v2+sign);   // v1 + v2 + op (postfix exp)
                        op.push(ch);
                    }else{
                        op.push(ch);
                    }
                }
            }
        }
        while(val.size()>1){
            String v1 = val.pop();
            String v2 = val.pop();
            char sign = op.pop();
            val.push(v1+v2+sign);   //  v1 + v2 + op (postfix exp)
        }

        return val.pop();
    }

    public static Integer postfixEval(String str){
        Stack<Integer> st = new Stack<>();

        for(char ch : str.toCharArray()){
            if(ch>=48 && ch<=57){
                st.push(ch-48);
            } else{
                int v2 = st.pop();
                int v1 = st.pop();
                if(ch == '+') st.push(v1+v2);
                if(ch == '-') st.push(v1-v2);
                if(ch == '/') st.push(v1/v2);
                if(ch == '*') st.push(v1*v2);
            }
        }

        return st.pop();
    }

    public static Integer prefixEval(String str){
        Stack<Integer> st = new Stack<>();
        for(int i=str.length()-1;i>=0 ;i--){
            char ch = str.charAt(i);
            if(ch>=48 && ch<=57){
                st.push(ch-48);
            }else{
                int v1 = st.pop();
                int v2 = st.pop();
                if(ch == '+') st.push(v1+v2);
                if(ch == '-') st.push(v1-v2);
                if(ch == '*') st.push(v1*v2);
                if(ch == '/') st.push(v1/v2);
            }
        }

        return st.pop();
    }

    public static String prefixToInfix(String str){
        Stack<String> st = new Stack<>();
        for(int i=str.length()-1 ;i>=0;i--){
            char ch = str.charAt(i);
            if(ch>=48 && ch<=57){
                st.push(ch+"");
            }else{
                String v1 = st.pop();
                String v2 = st.pop();
                st.push(v1+ch+v2);
            }

        }

        return st.pop();
    }

    public static String postfixToInfix(String str){
        Stack<String> st = new Stack<>();
        for(int i=0 ;i<str.length() ;i++) {
            char ch = str.charAt(i);
            if (ch >= 48 && ch <= 57) {
                st.push(ch + "");
            } else {
                String v2 = st.pop();
                String v1 = st.pop();
                st.push(v1 + ch + v2);
            }
        }
        return st.pop();
    }


    public static String postfixToPrefix(String str){
        Stack<String> st = new Stack<>();
        for(int i=0 ;i<str.length() ;i++){
            char ch = str.charAt(i);
            if(ch>=48 && ch<=57){
                st.push(ch+"");
            }else{
                String v2 = st.pop();
                String v1 = st.pop();
                st.push(ch+v1+v2);
            }
        }

        return st.pop();
    }

    public static String prefixToPostfix(String str){
        Stack<String> st = new Stack<>();
        for(int i=str.length()-1 ;i>=0 ;i--){
            char ch = str.charAt(i);
            if(ch>=48 && ch<=57){
                st.push(ch+"");
            }else{
                String v1 = st.pop();
                String v2 = st.pop();
                st.push(v1+v2+ch);
            }
        }
        return st.pop();
    }



    public static void main(String[] args) {
         // infix evaluation
        String str ="9-5+3*4/6";
        String str1 = "9-(5+3)*4/6";   // with brackets
        System.out.println(infixEval(str1));


        // infix -> prefix expression
        System.out.println(infixToPrefix(str1));


        // infix -> postfix expression
        System.out.println(infixToPostfix(str1));

        // postfix evaluation
        String post = "953+4*6/-";
        System.out.println(postfixEval(post));

        // prefix evaluation
        String pre = "+-95/*346";
        System.out.println(prefixEval(pre));


        // prefix -> infix expression
        System.out.println(prefixToInfix(pre));

        // postfix -> infix expression
        System.out.println(postfixToInfix(post));

        // postfix -> prefix expression
        System.out.println(postfixToPrefix(post));

        // prefix -> postfix expression
        System.out.println(prefixToPostfix(pre));



    }
}
