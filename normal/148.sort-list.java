package lalgorithm.normal;/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
 *
 * https://leetcode-cn.com/problems/sort-list/description/
 *
 * algorithms
 * Medium (58.60%)
 * Total Accepted:    14.1K
 * Total Submissions: 23.3K
 * Testcase Example:  '[4,2,1,3]'
 *
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * 
 * 示例 1:
 * 
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 
 * 
 * 示例 2:
 * 
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
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
    public ListNode sortList(ListNode head) {
        return sort(head);
    }

    public ListNode sort(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode first = head;
        ListNode second = findMid(head);
        first = sort(first);
        second = sort(second);
        return merge(first, second);
    }

    public ListNode merge(ListNode first, ListNode second){
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        while (first != null && second != null){
            if (first.val < second.val){
                tmp.next = first;
                first = first.next;
            }else {
                tmp.next = second;
                second = second.next;
            }
            tmp = tmp.next;
        }
        if (first != null){
            tmp.next = first;
        }
        if (second != null){
            tmp.next = second;
        }
        return newHead.next;
    }

    public ListNode findMid(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = null;
        return slow;
    }
}
