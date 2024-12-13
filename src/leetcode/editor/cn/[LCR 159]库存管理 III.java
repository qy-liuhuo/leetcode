//<p>仓库管理员以数组 <code>stock</code> 形式记录商品库存表，其中 <code>stock[i]</code> 表示对应商品库存余量。请返回库存余量最少的 <code>cnt</code> 个商品余量，返回&nbsp;<strong>顺序不限</strong>。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>stock = [2,5,7,4], cnt = 1
//<strong>输出：</strong>[2]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>stock = [0,2,3,6], cnt = 2
//<strong>输出：</strong>[0,2] 或 [2,0]</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>0 &lt;= cnt &lt;= stock.length &lt;= 10000<br /> 0 &lt;= stock[i] &lt;= 10000</code></li> 
//</ul>
//
//<p>&nbsp;</p>
//
//<div><div>Related Topics</div><div><li>数组</li><li>分治</li><li>快速选择</li><li>排序</li><li>堆（优先队列）</li></div></div><br><div><li>👍 595</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 优先队列解法
//    public int[] inventoryManagement(int[] stock, int cnt) {
//        int[] res = new int[cnt];
//        Queue<Integer> queue = new PriorityQueue<>((Integer a, Integer b) ->{
//            return b - a;
//        });
//        for(int i = 0; i < stock.length; i++){
//            queue.add(stock[i]);
//            if (i >= cnt)
//                queue.poll();
//        }
//        for (int i = 0; i < cnt; i++){
//            res[i] = queue.poll();
//        }
//        return res;
//    }
        // 快速选择算法
        private Random random = new Random();
        public int[] inventoryManagement(int[] stock, int cnt) {
            if (cnt == 0)
                return new int[0];
            quickFind(stock, 0, stock.length - 1, cnt);
            int[] res = new int[cnt];
            for (int i = 0; i < cnt; i++){
                res[i] = stock[i];
            }
            return res;
        }
        public void quickFind(int[] nums, int left, int right, int k){
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
                swap(nums, i, j);
            }
            swap(nums, left, i);
            if (i + 1 == k)
                return;
            else if (i + 1 > k)
                quickFind(nums, left, i - 1, k);
            else
                quickFind(nums, i + 1, right, k);
        }

        public void swap(int[] nums, int a, int b){
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
}
//leetcode submit region end(Prohibit modification and deletion)
