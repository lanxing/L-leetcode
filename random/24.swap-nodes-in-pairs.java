/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
 *
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/description/
 *
 * algorithms
 * Medium (57.77%)
 * Total Accepted:    20.7K
 * Total Submissions: 34.8K
 * Testcase Example:  '[1,2,3,4]'
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 
 * 
 * 
 * 示例:
 * 
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode first = head;
        ListNode second= first.next;
        first.next = second.next;
        second.next = first;
        head = second;
        first = head;
        second = first.next.next;
        int i = 1;
        while (second != null){
            i++;
            first = first.next;
            second = second.next;
            if (i %2 == 0 && second != null){
                ListNode tmp = first.next;
                tmp.next = second.next;
                second.next = tmp;
                first.next = second;
                second = tmp;
            }
        }
        return head;
    }
}
