package org.rehyouka.leetcode.ez;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author william
 * @since 2026/8/23
 */
class 回文链表 {
    public static void main(String[] args) {
        回文链表 m = new 回文链表();
        m.exe(new int[]{1,2,2,1});
        m.exe(new int[]{1,2});
    }

    // 6ms 105MB
/*    public boolean isPalindrome(ListNode head) {
        if (head.next == null) { return true; }

        int count = 1;
        ListNode cursor = head;
        ListNode tail = null, prev = new ListNode(head.val);
        while(cursor.next != null) {
            cursor = cursor.next;
            count++;

            tail = new ListNode(cursor.val);
            tail.next = prev;
            prev = tail;
        }

        cursor = head;
        count /= 2;
        while(count-- > 0) {
            if (cursor.val != tail.val) { return false; }
            cursor = cursor.next;
            tail = tail.next;
        }

        return true;
    }*/

    // 6ms 99.21MB
    public boolean isPalindrome(ListNode head) {
        ListNode cur = head;
        List<ListNode> nodes = new ArrayList<>();
        nodes.add(cur);
        while(cur.next != null) {
            cur = cur.next;
            nodes.add(cur);
        }
        int length = nodes.size();
        for (int i = 0; i < length / 2; i++) {
            if (nodes.get(i).val != nodes.get(length-i-1).val) {
                return false;
            }
        }
        return true;
    }

    // 3ms 93MB
    // 收益好低
/*    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast != null && fast.next != null) {
            //快指针走两步
            fast = fast.next.next;
            //慢指针一边走一边翻转
            ListNode tmp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = tmp;
        }

        //判断是否奇数个元素，如果是奇数，则中间点元素不比较
        boolean isOdd = fast != null;
        // slow指向当前的中间节点（偶数状态下是第二个中间节点）
        if (isOdd) {
            slow = slow.next;
        }
        //prev指向slow的前一个节点
        while(slow != null) {
            if(prev.val != slow.val) {
                return false;
            }
            slow = slow.next;//slow向后遍历
            prev = prev.next;//prev按照原方向的反方向遍历，即向前遍历
        }
        return true;
    }*/


    int count(ListNode head) {
        int c = 0;
        ListNode node = head;
        do { node = node.next; c ++;} while(node != null);
        return c;
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
    ListNode createListNode(int[] arr) {
        ListNode n0 = new ListNode(arr[0]), nPrev = n0;
        for (int i = 1; i < arr.length; i++) {
            nPrev.next = new ListNode(arr[i]);
            nPrev = nPrev.next;
        }
        return n0;
    }
    void exe(int[] arr) {
        ListNode node = createListNode(arr);
        boolean palindrome = this.isPalindrome(node);
        System.out.println(Arrays.toString(arr) + " => " + palindrome);
    }
}
