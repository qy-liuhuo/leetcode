//<p>给定两个整数数组&nbsp;<code>preorder</code> 和 <code>inorder</code>&nbsp;，其中&nbsp;<code>preorder</code> 是二叉树的<strong>先序遍历</strong>， <code>inorder</code>&nbsp;是同一棵树的<strong>中序遍历</strong>，请构造二叉树并返回其根节点。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1:</strong></p> 
//<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/tree.jpg" style="height: 302px; width: 277px;" /> 
//<pre>
//<strong>输入</strong><strong>:</strong> preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//<strong>输出:</strong> [3,9,20,null,null,15,7]
//</pre>
//
//<p><strong>示例 2:</strong></p>
//
//<pre>
//<strong>输入:</strong> preorder = [-1], inorder = [-1]
//<strong>输出:</strong> [-1]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= preorder.length &lt;= 3000</code></li> 
// <li><code>inorder.length == preorder.length</code></li> 
// <li><code>-3000 &lt;= preorder[i], inorder[i] &lt;= 3000</code></li> 
// <li><code>preorder</code>&nbsp;和&nbsp;<code>inorder</code>&nbsp;均 <strong>无重复</strong> 元素</li> 
// <li><code>inorder</code>&nbsp;均出现在&nbsp;<code>preorder</code></li> 
// <li><code>preorder</code>&nbsp;<strong>保证</strong> 为二叉树的前序遍历序列</li> 
// <li><code>inorder</code>&nbsp;<strong>保证</strong> 为二叉树的中序遍历序列</li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>树</li><li>数组</li><li>哈希表</li><li>分治</li><li>二叉树</li></div></div><br><div><li>👍 2451</li><li>👎 0</li></div>

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
    private int[] preorder;

    private int[] inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        return buildTree(0, preorder.length - 1, 0, inorder.length - 1);
    }
    public TreeNode buildTree(int pre_left, int pre_right, int in_left, int in_right){
        if (pre_left > pre_right)
            return null;
        TreeNode root = new TreeNode(preorder[pre_left]);
        int i = in_left;
        while (inorder[i] != preorder[pre_left]){
            i++;
        }
        root.left = buildTree(pre_left + 1, pre_left + i - in_left, in_left, i - 1);
        root.right = buildTree(pre_left + i - in_left + 1, pre_right, i + 1, in_right);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
