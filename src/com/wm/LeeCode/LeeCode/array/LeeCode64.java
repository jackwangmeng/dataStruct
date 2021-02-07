package com.wm.LeeCode.LeeCode.array;


import java.util.Arrays;

public class LeeCode64 {
    private int minPathSum = Integer.MAX_VALUE;
    private int[][] dirs = {{1, 0}, {0, 1}};
    /*public int minPathSum(int[][] grid) {
        *//*int rows = grid.length, columns = grid[0].length;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                } else if (j == 0) {
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                } else {
                    grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + grid[i][j];
                }
            }
        }
        return grid[rows - 1][columns - 1];*//*
        dfs(grid, 0, 0, grid[0][0]);
        return minPathSum;
    }

    private void dfs(int[][] grid, int row, int col, int sum) {
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            minPathSum = Math.min(minPathSum, sum);
            return;
        }

        for (int[] dir : dirs) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            if (nextRow < 0 || nextCol < 0
            || nextRow >= grid.length || nextCol >= grid[0].length) continue;

            sum += grid[nextRow][nextCol];
            dfs(grid, nextRow, nextCol, sum);
            sum -= grid[nextRow][nextCol];
        }
    }*/


    /*public int minPathSum(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; ++i) {
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }
        return dfs(grid, 0, 0, memo);
    }

    private int dfs(int[][] grid, int row, int col, int[][] memo) {
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return grid[row][col];
        }

        for (int[] dir : dirs) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];

            if (nextRow < 0 || nextCol < 0
                    || nextRow >= grid.length
                    || nextCol >= grid[0].length) continue;

            int childMinPathSum = dfs(grid, row, col, memo);
            minPathSum = Math.min(minPathSum, childMinPathSum);
        }
        memo[row][col] = minPathSum + grid[row][col];
        return memo[row][col];
    }*/

    /*public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp= new int[rows][cols];
        dp[rows - 1][cols - 1] = grid[rows - 1][cols - 1];

        for (int i = rows - 1; i >= 0; --i) {
            for (int j = cols - 1; j >= 0; --j) {
                if (i == rows - 1 && j != cols - 1) {
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                } else if (j == cols - 1 && i != rows - 1) {
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j+1]) + grid[i][j];
                }
            }
        }
        return dp[0][0];
    }*/

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 状态定义：dp[i] 表示从 (0, 0) 到达第 i - 1 行的最短路径值
        int[] dp = new int[n];

        // 状态初始化
        dp[0] = grid[0][0];

        // 状态转移
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n ; j++) {
                if (i == 0 && j != 0) {
                    dp[j] = grid[i][j] + dp[j - 1];
                } else if (i != 0 && j == 0) {
                    dp[j] = grid[i][j] + dp[j];
                } else if (i != 0 && j != 0) {
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);
                }
            }
        }

        // 返回结果
        return dp[n - 1];
    }
}
