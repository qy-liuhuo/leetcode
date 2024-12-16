//给你一个整数数组 <code>nums</code> 。如果任一值在数组中出现 <strong>至少两次</strong> ，返回 <code>true</code> ；如果数组中每个元素互不相同，返回 <code>false</code> 。
//
//<p>&nbsp;</p>
//
//<p><strong class="example">示例 1：</strong></p>
//
//<div class="example-block"> 
// <p><span class="example-io"><b>输入：</b>nums = [1,2,3,1]</span></p> 
//</div>
//
//<p><span class="example-io"><b>输出：</b>true</span></p>
//
//<p><strong>解释：</strong></p>
//
//<p>元素 1 在下标 0 和 3 出现。</p>
//
//<p><strong class="example">示例 2：</strong></p>
//
//<div class="example-block"> 
// <p><span class="example-io"><b>输入：</b>nums = [1,2,3,4]</span></p> 
//</div>
//
//<p><span class="example-io"><b>输出：</b>false</span></p>
//
//<p><strong>解释：</strong></p>
//
//<p>所有元素都不同。</p>
//
//<p><strong class="example">示例 3：</strong></p>
//
//<div class="example-block"> 
// <p><span class="example-io"><b>输入：</b>nums = [1,1,1,3,3,4,3,2,4,2]</span></p> 
//</div>
//
//<p><span class="example-io"><b>输出：</b>true</span></p>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li> 
// <li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>数组</li><li>哈希表</li><li>排序</li></div></div><br><div><li>👍 1108</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            if (set.contains(num))
                return true;
            set.add(num);
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
