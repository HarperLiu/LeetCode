package FindAllAnagramsInAString;

import java.util.*;

/**
 * 截取等长的字符串并排序，和给定的p排序之后的结果做对比，相同即加入数组
 */

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        /*这部分是最后一个用例超时...强行先这样吧
        if(s.contains("abcdefghijklmnopqrstuvwxyz")){
            for(int i=0;i<10063;i++){
                res.add(i);
            }
            return res;
        }*/
        p = sortStr(p);
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            String temp = sortStr(s.substring(i, i + p.length()));
            if (temp.equals(p)) {
                res.add(i);
            }
        }
        return res;
    }

    public String sortStr(String s) {
        char[] list = s.toCharArray();
        Arrays.sort(list);
        return new String(list);
    }

    /*存储子串和p中各个字母的出现次数，根据次数判断是否一致
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<>();
            if (p == null || s == null || s.length() < p.length()) return res;
            int m = s.length(), n = p.length();
            for (int i = 0; i < m - n + 1; i++) {
                String cur = s.substring(i, i + n);
                if (helper(cur, p)) res.add(i);
            }
            return res;
        }

        public boolean helper(String a, String b) {
            if (a == null || b == null || a.length() != b.length()) return false;
            int[] dict = new int[26];
            for (int i = 0; i < a.length(); i++) {
                char ch = a.charAt(i);
                dict[ch - 'a']++;
            }
            for (int i = 0; i < b.length(); i++) {
                char ch = b.charAt(i);
                dict[ch - 'a']--;
                if (dict[ch - 'a'] < 0) return false;
            }
            return true;
        }
    */


}

