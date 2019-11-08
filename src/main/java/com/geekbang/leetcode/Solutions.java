package com.geekbang.leetcode;

import java.util.Arrays;

/**
 * Created by yuping on 2019/11/7.
 */
public class Solutions {

    public int removeDuplicates(int[] nums) {
        if(nums==null || nums.length == 1){
            return nums.length;
        }
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[i]!=nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }


    public void rotate(int[] nums, int k) {
        int numLen = nums.length;
        k = k%numLen;
        int count = 0;
        for(int start=0;count<nums.length;start++){
            int current = start;
            int prev = nums[start];
            do{
                int next = (current+k)%numLen;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            }while(start!=current);
        }
    }


    /**
     * Definition for singly-linked list.
     *
     * */
      public class ListNode {
           int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        ListNode l3 = new ListNode(0);
        if(l1==null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode t = l3;
        while(p!=null || q!=null){
            if(p!=null && q!=null){
                if(p.val<q.val){
                    t.next = new ListNode(p.val);
                    t = t.next;
                    p = p.next;
                }else{
                    t.next = new ListNode(q.val);
                    t = t.next;
                    q = q.next;
                }
            }else{
                if(p!=null){
                    t.next = new ListNode(p.val);
                    p = p.next;
                    t = t.next;
                }

                if(q!=null){
                    t.next = new ListNode(q.val);
                    q = q.next;
                    t = t.next;
                }
            }
        }
        return l3.next;
    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m - 1;
        int len2 = n - 1;
        int len = m + n - 1;
        while(len1 >= 0 && len2 >= 0) {
            // 注意--符号在后面，表示先进行计算再减1，这种缩写缩短了代码
            nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
        }
        // 表示将nums2数组从下标0位置开始，拷贝到nums1数组中，从下标0位置开始，长度为len2+1
        System.arraycopy(nums2, 0, nums1, 0, len2 + 1);
    }
}
