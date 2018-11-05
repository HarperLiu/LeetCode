package DecodeString;

import java.util.Stack;

public class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> numStack = new Stack<>();
        Stack<Character>braceStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        String temp = "";
        for(int i=0;i<s.length();i++){
            //System.out.println(s.charAt(i));
            if(s.charAt(i)>=48&&s.charAt(i)<=57){//数字
                int start = i;
                while (s.charAt(i)>=48&&s.charAt(i)<=57){
                    i++;
                }
                numStack.push(Integer.parseInt(s.substring(start,i)));
                i--;
            }
            else if((s.charAt(i)>=97&&s.charAt(i)<=122)||(s.charAt(i)>=65&&s.charAt(i)<=90)){//小写字母
                temp+=s.charAt(i);
            }
            else if(s.charAt(i)=='['){
                braceStack.push('[');
                stringStack.push(temp);
                temp  = "";
            }
            else if(s.charAt(i)==']'){
                int times = numStack.pop();
                braceStack.pop();
                String prefix = stringStack.pop();
                String currTemp = "";
                for(int j=0;j<times;j++){
                    currTemp = currTemp+temp;
                }
                //stringStack.push(prefix+currTemp);
                if(braceStack.isEmpty()){
                    sb.append(prefix+currTemp);
                    temp = "";
                }
                else{
                    temp = prefix+currTemp;
                }
            }
        }
        return sb.toString()+temp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.decodeString("3[a]2[b4[F]c]"));
    }
}
