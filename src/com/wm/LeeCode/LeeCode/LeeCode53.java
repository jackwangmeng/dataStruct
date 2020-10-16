package com.wm.LeeCode.LeeCode;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode
 * @date 2020/10/16 11:11
 */
public class LeeCode53 {
    public class Status{
        public int lSum, rSum, mSum, iSum;

        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }

    public int maxSubArray(int[] nums) {
        /*
        int pre = 0, maxAns = nums[0];
        for(int x : nums){
            pre = Math.max(x,pre + x);
            maxAns = Math.max(pre,maxAns);
        }
        return maxAns;
         */
        return getInfo(nums, 0, nums.length - 1).mSum;
    }

    public Status getInfo(int[] a, int l, int r) {
        if (l == r) {
            return new Status(a[l], a[l], a[l], a[l]);
        }
        int m = (l + r) >> 1;
        Status lSub = getInfo(a, l, m);
        Status rSub = getInfo(a, m + 1, r);
        return pushUp(lSub, rSub);
    }

    public Status pushUp(Status l, Status r) {
        int iSum = l.iSum + r.iSum;
        int lSum = Math.max(l.lSum, l.iSum + r.lSum);
        int rSum = Math.max(r.rSum, r.iSum + l.rSum);
        int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
        return new Status(lSum, rSum, mSum, iSum);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,-1,-4,5,2,5,6,-4};
        System.out.println(new LeeCode53().maxSubArray(nums));
    }
}
