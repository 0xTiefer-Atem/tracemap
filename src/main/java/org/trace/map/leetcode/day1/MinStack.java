package org.trace.map.leetcode.day1;

/**
 * @Date 2022/4/7 下午 05:15
 * @Created by wangqian30
 * @description:
 */

import java.util.*;

/**
 * 剑指 Offer 30. 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * <p>
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();   --> 返回 0.
 * minStack.min();   --> 返回 -2.
 */
class MinStack {
    private LinkedList<Integer> list = new LinkedList<>();
    private LinkedList<Integer> miniList = new LinkedList<>();

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        list.add(x);
        miniList.add(x);
        miniList.sort(Comparator.comparingInt(o -> o));
    }

    public void pop() {
        Integer integer = list.removeLast();
        miniList.remove(integer);
    }

    public int top() {
        return list.getLast();
    }

    public int min() {
        return miniList.getFirst();
    }

    public static void main(String[] args) {
        MinStack m = new MinStack();

        m.push(-2);
        m.push(0);
        m.push(-1);

        System.out.println(m.min());
        System.out.println(m.top());
        m.pop();
        System.out.println(m.min());

    }
}