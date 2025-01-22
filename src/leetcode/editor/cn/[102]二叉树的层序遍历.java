//<p>给你二叉树的根节点 <code>root</code> ，返回其节点值的 <strong>层序遍历</strong> 。 （即逐层地，从左到右访问所有节点）。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p> 
//<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/tree1.jpg" style="width: 277px; height: 302px;" /> 
//<pre>
//<strong>输入：</strong>root = [3,9,20,null,null,15,7]
//<strong>输出：</strong>[[3],[9,20],[15,7]]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>root = [1]
//<strong>输出：</strong>[[1]]
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>root = []
//<strong>输出：</strong>[]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li>树中节点数目在范围 <code>[0, 2000]</code> 内</li> 
// <li><code>-1000 &lt;= Node.val &lt;= 1000</code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>树</li><li>广度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 2061</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        queue.offerLast(root);
        while (!queue.isEmpty()){
            int cnt = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < cnt; i++){
                TreeNode node = queue.pollFirst();
                temp.add(node.val);
                if (node.left != null)
                    queue.offerLast(node.left);
                if (node.right != null)
                    queue.offerLast(node.right);
            }
            res.add(temp);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
