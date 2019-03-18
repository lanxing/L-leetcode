/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] k个一组翻转链表
 *
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/description/
 *
 * algorithms
 * Hard (49.65%)
 * Total Accepted:    7.8K
 * Total Submissions: 15.6K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
 * 
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
 * 
 * 示例 :
 * 
 * 给定这个链表：1->2->3->4->5
 * 
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * 
 * 说明 :
 * 
 * 
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 
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
    public ListNode reverseKGroup(ListNode head, int k) {
        int s = 1;
        ListNode newHead = head;
        ListNode first = head;
        ListNode preFirst = head;
        ListNode secondNext = head;
        ListNode second = first;
        while (second != null){
            second = first;
            while (second != null && (s % k) != 0){
                second = second.next;
                s++;
            }
            if (second == null){
                return newHead;
            }else if (s / k == 1){
                secondNext = second.next;
                reverse(first, second);
                newHead = second;
                first.next = secondNext;
                preFirst = first;
                first = secondNext;
            }else {
                secondNext = second.next;
                reverse(first, second);
                preFirst.next = second;
                first.next = secondNext;
                preFirst = first;
                first = secondNext;
            }
            s++;
        }
        return newHead;
    }

    public void reverse(ListNode head, ListNode tail){
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode next = null;
        ListNode stop = tail.next;
        if (cur == null){
            return;
        }
        while (cur != stop){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }
}
