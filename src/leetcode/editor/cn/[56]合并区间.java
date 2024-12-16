//<p>以数组 <code>intervals</code> 表示若干个区间的集合，其中单个区间为 <code>intervals[i] = [start<sub>i</sub>, end<sub>i</sub>]</code> 。请你合并所有重叠的区间，并返回&nbsp;<em>一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间</em>&nbsp;。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>intervals = [[1,3],[2,6],[8,10],[15,18]]
//<strong>输出：</strong>[[1,6],[8,10],[15,18]]
//<strong>解释：</strong>区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//</pre>
//
//<p><strong>示例&nbsp;2：</strong></p>
//
//<pre>
//<strong>输入：</strong>intervals = [[1,4],[4,5]]
//<strong>输出：</strong>[[1,5]]
//<strong>解释：</strong>区间 [1,4] 和 [4,5] 可被视为重叠区间。</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= intervals.length &lt;= 10<sup>4</sup></code></li> 
// <li><code>intervals[i].length == 2</code></li> 
// <li><code>0 &lt;= start<sub>i</sub> &lt;= end<sub>i</sub> &lt;= 10<sup>4</sup></code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>数组</li><li>排序</li></div></div><br><div><li>👍 2475</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (int[] a, int[] b) ->{
            return a[0] - b[0];
        });
        List<int[]> res = new ArrayList<>();
        int begin = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i <intervals.length; i++){
            if (intervals[i][0] <= end)
                end = Math.max(intervals[i][1], end);
            else {
                res.add(new int[]{begin, end});
                begin = intervals[i][0];
                end = intervals[i][1];
            }
        }
        res.add(new int[]{begin, end});
        return res.toArray(int[][] :: new);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
