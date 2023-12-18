package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class NxtGreaterElement {
    public static void main(String[] args) {
        int[] arr={1,2,4,8,2,5,3};
        int[] resultArr = nextGreaterStack(arr);
        for (int j : resultArr) {
            System.out.print(j + ", ");
        }
    }
    static int[] nxtGreater(int[] arr){
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]>arr[i]){
                    stack.push(arr[j]);
                    break;
                }else{
                    stack.push(-1);
                }
            }
        }
        int[] maxArr=new int[stack.size()];
        for(int i=maxArr.length-1;i>=0;i--){
            maxArr[i]=stack.pop();
        }
        return maxArr;
    }

    static int[] nextGreaterStack(int[] arr){
        Stack<Integer> stack=new Stack<>();
        int[] res=new int[arr.length];
        int len=arr.length;
        res[len-1]=-1;
        stack.push(arr[len-1]);
        for(int i=arr.length-2;i>=0;i--){
            while(stack.peek()<arr[i] && !stack.isEmpty()){
                stack.pop();
            }
            if(stack.isEmpty()) res[i] = -1;
            else{
                res[i]=stack.peek();
                stack.push(arr[i]);
            }
        }
        return res;
    }
}
