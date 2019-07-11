package lalgorithm.normal;/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
 *
 * https://leetcode-cn.com/problems/reorder-list/description/
 *
 * algorithms
 * Medium (47.95%)
 * Total Accepted:    5.3K
 * Total Submissions: 10.8K
 * Testcase Example:  '[1,2,3,4]'
 *
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 
 * 示例 1:
 * 
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 
 * 示例 2:
 * 
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null){
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head;
        while (fast.next != slow){
            fast = fast.next;
        }
        fast.next = null;
        ListNode tmp = reverse(slow);
        fast = head;
        slow = tmp;
        ListNode newNode = new ListNode(-1);
        ListNode n1 = newNode;
        while (slow != null && fast != null){
            n1.next = fast;
            fast = fast.next;
            n1.next.next = slow;
            slow = slow.next;
            n1 = n1.next.next;
        }
        if (slow != null){
            n1.next = slow;
        }
        if (fast != null){
            n1.next = fast;
        }
        head = newNode.next;
    }

    private ListNode reverse(ListNode head){
        ListNode first = head.next;
        ListNode last = head;
        last.next = null;
        ListNode next;
        while (first != null){
            next = first.next;
            first.next = last;
            last = first;
            first = next;
            if (first == null){
                return last;
            }
        }
        return last;
    }
}
