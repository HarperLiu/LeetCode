package ThreeSum;

import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    /* brute force, 311/313 ConstructBinaryTreefromPreorderandInorderTraversal case passed ,TLE
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list =  new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++) {
                    if(nums[i]+nums[j]+nums[k]==0){
                        ArrayList temp = new ArrayList();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        Collections.sort(temp);
                        if(!list.contains(temp)) {
                            list.add(temp);
                        }
                    }
                }
            }
        }
        return list;
    }
    */
    /*用map匹配，估计在O(n2)左右，还是TLE
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer,Integer> map = new HashMap();
        List<List<Integer>> list =  new ArrayList<>();
        ArrayList<ArrayList<Integer>> twoSum = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int times = map.get(nums[i]);
                times++;
                map.put(nums[i],times);
            }
            else{
                map.put(nums[i],1);
            }
        }
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                temp.add(nums[j]);
                twoSum.add(temp);
            }
        }
        //System.out.println(twoSum);
        for(int i=0;i<twoSum.size();i++){
            int num1 = twoSum.get(i).get(0);
            int num2 = twoSum.get(i).get(1);
            int leftNum = 0-num1-num2;
            if(map.containsKey(leftNum)){
                int times1 = map.get(leftNum);
                times1--;
                map.put(leftNum,times1);

                int times2 = map.get(num1);
                times2--;
                map.put(num1,times2);

                int times3 = map.get(num2);
                times3--;
                map.put(num2,times3);
                if(map.get(leftNum)>=0&&map.get(num1)>=0&&map.get(num2)>=0){
                    twoSum.get(i).add(leftNum);
                    Collections.sort(twoSum.get(i));
                    if(!list.contains(twoSum.get(i))){
                        list.add(twoSum.get(i));
                    }
                }
                times1 = map.get(leftNum);
                times1++;
                map.put(leftNum,times1);
                times2 = map.get(num1);
                times2++;
                map.put(num1,times2);
                times3 = map.get(num2);
                times3++;
                map.put(num2,times3);

            }
        }
        return list;
    }
    */

    /**
     * 主要思想是，遍历数组，用 0 减去当前的数，作为 sum ，然后再找两个数使得和为 sum。
     这样看来遍历需要 O（n），再找两个数需要 O（n²）的复杂度，还是需要 O（n³）。
     巧妙之处在于怎么找另外两个数。
     最最优美的地方就是，首先将给定的 num 排序。
     这样我们就可以用两个指针，一个指向头，一个指向尾，去找这两个数字，这样的话，找另外两个数时间复杂度就会从 O（n²），降到 O（n）
     然后用set去重
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums){
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> list =  new ArrayList<>();
        Arrays.sort(nums);
        if(nums.length>=3&&nums[0]==0&&nums[nums.length-1]==0){
            list.add(Arrays.asList(0,0,0));
            return list;
        }
        for(int i=0;i<nums.length;i++){
            int sum = 0-nums[i];
            //System.out.println(sum);
            int lo = 0;
            int hi = nums.length-1;
            if(lo!=i&&hi!=i&&hi!=lo) {
                while (lo < hi&&lo!=i&&hi!=i) {
                    if (nums[lo] + nums[hi] == sum) {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(nums[lo]);
                        temp.add(nums[hi]);
                        temp.add(nums[i]);
                        Collections.sort(temp);
                        set.add(temp);
                        lo++;
                    } else if (nums[lo] + nums[hi] < sum) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        Iterator<List<Integer>> value = set.iterator();
        while (value.hasNext()) {
            List<Integer> s =value.next();
            list.add(s);
        }
        return list;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] num = {-2,-1,0,1,2,3};
        System.out.println( s.threeSum(num));
    }
}
