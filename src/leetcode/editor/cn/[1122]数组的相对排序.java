//<p>给你两个数组，<code>arr1</code> 和&nbsp;<code>arr2</code>，<code>arr2</code>&nbsp;中的元素各不相同，<code>arr2</code> 中的每个元素都出现在&nbsp;<code>arr1</code>&nbsp;中。</p>
//
//<p>对 <code>arr1</code>&nbsp;中的元素进行排序，使 <code>arr1</code> 中项的相对顺序和&nbsp;<code>arr2</code>&nbsp;中的相对顺序相同。未在&nbsp;<code>arr2</code>&nbsp;中出现过的元素需要按照升序放在&nbsp;<code>arr1</code>&nbsp;的末尾。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//<strong>输出：</strong>[2,2,2,1,4,3,3,9,6,7,19]
//</pre>
//
//<p><strong>示例 &nbsp;2:</strong></p>
//
//<pre>
//<strong>输入：</strong>arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
//<strong>输出：</strong>[22,28,8,6,17,44]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= arr1.length, arr2.length &lt;= 1000</code></li> 
// <li><code>0 &lt;= arr1[i], arr2[i] &lt;= 1000</code></li> 
// <li><code>arr2</code>&nbsp;中的元素&nbsp;<code>arr2[i]</code>&nbsp;&nbsp;<strong>各不相同</strong>&nbsp;</li> 
// <li><code>arr2</code> 中的每个元素&nbsp;<code>arr2[i]</code>&nbsp;都出现在&nbsp;<code>arr1</code>&nbsp;中</li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>数组</li><li>哈希表</li><li>计数排序</li><li>排序</li></div></div><br><div><li>👍 303</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int[] res = new int[len1];
        int[] freq = new int[1001];
        for(int i = 0; i < len1; i++){
            freq[arr1[i]]++;
        }
        int k = 0;
        for (int i = 0; i < len2; i++){
            for(int j = 0; j < freq[arr2[i]]; j++){
                res[k++] = arr2[i];
            }
            freq[arr2[i]] = 0;
        }
        for (int i = 0; i < 1001; i++){
            for(int j = 0; j < freq[i]; j++){
                res[k++] = i;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
