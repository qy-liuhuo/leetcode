//<p>编写一个函数来查找字符串数组中的最长公共前缀。</p>
//
//<p>如果不存在公共前缀，返回空字符串&nbsp;<code>""</code>。</p>
//
//<p>&nbsp;</p>
//
//<p><strong class="example">示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>strs = ["flower","flow","flight"]
//<strong>输出：</strong>"fl"
//</pre>
//
//<p><strong class="example">示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>strs = ["dog","racecar","car"]
//<strong>输出：</strong>""
//<strong>解释：</strong>输入不存在公共前缀。</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= strs.length &lt;= 200</code></li> 
// <li><code>0 &lt;= strs[i].length &lt;= 200</code></li> 
// <li><code>strs[i]</code>&nbsp;如果非空，则仅由小写英文字母组成</li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>字典树</li><li>字符串</li></div></div><br><div><li>👍 3260</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int i = 0;
        outerLoop:
        for (;i < strs[0].length(); i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j <strs.length; j++){
                if (i >= strs[j].length() || strs[j].charAt(i) != c)
                    break outerLoop;
            }
        }
        return strs[0].substring(0, i);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
