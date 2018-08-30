package WordBreak;

import java.util.ArrayList;
import java.util.List;

/*
这道题仍然是动态规划的题目，我们总结一下动态规划题目的基本思路。首先我们要决定要存储什么历史信息以及用什么数据结构来存储信息。然后是最重要的递推式，就是如从存储的历史信息中得到当前步的结果。最后我们需要考虑的就是起始条件的值。
接下来我们套用上面的思路来解这道题。首先我们要存储的历史信息res[i]是表示到字符串s的第i个元素为止能不能用字典中的词来表示，
我们需要一个长度 为n的布尔数组来存储信息。然后假设我们现在拥有res[0,...,i-1]的结果，我们来获得res[i]的表达式。
思路是对于每个以i为结尾的子 串，看看他是不是在字典里面以及他之前的元素对应的res[j]是不是true，如果都成立，那么res[i]为true
 */
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
