package org.rehyouka.leetcode.ez;

import java.util.ArrayList;
import java.util.List;

/**
 * @author william
 * @since 2026/8/24
 */
class 翻转二叉树 {
    public static void main(String[] args) {
        翻转二叉树 m = new 翻转二叉树();

        TreeNode n_1_2 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        TreeNode n_1_7 = new TreeNode(7, new TreeNode(6), new TreeNode(9));
        TreeNode n_1_4 = new TreeNode(4, n_1_2, n_1_7);
        m.exe(n_1_4);

        TreeNode n_2_2 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        m.exe(n_2_2);

        TreeNode n_3 = null;
        m.exe(n_3);

        TreeNode n_4 = new TreeNode(1);
        m.exe(n_4);

        // 实际是 [1, null, 2]
        TreeNode n_5 = new TreeNode(1, new TreeNode(2), null);
        m.exe(n_5);
    }

    TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        this.invertTree0(root);
        return root;
    }

    TreeNode invertTree0(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return null;
        }

        TreeNode n = root.right;
        root.right = root.left;
        root.left = n;

        this.invertTree0(root.right);
        this.invertTree0(root.left);

        return root;
    }

    public static class TreeNode {
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

    void exe(TreeNode root) {
        String in = this.treeNode2String(root);
        TreeNode res = this.invertTree(root);
        String out = this.treeNode2String(res);
        System.out.println(in + " => " + out);
    }
    void treeNode2IntArr(TreeNode root, List<Integer> arr) {
        if (arr.isEmpty() && root != null) arr.add(root.val);
        if (root == null) return;
        if(root.left != null) arr.add(root.left.val);
        if(root.right != null) arr.add(root.right.val);
        if(root.left != null) this.treeNode2IntArr(root.left, arr);
        if(root.right != null) this.treeNode2IntArr(root.right, arr);
    }
    String treeNode2String(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        this.treeNode2IntArr(root, arr);
        return arr.toString();
    }
}
