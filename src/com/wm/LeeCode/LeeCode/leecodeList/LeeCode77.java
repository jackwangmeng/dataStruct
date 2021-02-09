package com.wm.LeeCode.LeeCode.leecodeList;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LeeCode77 {
    /*public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(k <= 0 || n < k) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k, 1, path, res);
        return res;
    }

    private void dfs(int n, int k, int start, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
*//*
        for (int i = start; i <= n; ++i) {
            path.addLast(i);
            dfs(n, k, i + 1, path, res);
            path.removeLast();
        }*//*


        for (int i = start; i <= n - (k - path.size()) + 1; ++i) {
            path.addLast(i);
            dfs(n, k, i + 1, path, res);
            path.removeLast();
        }
    }*/

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(1, path, n, k, res);
        return res;
    }

    private void dfs(int start, List<Integer> path, int n, int k, List<List<Integer>> res) {
        if (path.size() + (n - start + 1) < k) {
            return;
        }

        if (path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }
        path.add(start);
        dfs(start + 1, path, n, k, res);
        path.remove(path.size() - 1);
        dfs(start + 1, path, n, k, res);
    }
}
