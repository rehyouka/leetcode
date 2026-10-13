package org.rehyouka.leetcode;

import org.junit.jupiter.api.Test;
import org.rehyouka.leetcode.gpt.TopKHeap;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author william
 * @since 2026/9/27
 *
 * @see TopKHeap PriorityQueue --> 堆 (一种特殊的 完全二叉树，用于 快速取 最值)
 */
class CollectionTest {
    @Test
    void t0() throws Exception {
        Queue<Integer> q = new LinkedList<>();
        // System.out.println("[Queue] 添加一个null元素 --> " + q.offer(null) + "; isEmpty --> " + q.isEmpty());
        // The queue will poll a null, if empty
        System.out.println("[Queue] 弹出一个null元素 --> " + q.poll() + "; isEmpty --> " + q.isEmpty());

        Map<String, Integer> m = new HashMap<>();
        m.put(null, 12);
        m.put(null, null);
        System.out.println("[map] null作为key --> " + m.get(null));

        Set<String> s = new HashSet<>();
        s.add(null);
        s.add(null);
        System.out.println("[set] add null --> " + s.contains(null));
    }

    @Test
    void t1() throws Exception {
        // Deque<Integer> stack = new LinkedList<>();
        // 数组性能更优
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        // ArrayDeque 不支持null插入
        // stack.push(null);
        stack.push(2);

        System.out.println("[stack] peek 查看栈顶，但不移除 --> " + stack.peek());
        System.out.println("[stack] pop 查看栈顶，并移除 --> " + stack.pop());
        System.out.println("[stack] pop 查看栈顶，并移除 --> " + stack.pop());
        // System.out.println("[stack] pop 查看栈顶，并移除 --> " + stack.pop());
        // 如果empty --> pop 报错
        // System.out.println("[stack] pop 查看栈顶，并移除 --> " + stack.pop());
        // 如果empty --> peek 返回null
        System.out.println("[stack] peek 查看栈顶，但不移除 --> " + stack.peek());
    }

    /**
     * TreeSet 是 红黑树，so O(log n)，同二分
     * 建议用于 动态增删+边界查询+自动有序
     * 如果是 静态有序 的查找，建议使用 二分
     *
     * lower(x)	    小于 x 的最大值
     * floor(x)	    小于等于 x 的最大值
     * ceiling(x)	大于等于 x 的最小值
     * higher(x)	大于 x 的最小值
     */
    @Test
    void t2() throws Exception {
        // TreeSet 有一些 Set接口 没有的API
        TreeSet<Integer> set = new TreeSet<>();

        // =========================
        // 1. 添加元素
        // =========================
        set.add(5);
        set.add(2);
        set.add(8);
        set.add(6);
        set.add(3);
        set.add(5); // 重复元素不会添加

        System.out.println("set = " + set);


        // =========================
        // 2. 基本查询
        // =========================
        System.out.println("contains(5) = " + set.contains(5));
        System.out.println("contains(10) = " + set.contains(10));

        System.out.println("size() = " + set.size());
        System.out.println("isEmpty() = " + set.isEmpty());


        // =========================
        // 3. 最小值 / 最大值
        // =========================
        System.out.println("first() = " + set.first());
        System.out.println("last() = " + set.last());


        // =========================
        // 4. 前驱
        // =========================
        System.out.println("lower(5) = " + set.lower(5));
        System.out.println("floor(5) = " + set.floor(5));

        System.out.println("lower(4) = " + set.lower(4));
        System.out.println("floor(4) = " + set.floor(4));


        // =========================
        // 5. 后继
        // =========================
        System.out.println("higher(5) = " + set.higher(5));
        System.out.println("ceiling(5) = " + set.ceiling(5));

        System.out.println("higher(4) = " + set.higher(4));
        System.out.println("ceiling(4) = " + set.ceiling(4));


        // =========================
        // 6. 删除
        // =========================
        set.remove(5);

        System.out.println("remove(5) 后 = " + set);


        // =========================
        // 7. 遍历
        // =========================
        System.out.print("遍历：");

        for (Integer num : set) {
            System.out.print(" " + num);
        }

        System.out.println();


        // =========================
        // 8. 清空
        // =========================
        set.clear();

        System.out.println("clear() 后 = " + set);
        System.out.println("isEmpty() = " + set.isEmpty());
    }

    @Test
    void t3() throws Exception {
        Integer[] arr = { 3, 100, 33, -2, 19, 33, 7 };
        // NPE
//        Integer[] arr = { 3, 100, 33, -2, 19, 33, 7, null };
        List<Integer> list = Arrays.asList(3, 100, 33, -2, 19, 33, 7);
        // NPE
//        List<Integer> list = Arrays.asList(3, 100, 33, -2, 19, 33, 7, null);

        Arrays.sort(arr);
        System.out.println("Arrays.sort(arr) --> " + Arrays.toString(arr));
        Collections.sort(list);
        System.out.println("Collections.sort(list) --> " + list);
    }
}
