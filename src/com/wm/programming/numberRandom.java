package com.wm.programming;

import java.util.Iterator;
import java.util.TreeSet;

public class numberRandom {

    /*用1,2 , 2 ,3, 4 ,5 这6 个数字, 用Java 写一个main 函数, 打印出所有不同的排列, 如:
512234, 412345 等, 要求: “4”不能在第三位, “3”与”5”不能相连。*/
    String[] stra = {"1","2","3","4","5","6"};
    int strLen = stra.length;
    boolean[] visited = new boolean[strLen];
    String result = "";
    TreeSet<String> ts = new TreeSet<String>();
    int[][] morry = new int[strLen][strLen];
    private void searchMap(){
        for (int i = 0; i < strLen; i++){
            for (int j = 0; j < strLen; j++){
                if (i == j){
                    morry[i][j] = 0;
                }else {
                    morry[i][j] = 1;
                }
            }
        }
        morry[3][5] = 0;
        morry[5][3] = 0;
        for (int i = 0; i < strLen; i++){
            search(i);
        }
        Iterator<String> it = ts.iterator();
        while (it.hasNext()){
            String str = it.next();
            if (str.indexOf("4") != 2){
                System.out.println(str);
            }
        }
    }

    private void search(int startIndex) {
        visited[startIndex] = true;
        result = result + stra[startIndex];
        if (result.length() == strLen){
            ts.add(result);
        }
        for (int j = 0; j < strLen; j++){
            if (morry[startIndex][j] == 1 && visited[j] == false){
                search(j);
            }else {
                continue;
            }
        }
        result = result.substring(0,result.length() - 1);
        visited[startIndex] = false;
    }
    public static void main(String[] args) {
        new numberRandom().searchMap();
    }
}
