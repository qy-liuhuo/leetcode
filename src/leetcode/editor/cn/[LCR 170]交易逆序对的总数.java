//<p>在股票交易中，如果前一天的股价高于后一天的股价，则可以认为存在一个「交易逆序对」。请设计一个程序，输入一段时间内的股票交易记录 <code>record</code>，返回其中存在的「交易逆序对」总数。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1:</strong></p>
//
//<pre>
//<strong>输入：</strong>record = [9, 7, 5, 4, 6]
//<strong>输出：</strong>8
//<strong>解释：</strong>交易中的逆序对为 (9, 7), (9, 5), (9, 4), (9, 6), (7, 5), (7, 4), (7, 6), (5, 4)。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>限制：</strong></p>
//
//<p><code>0 &lt;= record.length &lt;= 50000</code></p>
//
//<div><div>Related Topics</div><div><li>树状数组</li><li>线段树</li><li>数组</li><li>二分查找</li><li>分治</li><li>有序集合</li><li>归并排序</li></div></div><br><div><li>👍 1119</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reversePairs(int[] record) {
        return mergeSort(record, 0, record.length - 1);
    }

    public int mergeSort(int[] nums, int left, int right){
        if (left >= right)
            return 0;
        int mid = (right - left) / 2 + left;
        int cnt = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right){
            if(nums[i] > nums[j]){
                temp[k++] = nums[j];
                j++;
                cnt += mid - i + 1;
            }else{
                temp[k++] = nums[i];
                i++;
            }
        }
        while (i <= mid)
            temp[k++] = nums[i++];
        while (j <= right)
            temp[k++] = nums[j++];
        for (int x = 0; x < right - left + 1; x++){
            nums[x + left] = temp[x];
        }
        return cnt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
