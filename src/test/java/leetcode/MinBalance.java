package leetcode;

import java.util.Stack;

public class MinBalance {
    public static void main(String[] args) {
        String str = "()()))";
        System.out.println(minBalance(str));
    }

    public static int minBalance(String str){
        int openingBrackets=0;
        int closingBrackets=0;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch == '(') openingBrackets++;
            else{
                closingBrackets++;
            }
        }
        return closingBrackets - openingBrackets;
    }
}
