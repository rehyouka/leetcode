package org.rehyouka.leetcode.gpt;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author william
 * @since 2026/9/1
 */
public class TopKHeap {
    int[] topK(int[] nums, int k, boolean reverse) {
        if (nums == null || k == 0) {
            return new int[0];
        }
        if (nums.length == 1) {
            return nums;
        }

        Queue<Integer> heap = reverse ?
                // 大顶堆: 越靠近 根(头部)节点，数值越大 => 长度溢出，移除头部节点 => 保留 最小值
                new PriorityQueue<>(Comparator.reverseOrder()) :
                // 小顶堆： 越靠近 根(头部)节点，数值越小 => 长度溢出，移除头部节点 => 保留 最大值
                new PriorityQueue<>();
        for (int num : nums) {
            heap.offer(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7, 2, 9, 4, 1, 5, 8};
//        int[] topK = new TopKHeap().topK(arr, 3, false);
        int[] topK = new TopKHeap().topK(arr, 3, true);
        System.out.println(Arrays.toString(topK));  // [7, 8, 9]
    }
}
