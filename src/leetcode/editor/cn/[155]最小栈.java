//<p>设计一个支持 <code>push</code> ，<code>pop</code> ，<code>top</code> 操作，并能在常数时间内检索到最小元素的栈。</p>
//
//<p>实现 <code>MinStack</code> 类:</p>
//
//<ul> 
// <li><code>MinStack()</code> 初始化堆栈对象。</li> 
// <li><code>void push(int val)</code> 将元素val推入堆栈。</li> 
// <li><code>void pop()</code> 删除堆栈顶部的元素。</li> 
// <li><code>int top()</code> 获取堆栈顶部的元素。</li> 
// <li><code>int getMin()</code> 获取堆栈中的最小元素。</li> 
//</ul>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1:</strong></p>
//
//<pre>
//<strong>输入：</strong>
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//<strong>输出：</strong>
//[null,null,null,null,-3,null,0,-2]
//
//<strong>解释：</strong>
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --&gt; 返回 -3.
//minStack.pop();
//minStack.top();      --&gt; 返回 0.
//minStack.getMin();   --&gt; 返回 -2.
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>-2<sup>31</sup>&nbsp;&lt;= val &lt;= 2<sup>31</sup>&nbsp;- 1</code></li> 
// <li><code>pop</code>、<code>top</code> 和 <code>getMin</code> 操作总是在 <strong>非空栈</strong> 上调用</li> 
// <li><code>push</code>,&nbsp;<code>pop</code>,&nbsp;<code>top</code>, and&nbsp;<code>getMin</code>最多被调用&nbsp;<code>3 * 10<sup>4</sup></code>&nbsp;次</li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>栈</li><li>设计</li></div></div><br><div><li>👍 1863</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {

    private Deque <Long> queue = new ArrayDeque<>();

    private long last_min = 0;

    public MinStack() {
        
    }
    
    public void push(int val) {
        if (queue.isEmpty()){
            queue.offerLast(Long.valueOf(0));
            this.last_min = val;
        }
        else {
            queue.offerLast(val - this.last_min);
            if (val < this.last_min){
                last_min = val;
            }
        }
    }
    
    public void pop() {
        long temp = queue.pollLast();
        if (temp < 0)
            this.last_min = this.last_min - temp;
    }
    
    public int top() {
        long temp = queue.peekLast();
        if (temp < 0)
            return (int) last_min;
        return (int)(last_min + temp);
    }
    
    public int getMin() {
        return (int)last_min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)
