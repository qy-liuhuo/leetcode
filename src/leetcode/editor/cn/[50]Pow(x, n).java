//<p>实现&nbsp;<a href="https://www.cplusplus.com/reference/valarray/pow/" target="_blank">pow(<em>x</em>, <em>n</em>)</a>&nbsp;，即计算 <code>x</code> 的整数&nbsp;<code>n</code> 次幂函数（即，<code>x<sup>n</sup></code><sup><span style="font-size:10.8333px"> </span></sup>）。</p>
//
//<p>&nbsp;</p>
//
//<p><strong class="example">示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>x = 2.00000, n = 10
//<strong>输出：</strong>1024.00000
//</pre>
//
//<p><strong class="example">示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>x = 2.10000, n = 3
//<strong>输出：</strong>9.26100
//</pre>
//
//<p><strong class="example">示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>x = 2.00000, n = -2
//<strong>输出：</strong>0.25000
//<strong>解释：</strong>2<sup>-2</sup> = 1/2<sup>2</sup> = 1/4 = 0.25
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>-100.0 &lt; x &lt; 100.0</code></li> 
// <li><code>-2<sup>31</sup> &lt;= n &lt;= 2<sup>31</sup>-1</code></li> 
// <li><code>n</code>&nbsp;是一个整数</li> 
// <li>要么 <code>x</code> 不为零，要么 <code>n &gt; 0</code> 。</li> 
// <li><code>-10<sup>4</sup> &lt;= x<sup>n</sup> &lt;= 10<sup>4</sup></code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>递归</li><li>数学</li></div></div><br><div><li>👍 1422</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double myPow(double x, int n) {
        if(x == 0)
            return 0;
        long b = n;
        if (b < 0){
            x = 1 / x;
            b = -1 * b;
        }
        double res = 1;
        while (b!=0){
            if ((b & 1) == 1){
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
