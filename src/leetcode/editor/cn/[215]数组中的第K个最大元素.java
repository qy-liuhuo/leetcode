//<p>给定整数数组 <code>nums</code> 和整数 <code>k</code>，请返回数组中第 <code><strong>k</strong></code> 个最大的元素。</p>
//
//<p>请注意，你需要找的是数组排序后的第 <code>k</code> 个最大的元素，而不是第 <code>k</code> 个不同的元素。</p>
//
//<p>你必须设计并实现时间复杂度为 <code>O(n)</code> 的算法解决此问题。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1:</strong></p>
//
//<pre>
//<strong>输入:</strong> <span><code>[3,2,1,5,6,4],</code></span> k = 2
//<strong>输出:</strong> 5
//</pre>
//
//<p><strong>示例&nbsp;2:</strong></p>
//
//<pre>
//<strong>输入:</strong> <span><code>[3,2,3,1,2,4,5,5,6], </code></span>k = 4
//<strong>输出:</strong> 4</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示： </strong></p>
//
//<ul> 
// <li><code>1 &lt;= k &lt;= nums.length &lt;= 10<sup>5</sup></code></li> 
// <li><code>-10<sup>4</sup>&nbsp;&lt;= nums[i] &lt;= 10<sup>4</sup></code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>数组</li><li>分治</li><li>快速选择</li><li>排序</li><li>堆（优先队列）</li></div></div><br><div><li>👍 2595</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

//    public int findKthLargest(int[] nums, int k) {
//        Queue<Integer> queue = new PriorityQueue<>((a, b)->{
//            return b - a;
//        });
//        for(int i = 0; i < nums.length; i++){
//            queue.add(nums[i]);
//        }
//        for (int i = 0; i < k - 1; i++){
//            queue.poll();
//        }
//        return queue.poll();
//    }

//    public int findKthLargest(int[] nums, int k) {
//        Queue<Integer> queue = new PriorityQueue<>();
//        for (int i = 0; i < k; i++){
//            queue.add(nums[i]);
//        }
//        for(int i = k; i < nums.length; i++){
//            queue.add(nums[i]);
//            queue.poll();
//        }
//        return queue.poll();
//    }

    private Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    public int quickSelect(int[] nums, int left, int right, int k){
        int r = random.nextInt(right - left + 1) + left;
        swap(nums, left, r);
        int mid = nums[left];
        int i = left;
        int j = right;
        while (i < j){
            while (i < j && nums[j] >= mid)
                j--;
            while (i < j && nums[i] <= mid)
                i++;
            if (i < j)
                swap(nums, i, j);
        }
        swap(nums, left, i);
        if (right - i + 1 == k)
            return nums[i];
        else if(right - i + 1 > k){
            return quickSelect(nums, i + 1, right, k);
        }
        else {
            return quickSelect(nums, left, i - 1, k - (right - i + 1));
        }
    }

    public void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
