package org.rehyouka.leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class ArrCopyTest {
    int[] arr1 = new int[]{ 1, 3, 5, 7 };
    int[] arr2 = new int[]{ 2, 4, 6, 8 };

    @DisplayName("copy")
    @Test
    void t0() throws Exception {
        int[] copy = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, copy, 0, arr1.length);
        System.arraycopy(arr2, 0, copy, arr1.length, arr2.length);
        System.out.println(Arrays.toString(copy));

        int[] anotherCopy = Arrays.copyOf(copy, arr1.length + 2);
        System.out.println(Arrays.toString(anotherCopy));
    }
}