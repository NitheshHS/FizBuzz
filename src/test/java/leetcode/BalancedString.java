package leetcode;

import java.util.Stack;

public class BalancedString {
    public static void main(String[] args) {
        String str = "(()(()))";
        System.out.println(isBalanced(str));
    }

    public static boolean isBalanced(String str){
        if(str.length()>2){
            Stack<Character> st=new Stack<>();
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);
                if(ch == '(' || ch == '[' || ch == '{'){
                    st.push(ch);
                }else if(ch == ')' || ch == ']' || ch == '}'){
                    if(st.isEmpty()) return false;
                    else st.pop();
                }
            }
            return st.isEmpty();
        }
        return false;
    }
}
