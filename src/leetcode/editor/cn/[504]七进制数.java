//<p>给定一个整数 <code>num</code>，将其转化为 <strong>7 进制</strong>，并以字符串形式输出。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1:</strong></p>
//
//<pre>
//<strong>输入:</strong> num = 100
//<strong>输出:</strong> "202"
//</pre>
//
//<p><strong>示例 2:</strong></p>
//
//<pre>
//<strong>输入:</strong> num = -7
//<strong>输出:</strong> "-10"
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>-10<sup>7</sup>&nbsp;&lt;= num &lt;= 10<sup>7</sup></code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>数学</li></div></div><br><div><li>👍 225</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convertToBase7(int num) {
        if (num == 0)
            return "0";
        StringBuilder sb = new StringBuilder();
        int flag = 0;
        if (num < 0){
            flag = 1;
            num = -num;
        }
        while (num != 0){
            sb.append(String.valueOf(num % 7));
            num /= 7;
        }
        if (flag == 1)
            sb.append("-");
        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
