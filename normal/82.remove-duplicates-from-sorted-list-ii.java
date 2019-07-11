package lalgorithm.normal;/*
 * @lc app=leetcode id=82 lang=java
 *
 * [82] Remove Duplicates from Sorted List II
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
 *
 * algorithms
 * Medium (32.10%)
 * Total Accepted:    169.3K
 * Total Submissions: 525.5K
 * Testcase Example:  '[1,2,3,3,4,4,5]'
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * Example 1:
 * 
 * 
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 1->1->1->2->3
 * Output: 2->3
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode tmpHead = head;
        ListNode tmp;
        while (tmpHead.next != null && tmpHead.val == tmpHead.next.val){
            tmp = tmpHead.next;
            while (tmp != null && tmp.val == tmpHead.val){
                tmp = tmp.next;
            }
            if (tmp == null){
                return null;
            }
            tmpHead = tmp;
        }
        head = tmpHead;
        if (head.next == null){
            return head;
        }
        int count = 1;
        ListNode first, second;
        while (tmpHead != null && tmpHead.next != null){
            first = tmpHead.next;
            second = first.next;
            count = 1;
            while (second != null && second.val == first.val){
                count++;
                second = second.next;
            }
            if (count == 1){
                tmpHead = first;
            }else {
                tmpHead.next = second;
            }
        }
        return head;
    }
}
