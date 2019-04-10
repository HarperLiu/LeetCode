package HuaweiTest;

// 本题为考试单行多行输入输出规范示例，无需提交，不计分。

import java.util.Scanner;
import java.util.Stack;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> braceStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        StringBuilder res = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((int)c >= 48 && (int)c <= 57) {
                numStack.push((c-48));
                stringStack.push(temp.toString());
                temp = new StringBuilder();
            }
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                if (braceStack.isEmpty()) {
                    res.append(c);
                } else {
                    temp.append(c);
                }
            }
            if (c == '(' || c == '[' || c == '{') {
                braceStack.push(c);
            }
            if (c == ')' || c == ']' || c == '}') {
                String curr = temp.toString();
                int repeat = numStack.pop();
                for (int j = 1; j < repeat; j++) {
                    temp.append(curr);
                }
                braceStack.pop();
                temp.insert(0,stringStack.pop());
                if(braceStack.isEmpty()){
                    res.append(temp.toString());
                }
            }
        }
        System.out.println(res.reverse().toString());
    }
}