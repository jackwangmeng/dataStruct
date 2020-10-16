package com.wm.LeeCode.LeeCode;

import java.util.ArrayList;
import java.util.List;

public class LeeCode06 {
        public String convert(String s, int numRows) {
            /*if (numRows == 1){
                return s;
            }

            List<StringBuilder> rows = new ArrayList<>();
            System.out.println("11111111");
            for (int i = 0;i < Math.min(numRows,s.length());i++){
                rows.add(new StringBuilder());
                System.out.println(rows);
            }

            int curRow = 0;
            boolean godingDown = false;

            System.out.println("2222222222");
            for (char c : s.toCharArray()){
                rows.get(curRow).append(c);
                if (curRow == 0 || curRow == numRows - 1){
                    godingDown = !godingDown;
                    curRow += godingDown ? 1 : -1;
                }
                System.out.println(rows);
            }

            StringBuilder ret = new StringBuilder();
            for (StringBuilder row : rows){
                ret.append(row);
            }
            return ret.toString();*/
            /*if (numRows == 1){
                return s;
            }
            StringBuilder ret = new StringBuilder();
            int n = s.length();
            int cycleLen = 2 * numRows - 2;

            for (int i = 0;i < numRows; i++){
                for (int j = 0;j + i < n;j +=cycleLen){
                    if (i!=0 && i!=numRows-1 && j+cycleLen - i<n){
                        ret.append(s.charAt(j + cycleLen - i));

                    }
                }

            }

            return ret.toString();
        }*/

            if(numRows < 2) return s;
            List<StringBuilder> rows = new ArrayList<>();
            for(int i = 0; i < numRows; i++)
                rows.add(new StringBuilder());
            int i = 0, flag = -1;
            for(char c : s.toCharArray()) {
                rows.get(i).append(c);
                if(i == 0 || i == numRows -1) flag = - flag;
                i += flag;
            }
            StringBuilder res = new StringBuilder();
            for(StringBuilder row : rows) res.append(row);
            return res.toString();
        }

    public static void main(String[] args) {
        LeeCode06 leeCode06 = new LeeCode06();
        leeCode06.convert("LEETCODEISHIRING",3);
    }
}
