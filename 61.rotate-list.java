/*
 * @lc app=leetcode id=61 lang=java
 *
 * [61] Rotate List
 *
 * https://leetcode.com/problems/rotate-list/description/
 *
 * algorithms
 * Medium (26.41%)
 * Total Accepted:    178K
 * Total Submissions: 671.8K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given a linked list, rotate the list to the right by k places, where k is
 * non-negative.
 * 
 * Example 1:
 * 
 * 
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
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
    public ListNode rotateRight(ListNode head, int k) {
        return second(head, k);
    }

    private ListNode second(ListNode head, int k){
        if (head == null){
            return head;
        }
        if (k == 0){
            return head;
        }
        int total = 0;
        ListNode tail = head;
        while (tail.next != null){
            total++;
            tail = tail.next;
        }
        total++;
        k = k % total;
        int n = total - k;
        ListNode tmp = head;
        while (n > 1){
            tmp = tmp.next;
            --n;
        }
        ListNode newHead = tmp.next;
        if (newHead == null){
            return head;
        }
        tmp.next = null;
        tail.next = head;
        return newHead;
    }

    private ListNode first(ListNode head, int k){
        if (head == null){
            return head;
        }
        int index = 1;
        ListNode indexNode = head;
        while (index <= k){
            if (indexNode.next != null) {
                indexNode = indexNode.next;
            }else {
                indexNode = head;
            }
            ++index;
        }
        ListNode tmp = head;
        while (indexNode.next != null){
            indexNode = indexNode.next;
            tmp = tmp.next;
        }
        indexNode.next = head;
        ListNode newHead = tmp.next;
        tmp.next = null;
        return newHead;
    }
}
