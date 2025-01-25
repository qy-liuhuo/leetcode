//<p>给你两个整数 <code>a</code> 和 <code>b</code> ，<strong>不使用 </strong>运算符&nbsp;<code>+</code> 和&nbsp;<code>-</code>&nbsp;​​​​​​​，计算并返回两整数之和。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>a = 1, b = 2
//<strong>输出：</strong>3
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>a = 2, b = 3
//<strong>输出：</strong>5
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>-1000 &lt;= a, b &lt;= 1000</code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>位运算</li><li>数学</li></div></div><br><div><li>👍 750</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
