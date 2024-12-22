//<p>已知存在一个按非降序排列的整数数组 <code>nums</code> ，数组中的值不必互不相同。</p>
//
//<p>在传递给函数之前，<code>nums</code> 在预先未知的某个下标 <code>k</code>（<code>0 &lt;= k &lt; nums.length</code>）上进行了 <strong>旋转 </strong>，使数组变为 <code>[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]</code>（下标 <strong>从 0 开始</strong> 计数）。例如， <code>[0,1,2,4,4,4,5,6,6,7]</code> 在下标 <code>5</code> 处经旋转后可能变为 <code>[4,5,6,6,7,0,1,2,4,4]</code> 。</p>
//
//<p>给你 <strong>旋转后</strong> 的数组 <code>nums</code> 和一个整数 <code>target</code> ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 <code>nums</code> 中存在这个目标值 <code>target</code> ，则返回 <code>true</code> ，否则返回 <code>false</code> 。</p>
//
//<p>你必须尽可能减少整个操作步骤。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例&nbsp;1：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = <span><code>[2,5,6,0,0,1,2]</code></span>, target = 0
//<strong>输出：</strong>true
//</pre>
//
//<p><strong>示例&nbsp;2：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = <span><code>[2,5,6,0,0,1,2]</code></span>, target = 3
//<strong>输出：</strong>false</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= nums.length &lt;= 5000</code></li> 
// <li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li> 
// <li>题目数据保证 <code>nums</code> 在预先未知的某个下标上进行了旋转</li> 
// <li><code>-10<sup>4</sup> &lt;= target &lt;= 10<sup>4</sup></code></li> 
//</ul>
//
//<p>&nbsp;</p>
//
//<p><strong>进阶：</strong></p>
//
//<ul> 
// <li>此题与&nbsp;<a href="https://leetcode-cn.com/problems/search-in-rotated-sorted-array/description/">搜索旋转排序数组</a>&nbsp;相似，但本题中的&nbsp;<code>nums</code>&nbsp; 可能包含 <strong>重复</strong> 元素。这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？</li> 
//</ul>
//
//<p>&nbsp;</p>
//
//<div><div>Related Topics</div><div><li>数组</li><li>二分查找</li></div></div><br><div><li>👍 799</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean search(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left <= right){
            int mid = (right - left) / 2 + left;
            int temp = nums[mid];
            if(temp == target){
                return true;
            }
            else if (temp == nums[left] && temp == nums[right]){
                right--;
                left++;
            }
            else if (temp <= nums[right]){
                if (temp > target){
                    right = mid - 1;
                }
                else if (temp < target){
                    if (target <= nums[right])
                        left = mid + 1;
                    else
                        right = mid - 1;
                }
            }
            else{
                if (temp < target){
                    left = mid + 1;
                }
                else if (temp > target){
                    if (target >= nums[left])
                        right = mid - 1;
                    else
                        left = mid + 1;
                }
            }

        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
