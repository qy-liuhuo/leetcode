//<p>给定一个大小为 <code>n</code><em> </em>的数组&nbsp;<code>nums</code> ，返回其中的多数元素。多数元素是指在数组中出现次数 <strong>大于</strong>&nbsp;<code>⌊ n/2 ⌋</code>&nbsp;的元素。</p>
//
//<p>你可以假设数组是非空的，并且给定的数组总是存在多数元素。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例&nbsp;1：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [3,2,3]
//<strong>输出：</strong>3</pre>
//
//<p><strong>示例&nbsp;2：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [2,2,1,1,1,2,2]
//<strong>输出：</strong>2
//</pre>
//
//<p>&nbsp;</p> 
//<strong>提示：</strong>
//
//<ul> 
// <li><code>n == nums.length</code></li> 
// <li><code>1 &lt;= n &lt;= 5 * 10<sup>4</sup></code></li> 
// <li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li> 
//</ul>
//
//<p>&nbsp;</p>
//
//<p><strong>进阶：</strong>尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。</p>
//
//<div><div>Related Topics</div><div><li>数组</li><li>哈希表</li><li>分治</li><li>计数</li><li>排序</li></div></div><br><div><li>👍 2344</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)


//class Solution {
//    排序算法
//    public int majorityElement(int[] nums) {
//        Arrays.sort(nums);
//        return nums[nums.length / 2];
//    }
//}

//class Solution {
//    随机算法
//    public int majorityElement(int[] nums) {
//        Random random = new Random();
//        int len = nums.length;
//        while (true){
//            int temp = nums[random.nextInt(len)];
//            int cnt = 0;
//            for(int i = 0; i < len; i++){
//                if (nums[i] == temp)
//                    cnt++;
//            }
//            if (cnt > len / 2)
//                return temp;
//        }
//    }
//}

class Solution {

    //Boyer-Moore 投票算法
    public int majorityElement(int[] nums) {
        int r = nums[0], cnt = 0;
        for(int i = 0; i < nums.length; i++){
            if (cnt == 0){
                r = nums[i];
                cnt = 1;
            }
            else if (nums[i] == r){
                cnt++;
            }
            else {
                cnt--;
            }
        }
        return r;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
