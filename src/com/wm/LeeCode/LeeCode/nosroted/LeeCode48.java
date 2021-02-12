package com.wm.LeeCode.LeeCode.nosroted;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode
 * @date 2021/1/26 16:56
 */
public class LeeCode48 {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        int temp ;
        //水平轴翻转
        for (int i = 0; i < length / 2; ++i) {
            for (int j = 0; j < length; ++j) {
                System.out.print(matrix[i][j]+ " ,");
                temp = matrix[i][j];
                matrix[i][j] = matrix[length - 1 - i][j];
                matrix[length - 1 - i][j] = temp;
            }
            System.out.println();
        }
        //主对角线翻转
        for (int i = 0; i < length; ++i) {
            for (int j = 0; j < i; ++j) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
                System.out.print(matrix[i][j] + " ,");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        LeeCode48 leeCode48 = new LeeCode48();
        leeCode48.rotate(matrix);
    }
}
