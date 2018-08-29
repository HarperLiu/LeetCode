package WordBreak;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

        public boolean wordBreak(String s, List<String> wordDict) {
            boolean[] dp = new boolean[s.length()+1];
            dp[0] = true;
            for(int i=1;i<=s.length();i++){
                for(int j=i-1;j>=0;j--){
                    //System.out.println(s.substring(j,i));
                    if(dp[j]&&wordDict.contains(s.substring(j,i))){
                        dp[i]=true;
                        break;
                    }
                }
            }
            return dp[s.length()];
        }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        new Solution().wordBreak("leetcode",list);
    }



}
