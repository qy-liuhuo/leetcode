//<p>给定一组非负整数 <code>nums</code>，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。</p>
//
//<p><strong>注意：</strong>输出结果可能非常大，所以你需要返回一个字符串而不是整数。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入<code>：</code></strong><span><code>nums = [10,2]</code></span>
//<strong>输出：</strong><span><code>"210"</code></span></pre>
//
//<p><strong>示例&nbsp;2：</strong></p>
//
//<pre>
//<strong>输入<code>：</code></strong><span><code>nums = [3,30,34,5,9]</code></span>
//<strong>输出：</strong><span><code>"9534330"</code></span>
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= nums.length &lt;= 100</code></li> 
// <li><code>0 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>贪心</li><li>数组</li><li>字符串</li><li>排序</li></div></div><br><div><li>👍 1311</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String largestNumber(int[] nums) {
        String[] nums_str = new String[nums.length];
        for (int i = 0; i < nums.length; i++){
            nums_str[i] = Integer.toString(nums[i]);
        }
        // 注意sort 不能排序基本数据类型！！
        Arrays.sort(nums_str, (a, b) -> {
            return (b + a).compareTo(a + b);
        });
        StringBuilder sb = new StringBuilder();
        for (String num : nums_str){
            sb.append(num);
        }
        String res = sb.toString();
        return res.charAt(0) == '0' ? "0" : res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
