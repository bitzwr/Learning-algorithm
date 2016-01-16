package org.wangbiao.datastructure.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wang Biao on 16/1/16.
 */
public class Stack<T> {

    private List<T> data = new ArrayList<T>(); // 用ArrayList来实现栈

    private int top = -1; // 栈顶索引, 为-1时表示栈为空

    /**
     * 判断栈是否为空
     */
    public boolean isEmpty() {
        if (top == -1){
            return true;
        }
        return false;
    }

    /**
     * 元素入栈
     */
    public void push(T t) {
        data.add(t);
        top++;
    }

    /**
     * 栈顶元素出栈
     */
    public T pop() throws Exception{
        if(isEmpty()) {
            throw new Exception("栈为空");
        }
        return data.remove(top--);
    }

    public void print() {
        if(isEmpty()) {
           return;
        }
        for(int i = 0; i <= top; i++) {
            System.out.println(data.get(i));
        }
    }

    public static void main(String[] args) throws Exception {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.pop();
        stack.push(3);
        stack.pop();
        stack.pop();
        stack.print();
    }
}
