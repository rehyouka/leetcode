package org.rehyouka.leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * @author william
 * @since 2026/8/20
 */
class SortingTest {
    void t(Consumer<int[]> algorithm) {
        int[] actual = new int[]  { 5, 7, 0, 3, 1, 3, 8, -2, 4, 9 };
        int[] expected = new int[]{ -2, 0, 1, 3, 3, 4, 5, 7, 8, 9 };
        long bgnMs = System.currentTimeMillis();
        algorithm.accept(actual);
        long endMs = System.currentTimeMillis();
        System.out.println(Arrays.toString(actual));
        System.out.println("use " + (endMs - bgnMs) + " ms");
        this.assertSorting(actual, expected);
    }

    @DisplayName("bubble")
    @Test
    void t0() throws Exception {
        this.t(this::bubble);
    }
    @DisplayName("select")
    @Test
    void t1() throws Exception {
        this.t(this::select);
    }

    void bubble(int[] arr) {
        if (arr == null || arr.length <= 1) { return; }
        boolean swapped = false;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j ++) {
                if (arr[j] > arr[j+1]) {
                    this.swap(arr, j, j+1);
                    swapped = true;
                }
            }
            if (!swapped) {
                return;
            }
        }
    }
    void select(int[] arr) {
        if (arr == null || arr.length <= 1) { return; }
        int minIdx = 0;
        for (int i = 0; i < arr.length-1; i++) {
            minIdx = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) { minIdx = j; }
            }
            if (minIdx != i) { this.swap(arr, i, minIdx); }
        }
    }
    void insert(int[] arr) {
        if (arr == null || arr.length <= 1) { return; }
        int cur = 0, val = 0;
        for (int i = 1; i < arr.length; i++) {
            cur = arr[i];


            for (int j = i; j >= 1; j--) {
                if (arr[j-1] > arr[j]) {
                    this.swap(arr, i, j);
                }
            }
        }
    }

    void swap(int[] arr, int i, int j) {
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }
    void assertSorting(int[] actual, int[] expected) {
        if (expected == null || expected.length == 0) { throw new IllegalStateException(); }
        for (int i = 0; i < expected.length; i++) {
            if (expected[i] != actual[i]) { throw new IllegalStateException(); }
        }
    }
}