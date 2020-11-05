package com.wm.LeeCode.LeeCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode
 * @date 2020/11/5 14:23
 */
public class LeeCode40 {
    public List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0){
            return result;
        }
        Arrays.sort(candidates);
        comSum2(candidates,target,0,new LinkedList<Integer>());
        return result;
    }

    private void comSum2(int[] candidates, int target, int index, LinkedList<Integer> trace) {
        if (target == 0){
            result.add(new LinkedList<>(trace));
            return ;
        }

        if (target > 0){
            for (int i = index; i < candidates.length; i++){
                if (i > index && candidates[i] == candidates[i - 1])
                    continue;

                trace.add(candidates[i]);
                comSum2(candidates,target- candidates[i],i+1,trace);
                trace.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        int[] testData = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(new LeeCode40().combinationSum2(testData,target));
    }
}
