//<p>不使用任何内建的哈希表库设计一个哈希集合（HashSet）。</p>
//
//<p>实现 <code>MyHashSet</code> 类：</p>
//
//<ul> 
// <li><code>void add(key)</code> 向哈希集合中插入值 <code>key</code> 。</li> 
// <li><code>bool contains(key)</code> 返回哈希集合中是否存在这个值 <code>key</code> 。</li> 
// <li><code>void remove(key)</code> 将给定值 <code>key</code> 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。</li> 
//</ul> &nbsp;
//
//<p><strong>示例：</strong></p>
//
//<pre>
//<strong>输入：</strong>
//["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
//[[], [1], [2], [1], [3], [2], [2], [2], [2]]
//<strong>输出：</strong>
//[null, null, null, true, false, null, true, null, false]
//
//<strong>解释：</strong>
//MyHashSet myHashSet = new MyHashSet();
//myHashSet.add(1);      // set = [1]
//myHashSet.add(2);      // set = [1, 2]
//myHashSet.contains(1); // 返回 True
//myHashSet.contains(3); // 返回 False ，（未找到）
//myHashSet.add(2);      // set = [1, 2]
//myHashSet.contains(2); // 返回 True
//myHashSet.remove(2);   // set = [1]
//myHashSet.contains(2); // 返回 False ，（已移除）</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>0 &lt;= key &lt;= 10<sup>6</sup></code></li> 
// <li>最多调用 <code>10<sup>4</sup></code> 次 <code>add</code>、<code>remove</code> 和 <code>contains</code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>设计</li><li>数组</li><li>哈希表</li><li>链表</li><li>哈希函数</li></div></div><br><div><li>👍 359</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class MyHashSet {

    class Node{
        public int val;
        public Node next;
        public Node(int val){
            this.val = val;
        }
    }

    private Node[] set;

    private int capacity;

    public MyHashSet() {
        this.capacity = 1000;
        this.set = new Node[capacity];
    }
    
    public void add(int key) {
        int index = key % capacity;
        if (set[index] == null){
            set[index] = new Node(-1);
            set[index].next = new Node(key);
        }else{
            Node pre = set[index];
            Node head = pre.next;
            while (head != null){
                if (head.val == key)
                    return;
                pre = head;
                head = head.next;
            }
            Node temp = new Node(key);
            temp.next = pre.next;
            pre.next = temp;
        }
    }
    
    public void remove(int key) {
        int index = key % capacity;
        if (set[index] != null){
            Node pre = set[index];
            Node head = pre.next;
            while (head != null){
                if (head.val == key){
                    pre.next = head.next;
                    return;
                }
                pre = head;
                head = head.next;
            }
        }
    }
    
    public boolean contains(int key) {
        int index = key % capacity;
        if (set[index] != null){
            Node pre = set[index];
            Node head = pre.next;
            while (head != null){
                if (head.val == key){
                    return true;
                }
                pre = head;
                head = head.next;
            }
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
//leetcode submit region end(Prohibit modification and deletion)
