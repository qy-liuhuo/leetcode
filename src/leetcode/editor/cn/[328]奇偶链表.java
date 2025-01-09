//<p>给定单链表的头节点&nbsp;<code>head</code>&nbsp;，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。</p>
//
//<p><strong>第一个</strong>节点的索引被认为是 <strong>奇数</strong> ， <strong>第二个</strong>节点的索引为&nbsp;<strong>偶数</strong> ，以此类推。</p>
//
//<p>请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。</p>
//
//<p>你必须在&nbsp;<code>O(1)</code>&nbsp;的额外空间复杂度和&nbsp;<code>O(n)</code>&nbsp;的时间复杂度下解决这个问题。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1:</strong></p>
//
//<p><img src="https://assets.leetcode.com/uploads/2021/03/10/oddeven-linked-list.jpg" style="height: 123px; width: 300px;" /></p>
//
//<pre>
//<strong>输入: </strong>head = [1,2,3,4,5]
//<strong>输出:</strong>&nbsp;[1,3,5,2,4]</pre>
//
//<p><strong>示例 2:</strong></p>
//
//<p><img src="https://assets.leetcode.com/uploads/2021/03/10/oddeven2-linked-list.jpg" style="height: 142px; width: 500px;" /></p>
//
//<pre>
//<strong>输入:</strong> head = [2,1,3,5,6,4,7]
//<strong>输出:</strong> [2,3,6,7,1,5,4]</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示:</strong></p>
//
//<ul> 
// <li><code>n ==&nbsp;</code> 链表中的节点数</li> 
// <li><code>0 &lt;= n &lt;= 10<sup>4</sup></code></li> 
// <li><code>-10<sup>6</sup>&nbsp;&lt;= Node.val &lt;= 10<sup>6</sup></code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>链表</li></div></div><br><div><li>👍 818</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode a = head;
        ListNode b = head.next;
        ListNode head2 = b;
        while (a != null && b != null){
            a.next = b.next;
            if (a.next == null)
                break;
            a = a.next;
            b.next = a.next;
            b = b.next;
        }
        a.next = head2;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
