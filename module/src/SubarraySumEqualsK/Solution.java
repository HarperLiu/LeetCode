package SubarraySumEqualsK;

/**
 * 第一次循环获得数组的累加和（sum[i]代表nums中第0个到第i-1个元素的和）
 * 用i、j截取出所有任意两个累加和的差，判断是否等于k
 * 所有任意两个累加和的差即为所有的子数组的和
 */

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int counter = 0;
        int n = nums.length;
        int[] sum = new int[n+1];
        sum[0] = 0;
        for(int i=1;i<=n;i++){
            sum[i] = nums[i-1]+sum[i-1];
        }
        for(int i=1;i<sum.length;i++){
            //先判断是不是有哪个累加和刚好就是k
            if(sum[i]==k){
                counter++;
            }
            for(int j=i+1;j<sum.length;j++){
                if(sum[j]-sum[i]==k){
                    counter++;
                }
            }
        }
        return counter;
    }
}
