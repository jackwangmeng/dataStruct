package com.wm.LeeCode.LeeCode.array;

import java.util.*;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode.array
 * @date 2021/2/1 16:16
 */
public class LeeCode56 {
    public int[][] merge(int[][] intervals) {
        /*
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, (t0, t1) -> t0[0] - t1[0]);
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; ++i) {
            int left = intervals[i][0], right = intervals[i][1];
            if (result.size() == 0 || result.get(result.size() - 1)[1] < left) {
                result.add(new int[]{left, right});
            } else {
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], right);
            }
        }
        return result.toArray(new int[result.size()][]);
        */
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, Comparator.comparingInt(o->o[0]));
        List<int[]> result = new ArrayList<>();
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] > right) {
                result.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            } else {
                right = Math.max(right, intervals[i][1]);
            }
        }
        result.add(new int[]{left, right});
        return result.toArray(new int[][]{});
    }
}
