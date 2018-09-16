package LongestSubstringWithoutRepeatingCharacters;

import java.util.*;

public class Solution {
    /* brute force, TLE
    public int lengthOfLongestSubstring(String s) {
        int counter = 0;
        for(int i=s.length();i>0;i--){
            for(int j=0;j<s.length()-i+1;j++){
                String str = s.substring(j,j+i);
                //System.out.println(str);
                if(isUnique(str)){
                    return str.length();
                }
            }
        }
        return counter;

    }

    public boolean isUnique(String str){
        char[] array = str.toCharArray();
        Set set = new HashSet();
        for(int k=0;k<array.length;k++){
            if(set.contains(array[k])){
                return false;
            }
            set.add(array[k]);
        }
        return true;
    }
    */

    /**
     * sliding window, 常用于数组或字符串的处理
     * s[i]到s[j-1]为一个窗口，一开始i,j都在0，而后开始推j来扩大窗口，i保持不动，直到j无法再推，此时找到i处于当前位置的最大窗口，
     i向前移动，循环这一过程，即可找到i位于每一个位置的最大窗口，用counter存储所有位置中的最大值
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int i, j, counter;
        i = j = counter = 0;
        Set<Character> set = new HashSet<>();
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                counter = Math.max(counter, j - i);
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return counter;
    }

}
