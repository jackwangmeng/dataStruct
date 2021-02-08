package com.wm.LeeCode.LeeCode.array;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode.array
 * @date 2021/2/8 10:57
 */
public class LeeCode74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int curruentNum = matrix[0][0];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] >= curruentNum) {
                    if ( matrix[i][j] < target) {
                        curruentNum = matrix[i][j];
                    } else if (matrix[i][j] == target) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
