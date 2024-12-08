//<p>给定一个包含红色、白色和蓝色、共&nbsp;<code>n</code><em> </em>个元素的数组
// <meta charset="UTF-8" />&nbsp;<code>nums</code>&nbsp;，<strong><a href="https://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95" target="_blank">原地</a>&nbsp;</strong>对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。</p>
//
//<p>我们使用整数 <code>0</code>、&nbsp;<code>1</code> 和 <code>2</code> 分别表示红色、白色和蓝色。</p>
//
//<ul> 
//</ul>
//
//<p>必须在不使用库内置的 sort 函数的情况下解决这个问题。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [2,0,2,1,1,0]
//<strong>输出：</strong>[0,0,1,1,2,2]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [2,0,1]
//<strong>输出：</strong>[0,1,2]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>n == nums.length</code></li> 
// <li><code>1 &lt;= n &lt;= 300</code></li> 
// <li><code>nums[i]</code> 为 <code>0</code>、<code>1</code> 或 <code>2</code></li> 
//</ul>
//
//<p>&nbsp;</p>
//
//<p><strong>进阶：</strong></p>
//
//<ul> 
// <li>你能想出一个仅使用常数空间的一趟扫描算法吗？</li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>数组</li><li>双指针</li><li>排序</li></div></div><br><div><li>👍 1858</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 记录个数解法
//    public void sortColors(int[] nums) {
//        int r = 0, w = 0, b = 0;
//        for (int num : nums) {
//            if (num == 0) {
//                r++;
//            } else if (num == 1) {
//                w++;
//            } else {
//                b++;
//            }
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (r > 0) {
//                nums[i] = 0;
//                r--;
//            } else if (w > 0) {
//                nums[i] = 1;
//                w--;
//            } else {
//                nums[i] = 2;
//            }
//        }
//    }

// 三路快排解法
//    public void sortColors(int[] nums) {
//        ThreeWayquickSort(nums, 0, nums.length - 1);
//    }
//    public void ThreeWayquickSort(int[] nums, int left, int right){
//        if(left >= right)
//            return;
//        int r = new Random().nextInt(right - left + 1) + left;
//        swap(nums, r, left);
//        int mid = nums[left];
//        int lower = left, larger = right + 1;
//        int i = left + 1;
//
//        while (i < larger){
//            if(nums[i] < mid){
//                swap(nums, i, lower + 1);
//                lower++;
//                i++;
//            }
//            else if(nums[i] > mid){
//                swap(nums, i, larger - 1);
//                larger--;
//            }
//            else{
//                i++;
//            }
//        }
//        swap(nums, left, lower);
//        ThreeWayquickSort(nums, left, lower - 1);
//        ThreeWayquickSort(nums, larger, right);
//    }
//
//    public void swap(int[] nums, int i, int j){
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }

    // 三路快排思想，一次三路快排即可解决
    public void sortColors(int[] nums) {
        int len = nums.length;
        int left = -1;
        int right = len;
        int i = left + 1;
        while (i < right){
            if(nums[i] == 0){
                swap(nums, i, left + 1);
                left++;
                i++;
            }
            else if(nums[i] == 2){
                swap(nums, i, right - 1);
                right--;
            }else {
                i++;
            }
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
