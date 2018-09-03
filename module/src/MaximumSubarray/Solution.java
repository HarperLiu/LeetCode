package MaximumSubarray;
/*
对于array中的n个数nums[0,n-1]
如果nums[i,j]是最大的子串
那么nums[i,k]一定是大于0的，否则nums[k,j]才是最大的子串（前面的和是负数啊我带你岂不是拖了后腿）
所以从nums[0]遍历数组：
  把nums[k]加进curSum
  如果nums[i,k]（即curSum）<0，那么curSum=0。//解决子串偏大的问题
  max取curSum和max中较大的 //解决子串偏小的问题
 */

/*；通俗一点
如果nums[i,j]是最大的子串，那么其他的子串只可能是以下2种情况：
  nums[i-k,j]或nums[i,j+k]，即多出来了一部分
  nums[i+k,j]或nums[i,j-k]，即子串少一部分
  这2种情况可以叠加，比如左边多了右边少了之等等
  curSum如果小于0，就清空。这可以删掉多了一部分的子串
  curSum和max比较，这可以删掉少了一部分的子串
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        /*双指针方法，超时了
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
