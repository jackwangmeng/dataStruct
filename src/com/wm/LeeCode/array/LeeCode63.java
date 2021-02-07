package com.wm.LeeCode.array;

/**
 * @author wm
 * @Package com.wm.LeeCode.array
 * @date 2021/2/4 16:23
 */
public class LeeCode63 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int rows = obstacleGrid.length, columns = obstacleGrid[0].length;
        int[] f = new int[columns];

        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }
        return f[columns - 1];
    }

    public static void main(String[] args) {
        int[][] temp = {{0,0,0,0,0},{0,0,0,0,0},{0,0,1,0,0},{0,0,0,0,0},{0,0,0,0,0}};
        System.out.println(LeeCode63.uniquePathsWithObstacles(temp));
    }
}
