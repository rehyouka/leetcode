package org.rehyouka.leetcode.ez;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author william
 * @since 2026/9/10
 */
class 反转链表 {
    public static void main(String[] args) {
        反转链表 m = new 反转链表();
        m.exe(new int[]{1, 2, 3, 4, 5});
        m.exe(new int[]{1, 2});
        m.exe(new int[0]);
    }

    public ListNode reverseList(ListNode head) {
        ListNode tail = null;
        ListNode n = head;
        while(n != null) {
            tail = new ListNode(n.val, tail);
            n = n.next;
        }
        return tail;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    void exe(int[] values) {
        String inStr = Arrays.toString(values);

        ListNode head = null;
        if (values != null && values.length > 0) {
            head = new ListNode(values[0]);
            ListNode n = head;
            for (int i = 1; i < values.length; i++) {
                n.next = new ListNode(values[i]);
                n = n.next;
            }

        }
        ListNode tail = this.reverseList(head);
        Integer[] out = this.node2String(tail);
        String outStr = Arrays.toString(out);

        System.out.println("in=" + inStr + "; out=" + outStr);
    }

    Integer[] node2String(ListNode node) {
        if (node == null) {
            return new Integer[0];
        }
        List<Integer> list = new ArrayList<>();
        ListNode cur = node;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        return list.toArray(new Integer[0]);
    }
}
