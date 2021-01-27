package com.example.k8s.demo.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tempNode = new ListNode(0);
        ListNode res = tempNode;
        int temp1 = 0;
        while (l1 != null || l2 != null || temp1 != 0) {
            int tmp1 = l1 == null ? 0 : l1.val;
            int tmp2 = l2 == null ? 0 : l2.val;
            int temp = tmp1 + tmp2 + temp1;
            tempNode.next = new ListNode(temp % 10);
            temp1 = temp / 10;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
            tempNode = tempNode.next;

        }
        return res.next;
    }


    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<String> cset = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if (!cset.contains(s.substring(j, j + 1))) {
                    cset.add(s.substring(j, j + 1));
                    maxLength = cset.size() > maxLength ? cset.size() : maxLength;
                } else {
                    break;
                }
            }
        }
        return maxLength;
    }


    public static int lengthOfLongestSubstring1(String s) {
        int maxLength = 0;
        int startIndex = 0, endIndex = 0;
        Set<Character> cset = new HashSet<>();
        while (startIndex <= endIndex && endIndex < s.length()) {
            if (!cset.contains(s.charAt(endIndex))) {
                cset.add(s.charAt(endIndex));
                endIndex++;
                maxLength = maxLength >= cset.size() ? maxLength : cset.size();
            } else {
                cset.remove(s.charAt(startIndex));
                startIndex++;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(2);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
//
//        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);
//
//        addTwoNumbers(l1, l2);

        int pwwkew = lengthOfLongestSubstring1("pwwkew");
        System.out.println(pwwkew);
    }


    static class ListNode {
        int      val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
