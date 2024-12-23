//<p>给定一个长度为&nbsp;<code>n</code>&nbsp;的整数 <strong>山脉&nbsp;</strong>数组&nbsp;<code>arr</code>&nbsp;，其中的值递增到一个&nbsp;<strong>峰值元素</strong>&nbsp;然后递减。</p>
//
//<p>返回峰值元素的下标。</p>
//
//<p>你必须设计并实现时间复杂度为 <code>O(log(n))</code> 的解决方案。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>arr = [0,1,0]
//<strong>输出：</strong>1
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>arr = [0,2,1,0]
//<strong>输出：</strong>1
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>arr = [0,10,5,2]
//<strong>输出：</strong>1
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>3 &lt;= arr.length &lt;= 10<sup>5</sup></code></li> 
// <li><code>0 &lt;= arr[i] &lt;= 10<sup>6</sup></code></li> 
// <li>题目数据 <strong>保证</strong> <code>arr</code> 是一个山脉数组</li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>数组</li><li>二分查找</li></div></div><br><div><li>👍 417</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right){
            int mid = (right - left) / 2 + left;
            if (mid == 0)
                mid++;
            if (mid == arr.length - 1)
                mid--;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
                return mid;
            else if (arr[mid] > arr[mid - 1])
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
