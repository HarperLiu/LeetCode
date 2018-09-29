package PalindromicSubstrings;

public class Solution {
    public int countSubstrings(String s) {
        int counter = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String res = "";
        //dp[i][j]表示s.substring(i,j)是否为回文串,dp[i][j]取决于dp[i+1][j-1]
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(i==j){
                    dp[i][j]=true;
                    counter++;
                }
                else{
                    dp[i][j]=(dp[i+1][j-1]||j==i+1)&&(s.charAt(i)==s.charAt(j));
                    if(dp[i][j]){
                        counter++;
                    }
                }
            }
        }

        return counter;
    }
}
