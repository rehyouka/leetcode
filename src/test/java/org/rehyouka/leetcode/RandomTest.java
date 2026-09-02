package org.rehyouka.leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author william
 * @since 2026/9/2
 */
class RandomTest {
    int idxLf = 4;
    int idxRt = 9;

    @DisplayName("Random & since 1.0")
    @Test
    void t0() throws Exception {
        int num = new Random().nextInt(this.idxRt - this.idxLf + 1) + this.idxLf;
        System.out.println(num);
    }

    @DisplayName("Thread-safe @ 1.7")
    @Test
    void t1() throws Exception {
        int num = ThreadLocalRandom.current().nextInt(this.idxLf, this.idxRt + 1);
        System.out.println(num);
    }

    @DisplayName("Math")
    @Test
    void t2() throws Exception {
        int num = (int)(Math.random() * (this.idxRt - this.idxLf + 1)) + this.idxLf;
        System.out.println(num);
    }
}
