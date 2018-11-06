package TopKFrequentElement;

import java.util.*;

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if (map.containsKey(nums[i])){
                int temp = (int) map.get(nums[i]);
                temp++;
                map.put(nums[i],temp);
            }
            else{
                map.put(nums[i],1);
            }
        }
        for(int i=0;i<k;i++){
            int temp = getMax(map);
            list.add(temp);
            map.remove(temp);
        }
        return list;


    }
    public static int getMax(HashMap<Integer,Integer> map){
        int maxValue = 0;
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue()>maxValue){
                maxValue = entry.getValue();
                res = entry.getKey();
            }
            //System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        return res;
    }
}
