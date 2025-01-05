//<p>给定一个已排序的链表的头
// <meta charset="UTF-8" />&nbsp;<code>head</code>&nbsp;，&nbsp;<em>删除所有重复的元素，使每个元素只出现一次</em>&nbsp;。返回 <em>已排序的链表</em>&nbsp;。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p> 
//<img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/list1.jpg" style="height: 160px; width: 200px;" /> 
//<pre>
//<strong>输入：</strong>head = [1,1,2]
//<strong>输出：</strong>[1,2]
//</pre>
//
//<p><strong>示例 2：</strong></p> 
//<img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/list2.jpg" style="height: 123px; width: 300px;" /> 
//<pre>
//<strong>输入：</strong>head = [1,1,2,3,3]
//<strong>输出：</strong>[1,2,3]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li>链表中节点数目在范围 <code>[0, 300]</code> 内</li> 
// <li><code>-100 &lt;= Node.val &lt;= 100</code></li> 
// <li>题目数据保证链表已经按升序 <strong>排列</strong></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>链表</li></div></div><br><div><li>👍 1177</li><li>👎 0</li></div>

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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode l = head;
        ListNode r = head;
        while (r != null){
            while (r != null && l.val == r.val){
                r = r.next;
            }
            l.next = r;
            l = r;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
