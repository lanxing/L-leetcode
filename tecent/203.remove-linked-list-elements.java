/*
 * @lc app=leetcode.cn id=203 lang=java
 *
 * [203] 移除链表元素
 *
 * https://leetcode-cn.com/problems/remove-linked-list-elements/description/
 *
 * algorithms
 * Easy (39.59%)
 * Total Accepted:    30.8K
 * Total Submissions: 73.7K
 * Testcase Example:  '[1,2,6,3,4,5,6]\n6'
 *
 * 删除链表中等于给定值 val 的所有节点。
 * 
 * 示例:
 * 
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode tmpHead = new ListNode(-1);
        tmpHead.next = head;
        ListNode first = tmpHead, second = first.next;
        while (second != null){
            if (second.val == val){
                first.next = second.next;
            }else {
                first = second;
            }
            second = first.next;
        }
        return tmpHead.next;
    }
}
