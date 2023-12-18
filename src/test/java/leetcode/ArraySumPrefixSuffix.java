package leetcode;

import java.util.Arrays;

public class ArraySumPrefixSuffix {
    public static void main(String[] args) {
        int[] nums = {-1,1,0,-3,3};
        Arrays.stream(productExceptSelf(nums)).forEach(System.out::println);
        Arrays.stream(productExceptSelf(nums)).forEach(System.out::println);
        Arrays.stream(productExceptSelf(nums)).forEach(System.out::println);
    }
    public static int[] productExceptSelf(int[] nums) {
        int[] arr = new int[nums.length];
        for(int i=0;i<nums.length;i++){//O(n)
            int curNum = nums[i];
            int mul = 1;
            for(int j=0;j<nums.length;j++){//O(n)
                if(curNum!=nums[j]){
                    mul = mul*nums[j];
                }
            }
            arr[i] = mul;
        }
        return arr;
    }

    public static int[] productExceptSelf123(int[] nums) {
        int[] arr = new int[nums.length];
        for(int i=0;i<nums.length;i++){//O(n)
            int curNum = nums[i];
            int mul = 1;
            for(int j=0;j<nums.length;j++){//O(n)
                if(curNum!=nums[j]){
                    mul = mul*nums[j];
                }
            }
            arr[i] = mul;
        }
        return arr;
    }
}
