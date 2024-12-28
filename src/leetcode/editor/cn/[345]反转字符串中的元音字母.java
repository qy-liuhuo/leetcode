//<p>给你一个字符串 <code>s</code> ，仅反转字符串中的所有元音字母，并返回结果字符串。</p>
//
//<p>元音字母包括 <code>'a'</code>、<code>'e'</code>、<code>'i'</code>、<code>'o'</code>、<code>'u'</code>，且可能以大小写两种形式出现不止一次。</p>
//
//<p>&nbsp;</p>
//
//<p><strong class="example">示例 1：</strong></p>
//
//<div class="example-block"> 
// <p><strong>输入：</strong><span class="example-io">s = "IceCreAm"</span></p> 
//</div>
//
//<p><span class="example-io"><b>输出：</b>"AceCreIm"</span></p>
//
//<p><strong>解释：</strong></p>
//
//<p><code>s</code>&nbsp;中的元音是&nbsp;<code>['I', 'e', 'e', 'A']</code>。反转这些元音，<code>s</code> 变为&nbsp;<code>"AceCreIm"</code>.</p>
//
//<p><strong class="example">示例 2：</strong></p>
//
//<div class="example-block"> 
// <p><span class="example-io"><b>输入：</b>s = "leetcode"</span></p> 
//</div>
//
//<p><strong>输出：</strong><span class="example-io">"leotcede"</span></p>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= s.length &lt;= 3 * 10<sup>5</sup></code></li> 
// <li><code>s</code> 由 <strong>可打印的 ASCII</strong> 字符组成</li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>双指针</li><li>字符串</li></div></div><br><div><li>👍 365</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseVowels(String s) {
        Set<Character> char_set = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        char[] arr = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right){
            while (left < right && !char_set.contains(arr[left]))
                left++;
            while (left < right && !char_set.contains(arr[right]))
                right--;
            if (left < right)
            {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return  new String(arr);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
