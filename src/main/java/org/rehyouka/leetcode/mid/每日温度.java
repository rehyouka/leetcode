package org.rehyouka.leetcode.mid;

import java.util.Arrays;

/**
 * @author william
 * @since 2026/8/23
 */
class 每日温度 {
    public static void main(String[] args) {
        每日温度 m = new 每日温度();
        m.exe(new int[]{ 73,74,75,71,69,72,76,73 });
        m.exe(new int[]{ 30,40,50,60 });
        m.exe(new int[]{ 30,60,90 });
    }

    // 超出时间限制
/*    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        int current = 0;
        for (int i = 0; i < temperatures.length; i++) {
            current = temperatures[i];
            if (current < 100) {
                for (int j = i+1; j < temperatures.length; j++) {
                    if (current < temperatures[j]) {
                        res[i] = j-i;
                        break;
                    }
                }
            }
        }
        return res;
    }*/

/*    public int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] result = new int[length];

        //从右向左遍历
        for (int i = length - 2; i >= 0; i--) {
            // j+= result[j]是利用已经有的结果进行跳跃
            for (int j = i + 1; j < length; j += result[j]) {
                if (T[j] > T[i]) {
                    result[i] = j - i;
                    break;
                } else if (result[j] == 0) { //遇到0表示后面不会有更大的值，那当然当前值就应该也为0
                    result[i] = 0;
                    break;
                }
            }
        }

        return result;
    }*/

    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];

        for (int i = T.length-2; i >= 0; i--) {
            for (int j = i+1; j < T.length; j+= res[j]) {
                if (T[j] > T[i]) {
                    res[i] = j - i;
                    break;
                } else if(res[j] == 0) {
                    res[i] = 0;
                    break;
                }
            }
        }

        return res;
    }

    void exe(int[] arr) {
        int[] res = this.dailyTemperatures(arr);
        System.out.println(Arrays.toString(arr) + " => " + Arrays.toString(res));
    }
}
