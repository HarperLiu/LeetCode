package Permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 求一组无重复数字的全排列，思路如下：（以下表示全排列用perm(),如123的全排列记为perm(123),perm前括号里的数代表前缀，如(1)perm(234)=1234）
 * 以1234的全排列为例，perm(1234) = (1)perm(123)+(2)perm(134)+(3)perm(124)+(4)perm(123)
 *  = (1)((2)perm(34)+(3)perm(24)+(4)perm(23))+......
 *  用for循环决定每次放在第一个的数，加上剩下数字的全排列，当剩下的数字只剩一个时它的全排列就是它自己
 */

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int start = 0;
        permutation(list,nums,start);
        return list;
    }

    private void permutation(List<List<Integer>> list, int nums[], int start){
        if(start==nums.length-1){//剩下的数字只剩一个则把当前nums数组加入结果
            list.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        }
        for(int i=start;i<nums.length;i++){//遍历每一个数字，轮流放在第一个，swap就是干这个的
            this.swap(nums,i,start);
            permutation(list,nums,start+1);//获得剩下数字的全排列
            this.swap(nums,start,i);//复位
        }
    }

    private void swap(int nums[],int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] list = {1,2,3};
        Solution s = new Solution();
        System.out.println(s.permute(list));
    }

}
