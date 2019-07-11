package lalgorithm.normal;/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (32.56%)
 * Total Accepted:    334.7K
 * Total Submissions: 1M
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * Example:
 * 
 * 
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = minNode(lists);
        if (result == null){
            return result;
        }
        ListNode tmp = result;
        ListNode node = null;
        while ((node = minNode(lists)) != null){
            tmp.next = node;
            tmp = tmp.next;
        }
        return result;
    }

    private ListNode minNode(ListNode[] listNodes){
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < listNodes.length; ++i){
            ListNode tmp = listNodes[i];
            if (tmp == null){
                continue;
            }
            if (tmp.val < min){
                index = i;
                min = tmp.val;
            }
        }
        if (index > -1){
            ListNode node = listNodes[index];
            listNodes[index] = listNodes[index].next;
            return node;
        }
        return null;
    }
}
