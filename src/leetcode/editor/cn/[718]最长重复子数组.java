//<p>给两个整数数组&nbsp;<code>nums1</code>&nbsp;和&nbsp;<code>nums2</code>&nbsp;，返回 <em>两个数组中 <strong>公共的</strong> 、长度最长的子数组的长度&nbsp;</em>。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
//<strong>输出：</strong>3
//<strong>解释：</strong>长度最长的公共子数组是 [3,2,1] 。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
//<strong>输出：</strong>5
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= nums1.length, nums2.length &lt;= 1000</code></li> 
// <li><code>0 &lt;= nums1[i], nums2[i] &lt;= 100</code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>数组</li><li>二分查找</li><li>动态规划</li><li>滑动窗口</li><li>哈希函数</li><li>滚动哈希</li></div></div><br><div><li>👍 1142</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        int res = 0;
        for (int i = 1; i <= len1; i++){
            for (int j = 1; j <= len2; j++){
                if (nums1[i - 1] == nums2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else{
                    dp[i][j] = 0;
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
