package com.wm.interviewing;
import java.util.Arrays;

public class RegionTest {
    public int eraseOverlapIntervals(int[][] intervals) {
        //数组长度
        int length = intervals.length;
        //边界条件处理
        if (length == 0){ return 0; }
        //没有重叠区间的个数
        int noOverlayCount = 0;
        //当前int[,]中最大值，用于连续性判断
        int currentBoundMax = Integer.MIN_VALUE;
        //返回结果
        int result = 0;
        //对集合按照数组中最大值进行排序
        Arrays.sort(intervals, (t0, t1) -> t0[1] - t1[1]);
        //遍历整个区间集合中的每个数组
        for(int[] currentNumArr : intervals){
            //判断其与上一个数据的关系
            if(currentNumArr[0] >= currentBoundMax){
                noOverlayCount++;
                currentBoundMax = currentNumArr[1];
                System.out.println(Arrays.toString(currentNumArr));
            }
        }
        result = length - noOverlayCount;
        return result;
    }
    public static void main(String[] args) {
        int[][] intervals = { {1,2},{2, 3},{3,4}, {1,3} };
        System.out.println(new RegionTest().eraseOverlapIntervals(intervals));
    }
}
