package org.rehyouka.leetcode.noted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author william
 * @since 2026/9/27
 */
class BFS {

    static class BinaryTreeTraversal {
        /**
         * No.102
         * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
         * <p>
         * 树中节点数目在范围 [0, 2000] 内
         * -1000 <= Node.val <= 1000
         * <p>
         * [3,9,20,null,null,15,7] --> [[3],[9,20],[15,7]]
         * [1] --> [[1]]
         * [] --> []
         */
        // 双Queue
/*
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }

            Queue<TreeNode> p = new LinkedList<>();
            Queue<TreeNode> q = new LinkedList<>();
            p.offer(root);

            TreeNode n = null;
            List<Integer> ns = new ArrayList<>();
            while (!p.isEmpty()) {
                n = p.poll();
                if(n != null) {
                    if (n.left != null) {
                        q.offer(n.left);
                    }
                    if (n.right != null) {
                        q.offer(n.right);
                    }
                    ns.add(n.val);
                }

                if (p.isEmpty()) {
                    while (!q.isEmpty()) { p.offer(q.poll()); }
                    if (!ns.isEmpty()) {
                        res.add(ns);
                        ns = new ArrayList<>();
                    }
                }
            }

            return res;
        }
 */

        // 单Queue
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }

            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);

            List<Integer> ns = new ArrayList<>();
            TreeNode n = null;
            int cap = 1;

            while (!q.isEmpty()) {
                n = q.poll();
                if (n.left != null) {
                    q.offer(n.left);
                }
                if (n.right != null) {
                    q.offer(n.right);
                }
                ns.add(n.val);
                if (--cap == 0) {
                    cap = q.size();
                    res.add(ns);
                    ns = new ArrayList<>();
                }
            }

            return res;
        }

        static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode() {
            }

            TreeNode(int val) {
                this.val = val;
            }

            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }
    }

    static class LC752 {
        /**
         * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。
         * 每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
         * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
         * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
         * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
         *
         * deadends = ["0201","0101","0102","1212","2002"], target = "0202" --> 6
         * deadends = ["8888"], target = "0009" --> 1
         * deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888" --> -1
         *
         * 1 <= deadends.length <= 500
         * target 不在 deadends 之中
         */
        public int openLock(String[] deadends, String target) {
            if (target.equals("0000")) { return 0; }

            Set<String> visited = new HashSet<>(Arrays.asList(deadends));
            if (!visited.add("0000")) { return -1; }

            Queue<String> q = new LinkedList<>();
            q.offer("0000");

            String str = null, s = null;
            int steps = 1, cap = 1;
            while(!q.isEmpty()) {
                str = q.poll();

                for (int i = 0; i < 4; i++) {
                    s = this.dail(str, i, true);
                    if (s != null) {
                        if (target.equals(s)) { return steps; }
                        // 为什么不同 !remove() --> 场景会重复 --> 多个转盘 的拨号顺序 是随机的
                        if (visited.add(s)) { q.offer(s); }
                    }
                    s = this.dail(str, i, false);
                    if (s != null) {
                        if (target.equals(s)) { return steps; }
                        if (visited.add(s)) { q.offer(s); }
                    }
                }

                if (--cap == 0) {
                    cap = q.size();
                    steps ++;
                }
            }
            return -1;
        }

        String dail(String str, int idx, boolean inc) {
            char[] chars = str.toCharArray();
            chars[idx] = this.compute(chars[idx], inc);
            return String.valueOf(chars);
        }
        char compute(char aChar, boolean inc) {
            if (inc) {
                return aChar == '9' ? '0' : (char) (aChar + 1);
            }
            return aChar == '0' ? '9' : (char) (aChar - 1);
        }
    }

    static class LC127 {
        /**
         * 字典 wordList 中从单词 beginWord 到 endWord 的 转换序列 是一个按下述规格形成的序列 beginWord -> s1 -> s2 -> ... -> sk：
         * 每一对相邻的单词只差一个字母。
         *  对于 1 <= i <= k 时，每个 si 都在 wordList 中。注意， beginWord 不需要在 wordList 中。
         * sk == endWord
         * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。
         * 如果不存在这样的转换序列，返回 0 。
         *
         * 1 <= beginWord.length <= 10
         * endWord.length == beginWord.length
         * 1 <= wordList.length <= 5000
         * wordList[i].length == beginWord.length
         * beginWord、endWord 和 wordList[i] 由小写英文字母组成
         * beginWord != endWord
         * wordList 中的所有字符串 互不相同
         */
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> wordSet = new HashSet<>(wordList);
            if (!wordSet.contains(endWord)) { return 0; }

            Queue<String> q = new LinkedList<>();
            q.offer(beginWord);

            Set<String> visited = new HashSet<>();
            visited.add(beginWord);

            String aWord = null, s = null;
            char[] chars = null;
            int steps = 2, cap = 1, len = beginWord.length();
            while (!q.isEmpty()) {
                aWord = q.poll();

                for (int i = 0; i < len; i++) {
                    chars = aWord.toCharArray();
                    for (int j = 0; j < 25; j++) {
                        s = this.walk(chars, i);
                        if (endWord.equals(s)) { return steps; }
                        if (wordSet.contains(s) && visited.add(s)) { q.offer(s); }
                    }
                }

                if (--cap == 0) {
                    cap = q.size();
                    steps++;
                }
            }
            return 0;
        }

        String walk(char[] chars, int idx) {
            chars[idx] = chars[idx] == 'z' ? 'a' : (char) (chars[idx] + 1);
            return String.valueOf(chars);
        }
    }
}
