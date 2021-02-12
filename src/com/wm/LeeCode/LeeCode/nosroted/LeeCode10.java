package com.wm.LeeCode.LeeCode.nosroted;


enum Result {
    TRUE, FALSE
}
public class LeeCode10 {
    Result[][] memory;
    public boolean isMatch(String s, String p) {
        memory = new Result[s.length() + 1][p.length() + 1];
        return dependent(0, 0, s, p);
    }

    private boolean dependent(int i, int i1, String s, String p) {
        if (memory[i][i1] != null){
            return memory[i][i1] == Result.TRUE;
        }
        boolean ans;
        if (i1 == p.length()){
            ans = i == s.length();
        } else {
            boolean first_match = (i < s.length() &&
                    (p.charAt(i1) == s.charAt(i) || p.charAt(i1) == '.'));

            if (i1 + 1 <p.length() && p.charAt(i1 + 1) == '*'){
                ans = (dependent( i , i1 + 2, s, p) ||
                        first_match && dependent(i + 1 , i1 ,s,p));
            }else {
                ans = first_match && dependent(i + 1,i1 + 1,s,p);
            }
        }
        memory[i][i1] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LeeCode10().isMatch("abaa","abaaaa"));
    }
}
