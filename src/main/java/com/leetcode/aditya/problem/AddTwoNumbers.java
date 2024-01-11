package com.leetcode.aditya.problem;

import java.util.List;

/*
* You are given two non-empty linked lists representing two non-negative integers.
* The digits are stored in reverse order, and each of their nodes contains a single digit.
* Add the two numbers and return the sum as a linked list.
* You may assume the two numbers do not contain any leading zero, except the number 0 itself.
* https://leetcode.com/problems/add-two-numbers/
* */
class AddTwoNumbers{
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            if(next != null){
                return val +" -> "+ next;
            } else{
                return ""+val;
            }
        }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode response = new ListNode();
        ListNode currentNode = response;
        while (l1 != null || l2 != null || carry!=0){
            int sum ;
            if(l1 != null && l2 != null){
                int val1 = l1.val;
                int val2 = l2.val;
                sum = val2+ val1 +carry;
                if(sum>=10){
                    carry = sum/10;
                } else {
                    carry =0;
                }
                l1 = l1.next;
                l2 = l2.next;
                currentNode.val = sum% 10;

            } else if(l1 != null){
                sum = l1.val + carry;
                if(sum>=10){
                    carry = sum/10;
                }else {
                    carry =0;
                }
                l1 = l1.next;
                currentNode.val = sum% 10;
            } else if(l2 != null){
                sum = l2.val + carry;
                if(sum>=10){
                    carry = sum/10;
                }else {
                    carry =0;
                }
                l2 = l2.next;
                currentNode.val = sum% 10;
            } else{
                currentNode.val = carry;
                carry =0;
            }
            if(l1!= null || l2 != null || carry != 0){
                currentNode.next = new ListNode();
                currentNode = currentNode.next;
            }
        }
        return response;
    }
    public static ListNode addTwoNumbersOptimised(ListNode l1, ListNode l2){
        int carry = 0;
        ListNode response = new ListNode();
        ListNode currentNode = response;
        while (l1 != null || l2 != null || carry!=0){
            int digit1 = (l1 != null) ? l1.val :0;
            int digit2 = (l2 != null) ? l2.val :0;
            int sum = digit1 + digit2 + carry;
            int digit = sum % 10;
            carry = sum/ 10;
            currentNode.next = new ListNode(digit);
            currentNode = currentNode.next;

            l1 = (l1 != null)? l1.next :null;
            l2 = (l2 != null)? l2.next:null;
        }
        return response.next;
    }
    public static void main(String[] args){
        ListNode l1 = new ListNode(9, new ListNode(9,new ListNode(9,new ListNode(9))));
        ListNode l2 = new ListNode(9, new ListNode(9,new ListNode(9)));
        System.out.println(addTwoNumbersOptimised(l1,l2));

    }
     
}