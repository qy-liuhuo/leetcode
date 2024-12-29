//<p>给定一个包含非负整数的数组&nbsp;<code>nums</code> ，返回其中可以组成三角形三条边的三元组个数。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1:</strong></p>
//
//<pre>
//<strong>输入:</strong> nums = [2,2,3,4]
//<strong>输出:</strong> 3
//<strong>解释:</strong>有效的组合是: 
//2,3,4 (使用第一个 2)
//2,3,4 (使用第二个 2)
//2,2,3
//</pre>
//
//<p><strong>示例 2:</strong></p>
//
//<pre>
//<strong>输入:</strong> nums = [4,2,3,4]
//<strong>输出:</strong> 4</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= nums.length &lt;= 1000</code></li> 
// <li><code>0 &lt;= nums[i] &lt;= 1000</code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>贪心</li><li>数组</li><li>双指针</li><li>二分查找</li><li>排序</li></div></div><br><div><li>👍 606</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int triangleNumber(int[] nums) {
        int len = nums.length;
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < len ; i++){
            for (int j = i + 1; j < len; j++){
                int index = binarySearchLess(nums, j + 1, len - 1, nums[i] + nums[j]);
                res += index - j;
            }
        }
        return res;
    }
    public int binarySearchLess(int[] nums, int left, int right, int target){
        int index = left - 1;
        while (left <= right){
            int mid = (right - left) / 2 + left;
            if (nums[mid] < target){
                index = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return index;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
