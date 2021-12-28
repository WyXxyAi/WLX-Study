package Algorithm;

import java.util.Arrays;
import java.util.Locale;

/**
 * 208. 实现 Trie (前缀树)
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 *
 * 思路:
 * 构造函数：1.每个节点都可能会有26个子节点（对应26个字母）;  2.每个节点都应该有一个标志位判断是否为叶子节点。
 * 插入insert：遍历第一个字母，判断是否存在，存在就向子节点移动，不存在就新建子节点再向子节点移动;每个字母依次类推，直到全部插入完成。
 * 查找serch：遍历第一个字母，判断是否存在，存在就向子节点移动，不存在则返回false;每个字母依此类推，最后判断isEnd，true则返回true，false则返回false。
 * 查找前缀statWith：遍历第一个字母，判断是否存在，存在就向子节点移动，不存在则返回false;每个字母依此类推，如果遍历完则返回true。
 */
public class Trie {
    private Trie[] childs;
    private boolean isEnd;

    //构造函数：1.每个节点都可能会有26个子节点（对应26个字母）;  2.每个节点都应该有一个标志位判断是否为叶子节点。
    public Trie() {
        childs = new Trie[26];
        isEnd = false;
    }

    //插入insert：遍历第一个字母，判断是否存在，存在就向子节点移动，不存在就新建子节点再向子节点移动;每个字母依次类推，直到全部插入完成。
    public void insert(String word) {
        Trie node = this;
        char[] ch = word.toLowerCase().toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (node.childs[ch[i]-'a']==null){
                node.childs[ch[i]-'a']=new Trie();
            }
            node = node.childs[ch[i]-'a'];
        }
        node.isEnd=true;
    }

    //查找serch：遍历第一个字母，判断是否存在，存在就向子节点移动，不存在则返回false;每个字母依此类推，最后判断isEnd，true则返回true，false则返回false。
    public boolean search(String word) {
        Trie node = this;
        char[] ch = word.toLowerCase().toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (node.childs[ch[i]-'a']!=null){
                node=node.childs[ch[i]-'a'];
            }else {
                return false;
            }
        }
        return node.isEnd?true:false;
    }

    //查找前缀statWith：遍历第一个字母，判断是否存在，存在就向子节点移动，不存在则返回false;每个字母依此类推，如果遍历完则返回true。
    public boolean startsWith(String prefix) {
        Trie node = this;
        char[] ch = prefix.toLowerCase().toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (node.childs[ch[i]-'a']!=null){
                node=node.childs[ch[i]-'a'];
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
    }
}
