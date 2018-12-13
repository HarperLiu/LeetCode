package shortestUnsortedContinuousSubarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        if(n==0||n==1){
            return 0;
        }
        int[] newArray = nums.clone();
        Arrays.sort(newArray);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++) {
            if (nums[i] != newArray[i]) {
                list.add(i);
            }
        }
        return list.size()==0?0:Collections.max(list)-Collections.min(list)+1;
    }

}
