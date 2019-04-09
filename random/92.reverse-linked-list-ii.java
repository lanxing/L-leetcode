/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 *
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/description/
 *
 * algorithms
 * Medium (42.04%)
 * Total Accepted:    8.5K
 * Total Submissions: 19.9K
 * Testcase Example:  '[1,2,3,4,5]\n2\n4'
 *
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * 
 * 示例:
 * 
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode beforeFirst = null, first = head, second, afterSecond;
        int i = 0;
        while (++i < m){
            beforeFirst = first;
            first = first.next;
        }
        afterSecond = first.next;
        second = first;
        ListNode last = first;
        while (i++ < n){
            if (afterSecond != null){
                second = afterSecond;
                afterSecond = second.next;
                second.next = last;
                last = second;
            }
        }
        if (beforeFirst != null){
            beforeFirst.next = second;
            first.next = afterSecond;
            return head;
        }
        if (afterSecond != null){
            first.next = afterSecond;
            return second;
        }
        first.next = null;
        return second;
    }
}
