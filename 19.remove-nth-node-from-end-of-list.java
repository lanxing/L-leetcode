/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
 *
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 *
 * algorithms
 * Medium (33.92%)
 * Total Accepted:    348.7K
 * Total Submissions: 1M
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given a linked list, remove the n-th node from the end of list and return
 * its head.
 * 
 * Example:
 * 
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5.
 * 
 * 
 * Note:
 * 
 * Given n will always be valid.
 * 
 * Follow up:
 * 
 * Could you do this in one pass?
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        //先计算出数量，循环两次获取
//        int len = 0;
//        ListNode tmp = head;
//        while (tmp != null){
//            len++;
//            tmp = tmp.next;
//        }
//        if (len == n){
//            return head.next;
//        }
//        tmp = head;
//        int index = len - n;
//        int cur = 1;
//        while (cur != index){
//            tmp = tmp.next;
//            cur ++;
//        }
//        tmp.next = tmp.next.next;
//        return head;
//    }

        //first和second相差n+1个
        ListNode first = head;
        ListNode second = head;
        int index = 0;
        while (index < n && second != null) {
            second = second.next;
            index++;
        }
        if (second == null && index == n) {
            return head.next;
        }
        while (second.next != null) {
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
        return head;
    }
}
