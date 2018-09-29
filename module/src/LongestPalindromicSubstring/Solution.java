package LongestPalindromicSubstring;

/*
dp[i][j] = dp[i+1][j-1]&&(s.charAt(i)==s.charAt(j))
 */

public class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String res = "";
        //dp[i][j]表示s.substring(i,j)是否为回文串,dp[i][j]取决于dp[i+1][j-1]
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(i==j){
                    dp[i][j]=true;
                }
                else{
                    dp[i][j]=(dp[i+1][j-1]||j==i+1)&&(s.charAt(i)==s.charAt(j));
                }
                if(dp[i][j]&&j-i+1>max){
                    max = j-i+1;
                    res = s.substring(i,j+1);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestPalindrome("babad"));
        //System.out.println(s.isPalindromeStr("abca"));

    }
}
