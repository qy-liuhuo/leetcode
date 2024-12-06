//<p>给你一个整数数组&nbsp;<code>nums</code>，请你将该数组升序排列。</p>
//
//<p>你必须在 <strong>不使用任何内置函数</strong> 的情况下解决问题，时间复杂度为 <code>O(nlog(n))</code>，并且空间复杂度尽可能小。</p>
//
//<p>&nbsp;</p>
//
//<ol> 
//</ol>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [5,2,3,1]
//<strong>输出：</strong>[1,2,3,5]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [5,1,1,2,0,0]
//<strong>输出：</strong>[0,0,1,1,2,5]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= nums.length &lt;= 5 * 10<sup>4</sup></code></li> 
// <li><code>-5 * 10<sup>4</sup> &lt;= nums[i] &lt;= 5 * 10<sup>4</sup></code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>数组</li><li>分治</li><li>桶排序</li><li>计数排序</li><li>基数排序</li><li>排序</li><li>堆（优先队列）</li><li>归并排序</li></div></div><br><div><li>👍 1056</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private Random random = new Random();
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    public void quickSort(int[] nums, int left, int right){
        if (left >= right)
            return;
        int r = random.nextInt(right-left+1)+left;
        swap(nums, left, r);
        int mid = nums[left];
        int i = left;
        int j = right;
        while (i<j){
            while (i < j && nums[j] > mid)
                j--;
            while (i < j && nums[i] <= mid)
                i++;
            if (i < j){
                swap(nums, i, j);
            }
        }
        swap(nums, i, left);
        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
    }

    public void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
