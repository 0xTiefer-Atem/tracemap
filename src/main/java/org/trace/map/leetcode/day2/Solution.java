package org.trace.map.leetcode.day2;

/**
 * @Date 2022/4/7 下午 05:30
 * @Created by wangqian30
 * @description:
 */

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class Solution {
    public int[] reversePrint(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            ++count;
            temp = temp.next;
        }

        int[] result = new int[count];
        temp = head;

        for (int i = count - 1; i >= 0; i--) {
            result[i] = temp.val;
            temp = temp.next;
        }

        return result;
    }
}
