package com.wm.LeeCode.LeeCode.stack.simple;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode.stack.simple
 * @date 2020/11/6 17:19
 */
public class LeeCode1598 {
    public int minOperations(String[] logs) {
        int count = 0;
        for (int i = 0; i < logs.length; i++){

            if (logs[i].equals("../")){
                if (count > 0){
                    count--;
                }
            }else if((!logs[i].equals("./"))){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] str = {"./","../","./"};
        System.out.println(new LeeCode1598().minOperations(str));
    }
}
