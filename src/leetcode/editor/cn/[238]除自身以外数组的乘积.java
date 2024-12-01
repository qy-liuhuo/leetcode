//<p>给你一个整数数组&nbsp;<code>nums</code>，返回 数组&nbsp;<code>answer</code>&nbsp;，其中&nbsp;<code>answer[i]</code>&nbsp;等于&nbsp;<code>nums</code>&nbsp;中除&nbsp;<code>nums[i]</code>&nbsp;之外其余各元素的乘积&nbsp;。</p>
//
//<p>题目数据 <strong>保证</strong> 数组&nbsp;<code>nums</code>之中任意元素的全部前缀元素和后缀的乘积都在&nbsp; <strong>32 位</strong> 整数范围内。</p>
//
//<p>请&nbsp;<strong>不要使用除法，</strong>且在&nbsp;<code>O(n)</code> 时间复杂度内完成此题。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1:</strong></p>
//
//<pre>
//<strong>输入:</strong> nums = <span><code>[1,2,3,4]</code></span>
//<strong>输出:</strong> <span><code>[24,12,8,6]</code></span>
//</pre>
//
//<p><strong>示例 2:</strong></p>
//
//<pre>
//<strong>输入:</strong> nums = [-1,1,0,-3,3]
//<strong>输出:</strong> [0,0,9,0,0]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>2 &lt;= nums.length &lt;= 10<sup>5</sup></code></li> 
// <li><code>-30 &lt;= nums[i] &lt;= 30</code></li> 
// <li><strong>保证</strong> 数组&nbsp;<code>nums</code>之中任意元素的全部前缀元素和后缀的乘积都在&nbsp; <strong>32 位</strong> 整数范围内</li> 
//</ul>
//
//<p>&nbsp;</p>
//
//<p><strong>进阶：</strong>你可以在 <code>O(1)</code>&nbsp;的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组&nbsp;<strong>不被视为&nbsp;</strong>额外空间。）</p>
//
//<div><div>Related Topics</div><div><li>数组</li><li>前缀和</li></div></div><br><div><li>👍 1907</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] res = new int[size];
        int post = 1;
        for(int i = size - 1; i >= 0; i--){
            res[i] = post;
            post = post * nums[i];
        }
        int pre = 1;
        for(int i = 0; i < size; i++){
            res[i] = pre * res[i];
            pre = pre * nums[i];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
