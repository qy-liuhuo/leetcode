//<p>给你一个整数数组 <code>nums</code><em> </em>，按要求返回一个新数组&nbsp;<code>counts</code><em> </em>。数组 <code>counts</code> 有该性质： <code>counts[i]</code> 的值是&nbsp; <code>nums[i]</code> 右侧小于&nbsp;<code>nums[i]</code> 的元素的数量。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [5,2,6,1]
//<strong>输出：</strong><span><code>[2,1,1,0] 
//<strong>解释：</strong></code></span>
//5 的右侧有 <strong>2 </strong>个更小的元素 (2 和 1)
//2 的右侧仅有 <strong>1 </strong>个更小的元素 (1)
//6 的右侧有 <strong>1 </strong>个更小的元素 (1)
//1 的右侧有 <strong>0 </strong>个更小的元素
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [-1]
//<strong>输出：</strong>[0]
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [-1,-1]
//<strong>输出：</strong>[0,0]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li> 
// <li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>树状数组</li><li>线段树</li><li>数组</li><li>二分查找</li><li>分治</li><li>有序集合</li><li>归并排序</li></div></div><br><div><li>👍 1108</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        List<Integer> res = new ArrayList<>(len);
        int[][] temp = new int[len][2];
        for(int i = 0; i < len; i++){
            temp[i][0] = nums[i];
            temp[i][1] = i;
            res.add(0);
        }
        mergeSort(temp, 0, len - 1, res);
        return res;
    }

    public void mergeSort(int[][] nums, int left, int right, List<Integer> res){
        if(left >= right)
            return;
        int mid = (right - left) / 2 + left;
        mergeSort(nums, left, mid, res);
        mergeSort(nums, mid + 1, right, res);
        int[][] left_nums = new int[mid - left + 1][2];
        int[][] right_nums = new int[right - mid][2];
        System.arraycopy(nums, left, left_nums, 0, mid - left + 1);
        System.arraycopy(nums, mid + 1, right_nums, 0, right - mid);
        int i = 0;
        int j = 0;
        int k = left;
        while (i < mid - left + 1 && j < right - mid){
            if(left_nums[i][0] > right_nums[j][0]){
                nums[k++] = right_nums[j++];
            }
            else {
                res.set(left_nums[i][1], res.get(left_nums[i][1]) + j);
                nums[k++] = left_nums[i++];
            }
        }
        while (i < mid - left + 1){
            res.set(left_nums[i][1], res.get(left_nums[i][1]) + right - mid);
            nums[k++] = left_nums[i++];
        }
        while (j < right - mid){
            nums[k++] = right_nums[j++];
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
