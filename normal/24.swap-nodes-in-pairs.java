package lalgorithm.normal;/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
 *
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 *
 * algorithms
 * Medium (42.78%)
 * Total Accepted:    276.7K
 * Total Submissions: 645K
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * You may not modify the values in the list's nodes, only nodes itself may be
 * changed.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
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
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode oddTmp = oddHead;
        ListNode evenTmp = evenHead;
        ListNode tmp = head.next.next;
        int i = 1;
        while (tmp != null){
            if (i % 2 != 0){
                oddTmp.next = tmp;
                oddTmp = oddTmp.next;
            }else {
                evenTmp.next = tmp;
                evenTmp = evenTmp.next;
            }
            tmp = tmp.next;
            ++i;
        }
        oddTmp.next = null;
        evenTmp.next = null;
        head = evenHead;
        while (evenHead != null && oddHead != null){
            oddTmp = oddHead.next;
            evenTmp = evenHead.next;
            evenHead.next = oddHead;
            evenHead = evenHead.next;
            evenHead.next = evenTmp;
            tmp = evenHead;
            evenHead = evenHead.next;
            oddHead = oddTmp;

        }
        if (oddHead != null){
            tmp.next = oddHead;
        }
        return head;
    }
}
