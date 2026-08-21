package org.rehyouka.leetcode.mid;

import java.util.HashMap;
import java.util.Map;

/**
 * @author william
 * @since 2026/8/19
 * @link https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
 */
public class 无重复字符的最长子串 {
    static 无重复字符的最长子串 m = new 无重复字符的最长子串();
    public static void main(String[] args) {
        m.println("abcabcbb");
        m.println("bbbbb");
        m.println("pwwkew");
    }

    void println(String s) {
        System.out.println(s + " => "+ this.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        // a pos and a length
        int pos = 0, len = 0;
        char aChar = ' '; Integer charIdx = null;
        // 复用 char及其索引
        Map<Character, Integer> charIdxMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            aChar = s.charAt(i);
            charIdx = charIdxMap.get(aChar);
            if (charIdx != null) {
                // 重复了，取下一个索引 作为开始
                pos = Math.max(pos, charIdx+1);
            }
            charIdxMap.put(aChar, i);
            len = Math.max(len, i-pos +1);
        }
        return len;
    }
}
