//<p>给出由小写字母组成的字符串&nbsp;<code>s</code>，<strong>重复项删除操作</strong>会选择两个相邻且相同的字母，并删除它们。</p>
//
//<p>在 <code>s</code> 上反复执行重复项删除操作，直到无法继续删除。</p>
//
//<p>在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例：</strong></p>
//
//<pre>
//<strong>输入：</strong>"abbaca"
//<strong>输出：</strong>"ca"
//<strong>解释：</strong>
//例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ol> 
// <li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li> 
// <li><code>s</code> 仅由小写英文字母组成。</li> 
//</ol>
//
//<div><div>Related Topics</div><div><li>栈</li><li>字符串</li></div></div><br><div><li>👍 668</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> queue = new ArrayDeque<>();
        for (char c : s.toCharArray()){
            if (queue.isEmpty()){
                queue.offerLast(c);
            }
            else{
                char temp = queue.peekLast();
                if (temp == c){
                    queue.pollLast();
                }else{
                    queue.offerLast(c);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            sb.append(queue.pollFirst());
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
