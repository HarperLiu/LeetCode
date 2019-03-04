package RomanToInt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int romanToInt(String s) {
        int ret = 0;
        HashMap<Character, Integer> map = new HashMap(8);
        HashMap<String,Integer> map1 = new HashMap<>(7);
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        map.put(' ',0);
        map1.put("IV",4);
        map1.put("IX",9);
        map1.put("XL",40);
        map1.put("XC",90);
        map1.put("CD",400);
        map1.put("CM",900);
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            String key = entry.getKey();
            while(s.contains(key)){
                s = s.replace(key,"  ");
                ret = ret + entry.getValue();
            }
        }
        for(int i=0;i<s.length();i++){
            ret = ret + map.get(s.charAt(i));
        }
        return ret;
    }
    public static void main(String [] args){
        Solution s = new Solution();
        System.out.println(s.romanToInt("MCMXCIV"));
    }
}