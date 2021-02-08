package com.wm.LeeCode.LeeCode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode.array
 * @date 2021/2/8 10:03
 */
public class LeeCode73 {
    /*int[][] ans;
    public void setZeroes(int[][] matrix) {

        int rows = matrix.length, columns = matrix[0].length;
         ans = new int[rows][columns];
        //深拷贝待查询数据集，初始化结果集
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                ans[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                if (matrix[i][j] == 0) {
                    setZeroRow(rows, j, ans);
                    setZeroCol(i, columns, ans);
                }
            }
        }

        for (int i = 0; i < rows; ++i) {
            matrix[i] = Arrays.copyOf(ans[i], rows);
            System.out.println(matrix[i].toString());
        }
    }
    //设置行为空
    private void setZeroRow(int rows, int col, int[][] ans) {
        for (int i = 0; i < rows; ++i) {
            ans[i][col] = 0;
        }
    }

    private void setZeroCol(int row, int columns, int[][] ans) {
        for (int i = 0; i < columns; ++i) {
            ans[row][i] = 0;
        }
    }*/

    public void setZeroes(int[][] matrix) {

        int rows = matrix.length, columns = matrix[0].length;
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                if (row.contains(i) || col.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        new LeeCode73().setZeroes(matrix);
    }
}
