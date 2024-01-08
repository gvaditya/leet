package com.leetcode.aditya.problem;

//Given an integer array nums, find the
//subarray with the largest sum, and return its sum.
class MaximumSubArray{
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for(int i=0;i<n;i++){
            currentSum = Math.max(nums[i],currentSum + nums[i]);
            maxSum = Math.max(currentSum,maxSum);
        }
        return maxSum;
    }
    public static void main(String[] args){
        int response = maxSubArray(new int[]{5,4,-1,7,8});
        System.out.println(response);
    }
}