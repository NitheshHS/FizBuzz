package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class KidsWithCandies {
    public static List<Boolean> kidWithHighestCandies(int[] candies, int extraCandies){
        int n = candies.length;
        List<Boolean> result = new ArrayList<>();
        Boolean flag=false;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) continue;
                else if((candies[i]+extraCandies)>=candies[j]){
                   flag = true;
                }else{
                    flag=false;
                    break;
                }
            }
            result.add(flag);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] candies = {4,2,1,1,2};
        int extraCandies = 1;
        kidsWithCandies(candies, extraCandies).forEach(ele-> System.out.print(ele+", "));
    }

    public static int findMax(int[] candies){
        int max = candies[0];
        for(int i=1;i<candies.length;i++){
            if(candies[i]>max){
                max = candies[i];
            }
        }
        return max;
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies){
        List<Boolean> result=new ArrayList<>();
        int max = findMax(candies);
        for(int candie: candies){
            result.add((candie+extraCandies)>=max);
        }
        return result;
    }
}
