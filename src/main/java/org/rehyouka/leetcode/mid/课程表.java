package org.rehyouka.leetcode.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author william
 * @since 2026/9/10
 */
class 课程表 {
    public static void main(String[] args) {
        课程表 m = new 课程表();
        m.exe(2, new int[][]{ new int[]{1,0} });
        m.exe(2, new int[][]{ new int[]{1,0}, new int[]{0,1} });
    }
    public boolean canFinish(int numCourses, int[][] prerequisities) {
        List<List<Integer>> adjacencies = new ArrayList<>();
        int[] indegrees = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adjacencies.add(new ArrayList<>());
        }

        int cur = 0, pre = 0;
        for (int[] p : prerequisities) {
            cur = p[0];
            pre = p[1];
            adjacencies.get(pre).add(cur);
            indegrees[cur]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (cur = 0; cur < indegrees.length; cur++) {
            if (indegrees[cur] == 0) {
                queue.offer(cur);
            }
        }

        int finished = 0;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            finished++;

            for (int a : adjacencies.get(cur)) {
                if (--indegrees[a] == 0) {
                    queue.offer(a);
                }
            }
        }
        return finished == numCourses;
    }
    void exe(int numCourses, int[][] prerequisities) {
        String prerequisitiesString = Arrays.deepToString(prerequisities);
        boolean canFinish = this.canFinish(numCourses, prerequisities);
        System.out.println("numCourses="+numCourses + "; prerequisities="+prerequisitiesString+"; canFinish="+canFinish);
    }
}
