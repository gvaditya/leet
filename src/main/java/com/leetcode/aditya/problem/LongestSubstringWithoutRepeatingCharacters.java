package com.leetcode.aditya.problem;

import java.util.*;

class LongestSubstringWithoutRepeatingCharacters{

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (!charSet.contains(s.charAt(right))) {
                charSet.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                while (charSet.contains(s.charAt(right))) {
                    charSet.remove(s.charAt(left));
                    left++;
                }
                charSet.add(s.charAt(right));
            }
        }

        return maxLength;
    }

    public static int lengthOfLongestSubstringOptimised(String s) {
        int n = s.length();
        int maxLength = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            System.out.println("left "+left+" right "+right+" charMap "+charMap.toString()+" maxlength "+maxLength);
            if (!charMap.containsKey(s.charAt(right)) || charMap.get(s.charAt(right))<left) {
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                left = charMap.get(s.charAt(right))+1;
            }
            charMap.put(s.charAt(right),right);
        }

        return maxLength;
    }

    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring("abcabcd"));
    }
}