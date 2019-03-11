/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
 *
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 *
 * algorithms
 * Medium (33.93%)
 * Total Accepted:    180.7K
 * Total Submissions: 529.5K
 * Testcase Example:  '[1,2,3,4,5]\n2\n4'
 *
 * Reverse a linked list from position m to n. Do it in one-pass.
 * 
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * 
 * Example:
 * 
 * 
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m >= n){
            return head;
        }
        int i = 1;
        ListNode first = null;
        ListNode second = head;
        ListNode head1, head2 = null;
        ListNode tail1, tail12;
        while (i < m){
            first = second;
            second = first.next;
            ++i;
        }
        //从下一个开始反转
        head1 = first;
        first = second;
        second = first.next;
        while (i < n){
            tail1 = second.next;
            second.next = first;
            first = second;
            second = tail1;
            ++i;
        }
        tail1 = first;
        tail12 = second;
        if (head1 != null){
            head2 = head1.next;
            head1.next = first;
        }else {
            head2 = head;
        }
        head2.next = tail12;

        if (m != 1){
            return head;
        }else {
            return tail1;
        }
    }
}
