package MinStack;

import java.util.Collections;
import java.util.LinkedList;

class MinStack {

    /** initialize your data structure here. */
    LinkedList stack;
    public MinStack() {
        stack = new LinkedList();
    }

    public void push(int x) {
        stack.offer(x);
    }

    public void pop() {
        stack.pollLast();
    }

    public int top() {
        return (int)stack.getLast();
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;
        for(int i=0;i<stack.size();i++){
            min = (int) stack.get(i)>min?min: (int) stack.get(i);
        }
        min = (int)Collections.min(stack);
        return min;
    }


}
