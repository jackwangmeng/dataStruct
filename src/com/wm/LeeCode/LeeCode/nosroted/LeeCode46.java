package com.wm.LeeCode.LeeCode.nosroted;

import java.util.*;

public class LeeCode46 {
    public List<List<Integer>> permute(int[] nums) {
/*
        //1.构造返回结果集
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentResult = new ArrayList<>();
        for (int currentFirstNode : nums) {
            currentResult.add(currentFirstNode);
        }
        int length = nums.length;
        this.backTrack(length, currentResult, result, 0);
        return result;*/

        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (len == 0) {
            return result;
        }
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[len];
        dfs(nums, len, 0, path, used, result);
        return result;
    }

    private void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> result) {

        if (depth == len) {
            result.add(new ArrayList<>(path));
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                dfs(nums, len, depth + 1, path, used, result);
                used[i] = false;
                path.removeLast();
            }
        }
    }
/*
    private void backTrack(int length, List<Integer> currentResult, List<List<Integer>> result, int first) {
        if (first == length) {
            result.add(new ArrayList<>(currentResult));
        }
        for (int i = first; i < length; i++) {
            //动态维护数组
            Collections.swap(currentResult, first, i);
            backTrack(length, currentResult, result, first + 1);
            Collections.swap(currentResult, first, i);
        }
    }*/

    public static void main(String[] args) {
        int[] eg = {1,2,3};
        System.out.println(new LeeCode46().permute(eg));
    }
}