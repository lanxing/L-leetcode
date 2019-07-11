package lalgorithm.normal;/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 *
 * https://leetcode.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (30.42%)
 * Total Accepted:    746.6K
 * Total Submissions: 2.5M
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example:
 * 
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode next = null;
        int flag = 0;
        int first;
        int second;
        int tmp;
        while (l1 != null || l2 != null || flag != 0){
            if (l1 != null){
                first = l1.val;
                l1 = l1.next;
            }else {
                first = 0;
            }
            if (l2 != null){
                second = l2.val;
                l2 = l2.next;
            }else {
                second = 0;
            }
            tmp = first + second + flag;
            if (head == null){
                head = new ListNode(tmp % 10);
                next = head;
            }else {
                next.next = new ListNode(tmp % 10);
                next = next.next;
            }
            flag = tmp / 10;
        }

        return head;
    }
}
