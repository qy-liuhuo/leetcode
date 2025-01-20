//<p>设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。</p>
//
//<p>循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。</p>
//
//<p>你的实现应该支持如下操作：</p>
//
//<ul> 
// <li><code>MyCircularQueue(k)</code>: 构造器，设置队列长度为 k 。</li> 
// <li><code>Front</code>: 从队首获取元素。如果队列为空，返回 -1 。</li> 
// <li><code>Rear</code>: 获取队尾元素。如果队列为空，返回 -1 。</li> 
// <li><code>enQueue(value)</code>: 向循环队列插入一个元素。如果成功插入则返回真。</li> 
// <li><code>deQueue()</code>: 从循环队列中删除一个元素。如果成功删除则返回真。</li> 
// <li><code>isEmpty()</code>: 检查循环队列是否为空。</li> 
// <li><code>isFull()</code>: 检查循环队列是否已满。</li> 
//</ul>
//
//<p>&nbsp;</p>
//
//<p><strong>示例：</strong></p>
//
//<pre>MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
//circularQueue.enQueue(1); &nbsp;// 返回 true
//circularQueue.enQueue(2); &nbsp;// 返回 true
//circularQueue.enQueue(3); &nbsp;// 返回 true
//circularQueue.enQueue(4); &nbsp;// 返回 false，队列已满
//circularQueue.Rear(); &nbsp;// 返回 3
//circularQueue.isFull(); &nbsp;// 返回 true
//circularQueue.deQueue(); &nbsp;// 返回 true
//circularQueue.enQueue(4); &nbsp;// 返回 true
//circularQueue.Rear(); &nbsp;// 返回 4</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li>所有的值都在 0&nbsp;至 1000 的范围内；</li> 
// <li>操作数将在 1 至 1000 的范围内；</li> 
// <li>请不要使用内置的队列库。</li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>设计</li><li>队列</li><li>数组</li><li>链表</li></div></div><br><div><li>👍 546</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class MyCircularQueue {

    private int[] list;

    private int head;

    private int tail;

    private int size;

    public MyCircularQueue(int k) {
        list = new int[k];
        head = 0;
        tail = 0;
        size = k;
    }

    public boolean enQueue(int value) {
        if (isFull()){
            return false;
        }
        else{
            list[head % size] =  value;
            head = head + 1;
            return true;
        }
    }

    public boolean deQueue() {
        if (isEmpty()){
            return false;
        }
        else{
            tail = tail + 1;
            return true;
        }
    }
    // 注意队首的定义，应该是最先进去的那个
    public int Front() {
        if (isEmpty()){
            return -1;
        }else{
            return list[tail % size];
        }
    }

    public int Rear() {
        if (isEmpty()){
            return -1;
        }else{
            return list[(head - 1) % size];
        }
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return  head - tail == size;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
//leetcode submit region end(Prohibit modification and deletion)
