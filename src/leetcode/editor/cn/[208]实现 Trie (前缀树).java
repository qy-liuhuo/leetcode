//<p><strong><a href="https://baike.baidu.com/item/字典树/9825209?fr=aladdin" target="_blank">Trie</a></strong>（发音类似 "try"）或者说 <strong>前缀树</strong> 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补全和拼写检查。</p>
//
//<p>请你实现 Trie 类：</p>
//
//<ul> 
// <li><code>Trie()</code> 初始化前缀树对象。</li> 
// <li><code>void insert(String word)</code> 向前缀树中插入字符串 <code>word</code> 。</li> 
// <li><code>boolean search(String word)</code> 如果字符串 <code>word</code> 在前缀树中，返回 <code>true</code>（即，在检索之前已经插入）；否则，返回 <code>false</code> 。</li> 
// <li><code>boolean startsWith(String prefix)</code> 如果之前已经插入的字符串&nbsp;<code>word</code> 的前缀之一为 <code>prefix</code> ，返回 <code>true</code> ；否则，返回 <code>false</code> 。</li> 
//</ul>
//
//<p>&nbsp;</p>
//
//<p><strong>示例：</strong></p>
//
//<pre>
//<strong>输入</strong>
//["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
//[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
//<strong>输出</strong>
//[null, null, true, false, true, null, true]
//
//<strong>解释</strong>
//Trie trie = new Trie();
//trie.insert("apple");
//trie.search("apple");   // 返回 True
//trie.search("app");     // 返回 False
//trie.startsWith("app"); // 返回 True
//trie.insert("app");
//trie.search("app");     // 返回 True
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= word.length, prefix.length &lt;= 2000</code></li> 
// <li><code>word</code> 和 <code>prefix</code> 仅由小写英文字母组成</li> 
// <li><code>insert</code>、<code>search</code> 和 <code>startsWith</code> 调用次数 <strong>总计</strong> 不超过 <code>3 * 10<sup>4</sup></code> 次</li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>设计</li><li>字典树</li><li>哈希表</li><li>字符串</li></div></div><br><div><li>👍 1746</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Trie {

    class Node{
        private boolean isWord;
        private Node[] children;
        public Node(){
            this.isWord = false;
            this.children = new Node[26];
        }

        public boolean hasChild(char c){
            return children[hash(c)] != null;
        }

        public Node next(char c){
            return children[hash(c)];
        }

        public Node insert(char c){
            return children[hash(c)] = new Node();
        }

        public void markAsWord(){
            this.isWord = true;
        }
    }

    private Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node temp = root;
        for (char c : word.toCharArray()){
            if (temp.hasChild(c)){
                temp = temp.next(c);
            }else{
                temp = temp.insert(c);
            }
        }
        temp.markAsWord();
    }

    public boolean search(String word) {
        Node temp = root;
        for (char c : word.toCharArray()){
            if (!temp.hasChild(c)){
                return false;
            }else{
                temp = temp.next(c);
            }
        }
        return temp.isWord;
    }

    public boolean startsWith(String prefix) {
        Node temp = root;
        for (char c : prefix.toCharArray()){
            if (!temp.hasChild(c)){
                return false;
            }else{
                temp = temp.next(c);
            }
        }
        return true;
    }

    public int hash(char c){
        return (int)(c - 'a');
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)
