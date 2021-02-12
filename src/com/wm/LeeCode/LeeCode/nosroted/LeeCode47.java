package com.wm.LeeCode.LeeCode.nosroted;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

public class LeeCode47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if(length == 0) {
            return result;
        }
        Arrays.sort(nums);
        Deque<Integer> path = new ArrayDeque<>(length);
        Boolean[] used = new Boolean[length];
        dfs(nums, length, 0, used, path, result);
        return result;
    }

    private void dfs(int[] nums, int length, int depth, Boolean[] used, Deque<Integer> path, List<List<Integer>> result) {
        if(depth == length) {
            result.add(new ArrayList<>(path));
        }
        for (int i = 0; i < length; i++) {
            if(used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(nums, length, depth + 1, used, path, result);
            used[i] = false;
            path.removeLast();
        }
    }
}
