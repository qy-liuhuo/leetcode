//<p>给定一个二进制数组&nbsp;<code>nums</code>&nbsp;和一个整数 <code>k</code>，假设最多可以翻转 <code>k</code> 个 <code>0</code> ，则返回执行操作后 <em>数组中连续 <code>1</code> 的最大个数</em> 。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
//<strong>输出：</strong>6
//<strong>解释：</strong>[1,1,1,0,0,<strong>1</strong>,1,1,1,1,<strong>1</strong>]
//粗体数字从 0 翻转到 1，最长的子数组长度为 6。</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
//<strong>输出：</strong>10
//<strong>解释：</strong>[0,0,1,1,<strong>1</strong>,<strong>1</strong>,1,1,1,<strong>1</strong>,1,1,0,0,0,1,1,1,1]
//粗体数字从 0 翻转到 1，最长的子数组长度为 10。</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li> 
// <li><code>nums[i]</code>&nbsp;不是&nbsp;<code>0</code>&nbsp;就是&nbsp;<code>1</code></li> 
// <li><code>0 &lt;= k &lt;= nums.length</code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>数组</li><li>二分查找</li><li>前缀和</li><li>滑动窗口</li></div></div><br><div><li>👍 749</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestOnes(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = 0;
        int num = 0;
        int res = 0;
        while (right < len){
            num += (1 - nums[right]);
            while (num > k){
                num -= (1 - nums[left++]);
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
