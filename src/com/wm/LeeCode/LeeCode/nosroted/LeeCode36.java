package com.wm.LeeCode.LeeCode.nosroted;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode
 * @date 2020/10/19 18:02
 */
public class LeeCode36 {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++){
            int hori = 0, veti = 0, sqre = 0;
            for (int j = 0; j < 9; j++){
                int h = board[i][j] - 48;
                int v = board[j][i] - 48;
                int s = board[3 * (i / 3) + j / 3][3 * (i % 3) + j % 3] -48;
                if (h > 0){
                    hori = sodokuer(h , hori);
                }
                if(v > 0){
                    veti = sodokuer(v, veti);
                }
                if(s > 0){
                    sqre = sodokuer(s, sqre);
                }
                if(hori == -1 || veti == -1 || sqre == -1){
                    return false;
                }
            }
        }
        return true;
    }

    private int sodokuer(int n, int val) {
        return ((val >> n) & 1) == 1 ? -1 : val ^ (1 << n);
    }
}
