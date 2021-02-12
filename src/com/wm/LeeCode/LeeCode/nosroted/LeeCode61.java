package com.wm.LeeCode.LeeCode.nosroted;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode
 * @date 2021/2/2 14:24
 */
public class LeeCode61 {
    public int uniquePaths(int m, int n) {
        int nums;
        int[][] record = new int[m][n];
        for (int i = 0; i < m; ++i) {
            record[i][0] = 1;
        }
        for (int i = 0; i < n; ++i) {
            record[0][i] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                record[i][j] = record[j - 1][j] + record[i][j - 1];
            }
        }
        return record[m - 1][n - 1];
    }
}
