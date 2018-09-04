package ClimbingStairs;

/**
 * 从n级梯子爬上去，要么是从n-1层爬一级，要么是从n-2层爬两级
 * 所以res[n] = res[n-1]+res[n-2]
 *
 */
public class Solution {
    public int climbStairs(int n) {
        if(n==1){//防止n=1数组溢出
            return 1;
        }
       int[] res = new int[n+1];
       res[1] = 1;
       res[2] = 2;
       for(int i=3;i<n+1;i++){
           res[i] = res[i-1]+res[i-2];
       }
       return res[n];

    }

}
