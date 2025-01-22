//<p>给你二叉树的根节点 <code>root</code> ，返回它节点值的&nbsp;<strong>前序</strong><em>&nbsp;</em>遍历。</p>
//
//<p>&nbsp;</p>
//
//<p><strong class="example">示例 1：</strong></p>
//
//<div class="example-block"> 
// <p><strong>输入：</strong><span class="example-io">root = [1,null,2,3]</span></p> 
//</div>
//
//<p><strong>输出：</strong><span class="example-io">[1,2,3]</span></p>
//
//<p><strong>解释：</strong></p>
//
//<p><img alt="" src="https://assets.leetcode.com/uploads/2024/08/29/screenshot-2024-08-29-202743.png" style="width: 200px; height: 264px;" /></p>
//
//<p><strong class="example">示例 2：</strong></p>
//
//<div class="example-block"> 
// <p><span class="example-io"><b>输入：</b>root = [1,2,3,4,5,null,8,null,null,6,7,9]</span></p> 
//</div>
//
//<p><span class="example-io"><b>输出：</b>[1,2,4,5,6,7,3,8,9]</span></p>
//
//<p><strong>解释：</strong></p>
//
//<p><img alt="" src="https://assets.leetcode.com/uploads/2024/08/29/tree_2.png" style="width: 350px; height: 286px;" /></p>
//
//<p><strong class="example">示例 3：</strong></p>
//
//<div class="example-block"> 
// <p><span class="example-io"><b>输入：</b>root = []</span></p> 
//</div>
//
//<p><span class="example-io"><b>输出：</b>[]</span></p>
//
//<p><strong class="example">示例 4：</strong></p>
//
//<div class="example-block"> 
// <p><strong>输入：</strong><span class="example-io">root = [1]</span></p> 
//</div>
//
//<p><span class="example-io"><b>输出：</b>[1]</span></p>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li>树中节点数目在范围 <code>[0, 100]</code> 内</li> 
// <li><code>-100 &lt;= Node.val &lt;= 100</code></li> 
//</ul>
//
//<p>&nbsp;</p>
//
//<p><strong>进阶：</strong>递归算法很简单，你可以通过迭代算法完成吗？</p>
//
//<div><div>Related Topics</div><div><li>栈</li><li>树</li><li>深度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 1309</li><li>👎 0</li></div>

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
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root){
        if (root == null)
            return;
        res.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
