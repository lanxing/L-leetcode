/*
 * @lc app=leetcode.cn id=147 lang=java
 *
 * [147] 对链表进行插入排序
 *
 * https://leetcode-cn.com/problems/insertion-sort-list/description/
 *
 * algorithms
 * Medium (54.86%)
 * Total Accepted:    7.2K
 * Total Submissions: 12.4K
 * Testcase Example:  '[4,2,1,3]'
 *
 * 对链表进行插入排序。
 * 
 * 
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 * 
 * 
 * 
 * 插入排序算法：
 * 
 * 
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 
 * 
 * 示例 2：
 * 
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode cur = head;
        ListNode newHead = head;
        while (cur != null){
            ListNode tmp = cur.next;
            if (tmp == null){
                break;
            }
            if (tmp.val <= newHead.val){
                cur.next = tmp.next;
                tmp.next = newHead;
                newHead = tmp;
            }else {
                ListNode newHeadTmp = newHead;
                while (newHeadTmp.next != null &&  newHeadTmp.next != tmp && newHeadTmp.next.val <= tmp.val){
                    newHeadTmp = newHeadTmp.next;
                }
                if (newHeadTmp.next != null && newHeadTmp.next != tmp){
                    cur.next = tmp.next;
                    tmp.next = newHeadTmp.next;
                    newHeadTmp.next = tmp;
                }else {
                    cur = cur.next;
                }
            }
        }
        return newHead;
    }
}
