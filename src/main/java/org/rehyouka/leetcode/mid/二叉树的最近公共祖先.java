package org.rehyouka.leetcode.mid;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author william
 * @since 2026/8/22
 */
class 二叉树的最近公共祖先 {
    public static void main(String[] args) {
        二叉树的最近公共祖先 m = new 二叉树的最近公共祖先();
        Integer[] arr = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode root = buildTree(arr);
        TreeNode p = root.left;
        TreeNode q = p.right.right;
        TreeNode n = m.lowestCommonAncestor(root, p, q);
        System.out.println(n.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) { return root; }
        TreeNode nl = this.lowestCommonAncestor(root.left, p, q);
        TreeNode nr = this.lowestCommonAncestor(root.right, p, q);
        if (nl != null && nr != null) { return root; }
        return nl != null ? nl : nr;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public static TreeNode buildTree(Integer[] vals) {
        if (vals == null || vals.length == 0 || vals[0] == null) {
            return null;
        }

        // 1. 创建根节点，入队
        TreeNode root = new TreeNode(vals[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // 2. 用指针 i 遍历数组（从第2个元素开始）
        int i = 1;
        while (!queue.isEmpty() && i < vals.length) {
            TreeNode current = queue.poll();

            // ---- 左孩子 ----
            if (vals[i] != null) {
                current.left = new TreeNode(vals[i]);
                queue.offer(current.left);
            }
            i++;

            // ---- 右孩子 ----
            if (i < vals.length && vals[i] != null) {
                current.right = new TreeNode(vals[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }
}
