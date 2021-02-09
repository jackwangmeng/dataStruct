package com.wm.LeeCode.LeeCode.leecodeList;

import java.util.ArrayList;
import java.util.List;

public class LeeCode78 {
    public List<List<Integer>> subsets(int[] nums) {
        //构建结果集
        List<List<Integer>> res = new ArrayList<>();
        //结果集合中值
        List<Integer> path = new ArrayList<>();
        //数组长度
        /*int n = nums.length;
        for (int mark = 0; mark < (1 << n); ++mark) {
            path.clear();
            for (int i = 0; i < n; ++i) {
                if ((mark & (1 << i)) != 0) {
                    path.add(nums[i]);
                }
            }
            res.add(path);
        }
        return res;*/
        dfs(0, nums, path, res);
        return res;
    }

    private void dfs(int current, int[] nums, List<Integer> path, List<List<Integer>> res) {
        if (current == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        path.add(nums[current]);
        dfs(current + 1, nums, path, res);
        path.remove(path.size() - 1);
        dfs(current + 1, nums, path, res);
    }

    public static void main(String[] args) {
        int[] nums = {5,2,9};
        System.out.println(new LeeCode78().subsets(nums));
    }
}