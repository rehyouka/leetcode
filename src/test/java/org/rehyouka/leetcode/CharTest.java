package org.rehyouka.leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CharTest {

    @DisplayName("commons")
    @Test
    void t0() throws Exception {
        this.printChar(' ');
        this.printChar('0');
        this.printChar('9');
        this.printChar('A');
        this.printChar('Z');
        this.printChar('a');
        this.printChar('z');
    }

    @DisplayName("cast")
    @Test
    void t1() throws Exception {
        System.out.println("char -> int : " + (int)'A');
        System.out.println("int -> char : " + (char)90);
    }

    @DisplayName("compare")
    @Test
    void t2() throws Exception {
        System.out.println("a > A : " + ('a' > 'A'));
        System.out.println("a > 90 : " + ('a' > 90));
        System.out.println("97 > A : " + (97 > 'A'));
    }

    @DisplayName("arithmetic")
    @Test
    void t3() throws Exception {
        System.out.println("A + 32 = " + ('A' + 32));
        System.out.println("A + 32 = (char)" + (char)('A' + 32));
        System.out.println("'' + A = " + (' ' + 'A'));
        System.out.println("'' + A = (char)" + (char)(' ' + 'A'));

        char digit = '7';
        int value = digit - '0'; // 7 (不是 55)
        System.out.println(value);
    }

    void printChar(char aChar) {
        System.out.println("char = " + aChar + "; int = " + (int)aChar);
    }
}