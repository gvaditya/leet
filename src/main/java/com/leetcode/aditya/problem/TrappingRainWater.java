package com.leetcode.aditya.problem;

import java.util.Arrays;
class TrappingRainWater{
    public static int trap(int[] height) {
        int n = height.length;
        int[] left = new int [n];
        int[] right = new int [n];
        Arrays.fill(left,-1);
        Arrays.fill(right,-1);
        left[0]=height[0];
        for (int i = 1; i < n; i++) {
            int current = height[i];
            left[i] = Math.max(current,left[i-1]);
        }
        right[n-1] = height[n-1];
        for (int i = n-2; i >=0 ; i--) {
            int current = height[i];
            right[i] = Math.max(current,right[i+1]);
        }
        int total = 0;
        for (int i = 0; i < n; i++) {
            int border = Math.min(left[i],right[i]);
            int current = height[i];
            if(border>current){
                total+= border- current;
            }
        }
        return total;
    }

    public static int trapOptimised(int[] height){
        int n = height.length, leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE, left =0, right = n-1, ans = 0;
        while (left<right){
            leftMax= Math.max(leftMax,height[left]);
            rightMax = Math.max(rightMax,height[right]);
            System.out.println("leftMax "+leftMax+" rightMax "+rightMax+" left "+left+" right "+right+" ans "+ans);
            if(leftMax<rightMax) {
                ans+= leftMax-height[left++];
            } else {
                ans+= rightMax - height[right--];
            }
        }
        return ans;
    }
    public static void main(String[] args){
        System.out.println(trapOptimised(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}