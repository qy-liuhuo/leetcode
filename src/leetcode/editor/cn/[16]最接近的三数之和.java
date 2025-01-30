//<p>给你一个长度为 <code>n</code> 的整数数组&nbsp;<code>nums</code><em>&nbsp;</em>和 一个目标值&nbsp;<code>target</code>。请你从 <code>nums</code><em> </em>中选出三个整数，使它们的和与&nbsp;<code>target</code>&nbsp;最接近。</p>
//
//<p>返回这三个数的和。</p>
//
//<p>假定每组输入只存在恰好一个解。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [-1,2,1,-4], target = 1
//<strong>输出：</strong>2
//<strong>解释：</strong>与 target 最接近的和是 2 (-1 + 2 + 1 = 2)。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [0,0,0], target = 1
//<strong>输出：</strong>0
//<strong>解释：</strong>与 target 最接近的和是 0（0 + 0 + 0 = 0）。</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>3 &lt;= nums.length &lt;= 1000</code></li> 
// <li><code>-1000 &lt;= nums[i] &lt;= 1000</code></li> 
// <li><code>-10<sup>4</sup> &lt;= target &lt;= 10<sup>4</sup></code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>数组</li><li>双指针</li><li>排序</li></div></div><br><div><li>👍 1692</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int[] nums;
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        this.nums = nums;
        int res = Integer.MAX_VALUE;
        int temp;
        for (int i = 0; i < len - 2; i++){
            for (int j = i + 1; j < len -1; j++){
                temp = nums[i] + nums[j];
                int a = searchFloor(target - temp, j + 1);
                int b = searchHigher(target - temp, j + 1);
                if (a != -1)
                    res = Math.abs(target - res) > Math.abs(target - (nums[a] + temp)) ? nums[a] + temp : res;
                if (b != -1)
                    res = Math.abs(target - res) > Math.abs(target - (nums[b] + temp)) ? nums[b] + temp : res;
            }
        }
        return res;
    }
    public int searchFloor(int target, int left) {
        int right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = (right - left)/2 + left;
            if (nums[mid] <= target){
                index = mid;
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return index;
    }
    public int searchHigher(int target, int left) {
        int right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = (right - left)/2 + left;
            if (nums[mid] >= target){
                index = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return index;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
