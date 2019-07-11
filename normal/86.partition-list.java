package lalgorithm.normal;/*
 * @lc app=leetcode id=86 lang=java
 *
 * [86] Partition List
 *
 * https://leetcode.com/problems/partition-list/description/
 *
 * algorithms
 * Medium (36.18%)
 * Total Accepted:    153.6K
 * Total Submissions: 422.5K
 * Testcase Example:  '[1,4,3,2,5,2]\n3'
 *
 * Given a linked list and a value x, partition it such that all nodes less
 * than x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * Example:
 * 
 * 
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
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
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode splitNode, first, second, tmp;
        if (head.val < x){
            splitNode = head;
            first = splitNode;
        }else {
            first = head;
            while (first.next != null && first.next.val >= x){
                first = first.next;
            }
            if (first.next == null){
                return head;
            }
            splitNode = first.next;
            first.next = first.next.next;
            splitNode.next = head;
            head = splitNode;
        }
        second = first.next;

        while (second != null){
            if (second.val < x){
                if (first == splitNode){
                    first = second;
                    second = second.next;
                    splitNode = first;
                    continue;
                }
                first.next = second.next;
                second.next = splitNode.next;
                splitNode.next = second;
                splitNode = splitNode.next;
            }else {
                first = second;
            }
            second = first.next;
        }
        return head;
    }
}
