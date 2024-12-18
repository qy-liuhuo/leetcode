//<p>给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。</p>
//
//<p>请必须使用时间复杂度为 <code>O(log n)</code> 的算法。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1:</strong></p>
//
//<pre>
//<strong>输入:</strong> nums = [1,3,5,6], target = 5
//<strong>输出:</strong> 2
//</pre>
//
//<p><strong>示例&nbsp;2:</strong></p>
//
//<pre>
//<strong>输入:</strong> nums = [1,3,5,6], target = 2
//<strong>输出:</strong> 1
//</pre>
//
//<p><strong>示例 3:</strong></p>
//
//<pre>
//<strong>输入:</strong> nums = [1,3,5,6], target = 7
//<strong>输出:</strong> 4
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li> 
// <li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li> 
// <li><code>nums</code> 为&nbsp;<strong>无重复元素&nbsp;</strong>的&nbsp;<strong>升序&nbsp;</strong>排列数组</li> 
// <li><code>-10<sup>4</sup> &lt;= target &lt;= 10<sup>4</sup></code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>数组</li><li>二分查找</li></div></div><br><div><li>👍 2409</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }
    public int binarySearch(int[] nums, int target, int left, int right){
        if (left > right)
            return left;
        int mid = (right - left) / 2 + left;
        if (nums[mid] == target)
            return mid;
        else if (nums[mid] < target) {
            return binarySearch(nums, target, mid + 1, right);
        }
        else{
            return binarySearch(nums, target, left, mid - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
