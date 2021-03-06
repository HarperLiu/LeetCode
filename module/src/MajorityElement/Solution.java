package MajorityElement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int majorityElement(int[] nums) {
        int n=  nums.length;
        Map map = new HashMap();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else{
                map.put(nums[i],(int)map.get(nums[i])+1);
            }
            if((int)map.get(nums[i])>nums.length/2.0){
                return nums[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3};
        System.out.println(new Solution().majorityElement(nums));
    }
}
