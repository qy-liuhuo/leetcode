//<p>编写一个高效的算法来搜索&nbsp;<code><em>m</em>&nbsp;x&nbsp;<em>n</em></code>&nbsp;矩阵 <code>matrix</code> 中的一个目标值 <code>target</code> 。该矩阵具有以下特性：</p>
//
//<ul> 
// <li>每行的元素从左到右升序排列。</li> 
// <li>每列的元素从上到下升序排列。</li> 
//</ul>
//
//<p>&nbsp;</p>
//
//<p><b>示例 1：</b></p> 
//<img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/11/25/searchgrid2.jpg" /> 
//<pre>
//<b>输入：</b>matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
//<b>输出：</b>true
//</pre>
//
//<p><b>示例 2：</b></p> 
//<img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/11/25/searchgrid.jpg" /> 
//<pre>
//<b>输入：</b>matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
//<b>输出：</b>false
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>m == matrix.length</code></li> 
// <li><code>n == matrix[i].length</code></li> 
// <li><code>1 &lt;= n, m &lt;= 300</code></li> 
// <li><code>-10<sup>9</sup>&nbsp;&lt;= matrix[i][j] &lt;= 10<sup>9</sup></code></li> 
// <li>每行的所有元素从左到右升序排列</li> 
// <li>每列的所有元素从上到下升序排列</li> 
// <li><code>-10<sup>9</sup>&nbsp;&lt;= target &lt;= 10<sup>9</sup></code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>数组</li><li>二分查找</li><li>分治</li><li>矩阵</li></div></div><br><div><li>👍 1572</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n - 1;
        while (i < m && j >=0){
            int temp = matrix[i][j];
            if (temp == target)
                return true;
            else if (temp < target){
                i++;
            }
            else {
                j--;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
