//<p>（这是一个 <strong>交互式问题&nbsp;</strong>）</p>
//
//<p>你可以将一个数组&nbsp;<code>arr</code>&nbsp;称为&nbsp;<strong>山脉数组&nbsp;</strong>当且仅当：</p>
//
//<ul> 
// <li><code>arr.length &gt;= 3</code></li> 
// <li>存在一些&nbsp;<code>0 &lt; i &lt; arr.length - 1</code>&nbsp;的&nbsp;<code>i</code>&nbsp;使得： 
//  <ul> 
//   <li><code>arr[0] &lt; arr[1] &lt; ... &lt; arr[i - 1] &lt; arr[i]</code></li> 
//   <li><code>arr[i] &gt; arr[i + 1] &gt; ... &gt; arr[arr.length - 1]</code></li> 
//  </ul> </li> 
//</ul>
//
//<p>给定一个山脉数组&nbsp;<code>mountainArr</code>&nbsp;，返回&nbsp;<strong>最小</strong> 的&nbsp;<code>index</code>&nbsp;使得&nbsp;<code>mountainArr.get(index) == target</code>。如果不存在这样的&nbsp;<code>index</code>，返回&nbsp;<code>-1</code>&nbsp;。</p>
//
//<p><strong>你无法直接访问山脉数组</strong>。你只能使用&nbsp;<code>MountainArray</code>&nbsp;接口来访问数组：</p>
//
//<ul> 
// <li><code>MountainArray.get(k)</code>&nbsp;返回数组中下标为&nbsp;<code>k</code>&nbsp;的元素（从 0 开始）。</li> 
// <li><code>MountainArray.length()</code>&nbsp;返回数组的长度。</li> 
//</ul>
//
//<p>调用&nbsp;<code>MountainArray.get</code>&nbsp;超过&nbsp;<code>100</code>&nbsp;次的提交会被判定为错误答案。此外，任何试图绕过在线评测的解决方案都将导致取消资格。</p>
//
//<ol> 
//</ol>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>mountainArr = [1,2,3,4,5,3,1], target = 3
//<strong>输出：</strong>2
//<strong>解释：</strong>3 在数组中出现了两次，下标分别为 2 和 5，我们返回最小的下标 2。</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>mountainArr = [0,1,2,4,2,1], target = 3
//<strong>输出：</strong>-1
//<strong>解释：</strong>3 在数组中没有出现，返回 -1。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>3 &lt;= mountainArr.length() &lt;= 10<sup>4</sup></code></li> 
// <li><code>0 &lt;= target &lt;= 10<sup>9</sup></code></li> 
// <li><code>0 &lt;= mountainArr.get(index) &lt;=&nbsp;10<sup>9</sup></code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>数组</li><li>二分查找</li><li>交互</li></div></div><br><div><li>👍 197</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();
        int left = 0;
        int right = len - 1;
        while (left < right){
            int mid = (right - left) / 2 + left;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        int top = mountainArr.get(left);
        int temp = binarySearch(target, mountainArr, 0, left, false);
        if (temp != -1)
            return temp;
        else
            return binarySearch(target, mountainArr, left, len - 1, true);
    }

    public int binarySearch(int target, MountainArray arr, int left, int right, boolean reverse){
        while (left <= right){
            int mid = (right - left) / 2 + left;
            int temp = arr.get(mid);
            if (temp == target)
                return mid;
            else{
                if (reverse){
                    if (temp > target)
                        left = mid + 1;
                    else
                        right = mid - 1;
                }else {
                    if (temp < target)
                        left = mid + 1;
                    else
                        right = mid - 1;
                }
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
