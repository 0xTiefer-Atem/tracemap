package org.trace.map.leetcode.day1;

/**
 * @Date 2022/4/7 下午 05:00
 * @Created by wangqian30
 * @description:
 */

import java.util.LinkedList;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 * 示例 1：
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * <p>
 * 示例 2：
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * <p>
 * 提示：
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 */


class CQueue {

    private LinkedList<Integer> list = new LinkedList<Integer>();

    public CQueue() {

    }

    public void appendTail(int value) {
        list.add(value);
    }

    public int deleteHead() {
        if (list.isEmpty()) {
            return -1;
        }
        Integer last = list.getFirst();
        list.removeFirst();
        return last;

    }
}
