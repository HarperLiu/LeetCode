package validParentheses;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            switch (s.charAt(i)){
                case'(':{
                    stack.push('(');
                    break;
                }
                case'[':{
                    stack.push('[');
                    break;
                }
                case'{':{
                    stack.push('{');
                    break;
                }
                case')':{
                    if(stack.isEmpty()){
                        return false;
                    }
                    else{
                        if (stack.peek()=='('){
                            stack.pop();
                        }
                        else{
                            stack.push(')');
                        }
                    }
                    break;
                }
                case']':{
                    if(stack.isEmpty()){
                        return false;
                    }
                    else{
                        if (stack.peek()=='['){
                            stack.pop();
                        }
                        else{
                            stack.push(']');
                        }
                    }
                    break;
                }
                case'}':{
                    if(stack.isEmpty()){
                        return false;
                    }
                    else{
                        if (stack.peek()=='{'){
                            stack.pop();
                        }
                        else{
                            stack.push('}');
                        }
                    }
                    break;
                }
            }

        }
        return stack.isEmpty();
    }
}
