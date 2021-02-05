package com.wm.LeeCode.LeeCode.array;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode.array
 * @date 2021/2/1 15:12
 */
public class LeeCode59 {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int top = 0, bottom = n - 1, left = 0, right = n - 1, currentNum = 1, target = n * n;
        while (currentNum <= target) {
            for (int column = left; column <= right; column++) {
                result[top][column]= currentNum++;
            }
            top++;
            for (int row = top; row <= bottom; row++) {
                result[row][right] = currentNum++;
            }
            right--;
                for (int column = right; column >= left; column--) {
                    result[bottom][column] = currentNum++;
                }
                bottom--;
                for (int row = bottom; row >= top; row--) {
                    result[row][left] = currentNum++;
                }
                left++;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new LeeCode59().generateMatrix(n));
    }
}
