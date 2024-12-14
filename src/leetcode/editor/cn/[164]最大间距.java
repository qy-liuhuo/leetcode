//<p>给定一个无序的数组&nbsp;<code>nums</code>，返回 <em>数组在排序之后，相邻元素之间最大的差值</em> 。如果数组元素个数小于 2，则返回 <code>0</code> 。</p>
//
//<p>您必须编写一个在「线性时间」内运行并使用「线性额外空间」的算法。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例&nbsp;1:</strong></p>
//
//<pre>
//<strong>输入:</strong> nums = [3,6,9,1]
//<strong>输出:</strong> 3
//<strong>解释:</strong> 排序后的数组是 [1,3,6,9]<strong><em>, </em></strong>其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。</pre>
//
//<p><strong>示例&nbsp;2:</strong></p>
//
//<pre>
//<strong>输入:</strong> nums = [10]
//<strong>输出:</strong> 0
//<strong>解释:</strong> 数组元素个数小于 2，因此返回 0。</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li> 
// <li><code>0 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>数组</li><li>桶排序</li><li>基数排序</li><li>排序</li></div></div><br><div><li>👍 637</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 基数排序
    public int maximumGap(int[] nums) {
        int len = nums.length;
        if (len < 2)
            return 0;
        int max = nums[0];
        for (int num : nums){
            max = Math.max(max, num);
        }
        int[] buf = new int[len];
        int e = 1;
        while (e <= max){
            int[] cnt = new int[10];
            for(int num : nums){
                cnt[((num / e) % 10)]++;
            }
            for (int i = 1; i < 10; i++){
                cnt[i] += cnt[i - 1];
            }
            //注意要反着放回去
            for (int i = len - 1; i >= 0; i--){
                buf[--cnt[(nums[i] / e) % 10]] = nums[i];
            }
            System.arraycopy(buf, 0, nums, 0, len);
            e *= 10;
        }
        int res = 0;
        for (int i = 1; i < len; i++){
            res = Math.max(res, nums[i] - nums[i - 1]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
