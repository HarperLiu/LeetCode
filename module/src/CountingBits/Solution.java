package CountingBits;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int[] countBits(int num) {
        int[] list = new int[num+1];
        for (int i=0;i<list.length;i++){
            list[i] =countOne( Integer.toBinaryString(i));
        }
        return list;
    }
    private static int countOne(String s){
        int counter = 0;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='1'){
                counter++;
            }
        }
        return counter;
    }
}
