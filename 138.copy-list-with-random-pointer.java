import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 复制带随机指针的链表
 *
 * https://leetcode-cn.com/problems/copy-list-with-random-pointer/description/
 *
 * algorithms
 * Medium (25.46%)
 * Total Accepted:    6.9K
 * Total Submissions: 22.2K
 * Testcase Example:  '{"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}'
 *
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * 
 * 要求返回这个链表的深拷贝。 
 * 
 * 
 * 
 * 示例：
 * 
 * 
 * 
 * 输入：
 * 
 * {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
 * 
 * 解释：
 * 节点 1 的值是 1，它的下一个指针和随机指针都指向节点 2 。
 * 节点 2 的值是 2，它的下一个指针指向 null，随机指针指向它自己。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 你必须返回给定头的拷贝作为对克隆列表的引用。
 * 
 * 
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null){
            return head;
        }
        Map<Node, Node> map = new HashMap<>();
        Node newHead = new Node();
        newHead.val = head.val;
        map.put(head, newHead);
        Node oldHead = head.next;
        Node newHeadTmp = newHead;
        while (oldHead != null){
            Node tmp = new Node();
            tmp.val = oldHead.val;
            map.put(oldHead, tmp);
            newHeadTmp.next = tmp;
            newHeadTmp = newHeadTmp.next;
            oldHead = oldHead.next;
        }
        oldHead = head;
        newHeadTmp = newHead;
        while (oldHead != null){
            if (oldHead.random != null){
                newHeadTmp.random = map.get(oldHead.random);
            }
            oldHead = oldHead.next;
            newHeadTmp = newHeadTmp.next;
        }
        return newHead;
    }
}
