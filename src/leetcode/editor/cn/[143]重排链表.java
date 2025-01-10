//<p>给定一个单链表 <code>L</code><em> </em>的头节点 <code>head</code> ，单链表 <code>L</code> 表示为：</p>
//
//<pre>
//L<sub>0</sub> → L<sub>1</sub> → … → L<sub>n - 1</sub> → L<sub>n</sub>
//</pre>
//
//<p>请将其重新排列后变为：</p>
//
//<pre>
//L<sub>0</sub> → L<sub>n</sub> → L<sub>1</sub> → L<sub>n - 1</sub> → L<sub>2</sub> → L<sub>n - 2</sub> → …</pre>
//
//<p>不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<p><img alt="" src="https://pic.leetcode-cn.com/1626420311-PkUiGI-image.png" style="width: 240px; " /></p>
//
//<pre>
//<strong>输入：</strong>head = [1,2,3,4]
//<strong>输出：</strong>[1,4,2,3]</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<p><img alt="" src="https://pic.leetcode-cn.com/1626420320-YUiulT-image.png" style="width: 320px; " /></p>
//
//<pre>
//<strong>输入：</strong>head = [1,2,3,4,5]
//<strong>输出：</strong>[1,5,2,4,3]</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li>链表的长度范围为 <code>[1, 5 * 10<sup>4</sup>]</code></li> 
// <li><code>1 &lt;= node.val &lt;= 1000</code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>栈</li><li>递归</li><li>链表</li><li>双指针</li></div></div><br><div><li>👍 1553</li><li>👎 0</li></div>

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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return ;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode pre = slow.next;
        while (pre != null && pre.next != null){
            ListNode temp = pre.next.next;
            pre.next.next = slow.next;
            slow.next = pre.next;
            pre.next = temp;
        }
        ListNode head1 = head;
        ListNode head2 = slow.next;
        slow.next = null;
        while (head2 != null){
            ListNode temp = head1.next;
            head1.next = head2;
            head1 = temp;
            temp = head2.next;
            head2.next = head1;
            head2 = temp;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
