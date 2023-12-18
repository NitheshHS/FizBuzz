package leetcode;

public class MergeString {
    public static void main(String[] args) {
        System.out.println(mergeString("abcd", "pq"));
    }

    public static StringBuilder mergeString(String str1, String str2){
        StringBuilder mergeStr= new StringBuilder();
        if(str1.length()==str2.length()){
            for(int i=0;i<str1.length();i++){
                mergeStr.append(str1.charAt(i)).append(str2.charAt(i));
            }
        }else if(str1.length()>str2.length()){
            for(int i=0;i<str2.length();i++){
                mergeStr.append(str1.charAt(i)).append(str2.charAt(i));
            }
            mergeStr.append(str1.substring(str2.length()));
        }else {
            for(int i=0;i<str1.length();i++){
                mergeStr.append(str1.charAt(i)).append(str2.charAt(i));
            }
            mergeStr.append(str2.substring(str1.length()));
        }
        return mergeStr;
    }
}
