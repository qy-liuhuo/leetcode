//<p>闯关游戏需要破解一组密码，闯关组给出的有关密码的线索是：</p>
//
//<ul> 
// <li>一个拥有密码所有元素的非负整数数组 <code>password</code></li> 
// <li>密码是 <code>password</code> 中所有元素拼接后得到的最小的一个数</li> 
//</ul>
//
//<p>请编写一个程序返回这个密码。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1:</strong></p>
//
//<pre>
//<strong>输入: </strong>password = [15, 8, 7]
//<strong>输出: </strong>"1578"</pre>
//
//<p><strong>示例&nbsp;2:</strong></p>
//
//<pre>
//<strong>输入: </strong>password = [0, 3, 30, 34, 5, 9]
//<strong>输出: </strong>"03033459"</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示:</strong></p>
//
//<ul> 
// <li><code>0 &lt; password.length &lt;= 100</code></li> 
//</ul>
//
//<p><strong>说明: </strong></p>
//
//<ul> 
// <li>输出结果可能非常大，所以你需要返回一个字符串而不是整数</li> 
// <li>拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0</li> 
//</ul>
//
//<p>&nbsp;</p>
//
//<div><div>Related Topics</div><div><li>贪心</li><li>字符串</li><li>排序</li></div></div><br><div><li>👍 696</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String crackPassword(int[] password) {
        int len = password.length;
        String[] passwords = new String[len];
        for(int i = 0; i < len; i++){
            passwords[i] = Integer.toString(password[i]);
        }
        Arrays.sort(passwords, (a, b) -> {
            return (a + b).compareTo(b + a);
        });
        StringBuilder sb = new StringBuilder();
        for(String s : passwords){
            sb.append(s);
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
