package GrayCode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> grayCode(int n) {
        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1;i<(int)(Math.pow(2,n));i++){
            list.add(i);
        }
        nums.add(0);
        for(int i=0;i<(int)(Math.pow(2,n)-1);i++){
            int opNum1 = nums.get(i);
            if(list.indexOf(opNum1)!=-1) {
                list.remove(list.indexOf(opNum1));
            }
            for(int j=0;j<=n;j++){
                if(compareNum(opNum1,(int)(opNum1+Math.pow(2,j)))==1&&list.indexOf((int)(opNum1+Math.pow(2,j)))!=-1){
                    nums.add( (int)(opNum1+Math.pow(2,j)));
                    list.remove(list.indexOf((int)(opNum1+Math.pow(2,j))));
                    break;
                }
                if(compareNum(opNum1,(int)(opNum1-Math.pow(2,j)))==1&&list.indexOf((int)(opNum1-Math.pow(2,j)))!=-1){
                    nums.add((int)(opNum1-Math.pow(2,j)));
                    list.remove(list.indexOf((int)(opNum1-Math.pow(2,j))));
                    break;
                }
            }
        }
        return nums;
    }
    public int compareNum(int num1,int num2){
        int counter = 0;
        String s1 = Integer.toBinaryString(num1);
        String s2 = Integer.toBinaryString(num2);
        int n = Math.max(s1.length(),s2.length());
        for(int i=s1.length();i<n;i++){
            s1 = "0"+s1;
        }
        for(int i=s2.length();i<n;i++){
            s2 = "0"+s2;
        }
        for(int i=0;i<n;i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
       //new Solution().compareNum(1,8);
        System.out.println(new Solution().grayCode(3));
    }
}
