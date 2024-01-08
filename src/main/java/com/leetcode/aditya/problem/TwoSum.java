package com.leetcode.aditya.problem;//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//You can return the answer in any order.
// https://leetcode.com/problems/two-sum

import java.util.*;

class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]+nums[j] == target){
                    // reached target value
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }

    public static int[] twoSumOptimised(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(numToIndex.containsKey(target - nums[i])) {
                return new int[]{numToIndex.get(target-nums[i]), i };
            }
            numToIndex.put(nums[i],i);
        }
        return new int[]{};
    }

    public static void main(String args[]){
        int[] response = twoSumOptimised(new int[]{3,3}, 6);
        if(response.length == 0)
            System.out.println("No pair");
        else
            System.out.println(response[0]+" "+response[1]);
    }
}