//<p>数字 <code>n</code>&nbsp;代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 <strong>有效的 </strong>括号组合。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>n = 3
//<strong>输出：</strong>["((()))","(()())","(())()","()(())","()()()"]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>n = 1
//<strong>输出：</strong>["()"]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= n &lt;= 8</code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>字符串</li><li>动态规划</li><li>回溯</li></div></div><br><div><li>👍 3760</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private List<String> res = new ArrayList<>();

    private StringBuilder sb = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        backtrace(0, 0, n);
        return res;
    }

    public void backtrace(int leftCnt, int rightCnt, int n){
        if (leftCnt == n && rightCnt == n){
            res.add(sb.toString());
            return;
        }
        if (leftCnt < n){
            sb.append("(");
            backtrace(leftCnt+1, rightCnt, n);
            sb.deleteCharAt(sb.length() - 1);
        }if (leftCnt > rightCnt){
            sb.append(")");
            backtrace(leftCnt, rightCnt+1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
