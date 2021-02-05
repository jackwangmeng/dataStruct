package com.wm.LeeCode.LeeCode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode.array
 * @date 2021/2/1 13:51
 */
public class LeeCode54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        int rows = matrix.length;
        int columns = matrix[0].length;

        int top = 0, bottom = rows - 1, left = 0, right = columns - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                    result.add(matrix[top][column]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    result.add(matrix[bottom][column]);
                }
                for (int row = bottom; row > top; row--) {
                    result.add(matrix[row][left]);
                }
            }

            left++;
            right--;
            top++;
            bottom--;
        }
        return result;
    }
}
