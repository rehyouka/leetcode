package org.rehyouka.leetcode.gpt;

import java.io.PrintStream;
import java.util.Arrays;

/**
 * @author william
 * @since 2026/9/23
 */
public class BinarySearch {
    static int[] NUMS = { -2, 0, 4, 19, 33, 33, 91 };

    public static void main(String[] args) {
        BinarySearch m = new BinarySearch();
        m.exe(3, NUMS, 19, true);
        m.exe( 4, NUMS, 20, false);
        m.exe( 4, NUMS, 33, false);
        m.exe( 3, NUMS, 19, false);
    }
    void exe(int expected, int[] nums, int target, boolean exactEq) {
        int actual = exactEq ? this.algo(nums, target) : this.algo2(nums, target);
        PrintStream s = expected == actual ? System.out : System.err;
        s.println(Arrays.toString(nums) + "; expected=" + expected + "; actual=" + actual);
    }

    // 精准匹配
    int algo(int[] nums, int target) {
        int idxLf = 0, idxRt = nums.length-1, idxMd = 0;
        while(true) {
            idxMd = (idxLf+idxRt)/2;
            if (nums[idxMd] > target) {
                idxRt = idxMd;
            }
            else if (nums[idxMd] < target) {
                idxLf = idxMd;
            }
            else {
                return idxMd;
            }
        }
    }

    // 1. 找到第一个 >= X 的数组索引
    int algo2(int[] nums, int target) {
        // 3. 提前处理 答案不存在
        if (nums[nums.length-1] < target) { return nums.length; }
        int il = 0, ir = nums.length-1, im = 0;
        // 每次都是+1/-1 所以一定会== 跳出循环
        while(il != ir) {
            // 2. 注意：整型除法 可能导致 [2,3] 循环
            //  => (2+3)/2 = 2 --> if 3变2 则无问题; else 2变2 那就是循环
            //  => il=im 的场景 有问题 => 右缩 && il=im 的场景有问题
            //  => im = (il +ir+1) / 2;
            im = (il+ir)/2;
            // 左缩
            // 1. 找到 想要的那一半
            if (nums[im] >= target) {
                ir = im;
            }
            // 右缩
            else {
                // im 不在想要的范围 -> 放心丢弃
                il = im+1;
            }
        }
        // il,ir 都一样
        // [il,ir] 闭区间
        return il;
    }

    // 2. 找到第一个 > X 的数组索引
    int algo3(int[] nums, int target) {
        if (nums[nums.length-1] <= target) { return nums.length; }
        int il = 0, ir = nums.length-1, im = 0;
        while(il != ir) {
            im = (il+ir)/2;
            if (nums[im] > target) {
                ir = im;
            }
            else {
                il = im+1;
            }
        }
        return il;
    }

    // 3. 找到最后一个 <= X 的数组索引
    int algo4(int[] nums, int target) {
        if (nums[0] > target) { return -1; }
        int il = 0, ir = nums.length-1, im = 0;
        while(il != ir) {
            im = (il +ir+1) / 2;
            if (nums[im] <= target) {
                il = im;
            }
            else {
                ir = im-1;
            }
        }
        return il;
    }

    // 4. 找到最后一个 < X 的数组索引
    int algo5(int[] nums, int target) {
        if (nums[0] >= target) { return -1; }
        int il = 0, ir = nums.length-1, im = 0;
        while(il != ir) {
            im = (il +ir+1) / 2;
            if (nums[im] < target) {
                il = im;
            }
            else {
                ir = im-1;
            }
        }
        return il;
    }
}