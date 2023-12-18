package leetcode;

public class ReverseVowels {

    public static boolean isVowel(char c){
        return "aeiouAEIOU".indexOf(c)!=-1;
    }

    public static String reverse(String str){
        char[] chars=str.toCharArray();
        int left = 0, right = str.length()-1;
        while(left<right){
            while(left<right && !isVowel(chars[left])){
                left++;
            }
            while(left<right && !isVowel(chars[right])){
                right--;
            }
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverse("leetcode"));
    }
}
