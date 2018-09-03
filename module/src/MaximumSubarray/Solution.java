package MaximumSubarray;
/*
对于array中的n个数nums[0]~nums[n-1]
如果nums[i,j]是最大的子串
那么nums[i,k]一定是大于0的，否则nums[k,j]才是最大的子串（前面的和是负数啊我带你岂不是拖了后腿）
所以从nums[0]遍历数组：
  如果nums[i,k]（即curSum）>0，那么继续加下一个
  否则清空curSum，从nums[k]开始继续
 */

public class Solution {
    public int maxSubArray(int[] nums) {
        /*双指针方法，但是超时了
        int max = nums[0];
        for(int i=1;i<=nums.length;i++){//subarray长度
            for(int j=0;j<=nums.length-i;j++){//截取数组开始位置
                int temp = 0;
                for(int k=j;k<i+j;k++){
                    temp+=nums[k];
                }
                max = (temp>max?temp:max);
                //System.out.println(max);
            }
        }
        return max;
        */
        int max = nums[0];
        int curSum = 0;
        for(int k=0;k<nums.length;k++){
            curSum+=nums[k];
            max = (curSum>max?curSum:max);
            if(curSum<0){
                curSum = 0;
            }
        }
        return max;
    }


}
