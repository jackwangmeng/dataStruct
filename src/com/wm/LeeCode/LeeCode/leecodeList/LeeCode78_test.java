package com.wm.LeeCode.LeeCode.leecodeList;

import java.util.ArrayList;
import java.util.List;

public class LeeCode78_test {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        for (int i = 1; i <= nums.length; ++i) {
            combine(nums, i);
        }
        return res;
    }

    private void combine(int[] nums, int k) {
        dfs(0, nums, k);
    }

    private void dfs(int start, int[] nums, int k) {
        if (ans.size() == k) {
            res.add(new ArrayList<>(ans));
            return;
        }
        ans.add(nums[start]);
        dfs(start + 1, nums, k);
        ans.remove(ans.size() - 1);
        dfs(start + 1, nums, k);
    }
}