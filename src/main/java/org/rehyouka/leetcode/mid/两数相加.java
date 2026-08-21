package org.rehyouka.leetcode.mid;

/**
 * @author william
 * @since 2026/8/17
 * @link https://leetcode.cn/problems/add-two-numbers/
 */
public class 两数相加 {
    public static void main(String[] args) {
        两数相加 m = new 两数相加();

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        m.print("l1", l1);
        m.print("l2", l2);
        m.print("res", m.addTwoNumbers(l1, l2));

        l1 = new ListNode(0);
        l2 = new ListNode(0);
        m.print("l1", l1);
        m.print("l2", l2);
        m.print("res", m.addTwoNumbers(l1, l2));

        ListNode lb = l1 = new ListNode(9);
        ListNode le = null;
        for (int i = 0; i < 6; i++) {
            lb.next = le = new ListNode(9);
            lb = le;
        }
        lb = l2 = new ListNode(9);
        for (int i = 0; i < 3; i++) {
            lb.next = le = new ListNode(9);
            lb = le;
        }
        m.print("l1", l1);
        m.print("l2", l2);
        m.print("res", m.addTwoNumbers(l1, l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return this.recursive(l1, l2, 0);
    }

    ListNode recursive(ListNode n1, ListNode n2, int v) {
        if (n1 == null && n2 == null && v == 0) {
            return null;
        }
         int val =
                 (n1 != null ? n1.val : 0) +
                 (n2 != null ? n2.val : 0) +
                 v
         ;
         return new ListNode(
                 val>=10 ? val-10 : val,
                 this.recursive(
                         n1 != null ? n1.next : null,
                         n2 != null ? n2.next : null,
                         val>=10 ? 1 : 0
                 )
         );
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

    void print(String h, ListNode n) {
        System.out.print(h + " = ");
        System.out.print("[");
        this.rPrint(n);
        System.out.println("]");
    }
    void rPrint(ListNode n) {
        if (n == null) {
            return;
        }
        this.rPrint(n.next);
        System.out.print(n.val);
        System.out.print(", ");
    }
}
