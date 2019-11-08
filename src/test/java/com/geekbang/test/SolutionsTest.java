package com.geekbang.test;

import com.geekbang.leetcode.Solutions;
import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Created by yuping on 2019/11/7.
 */
public class SolutionsTest extends TestCase{

    public void testRemoveDuplicate(){

        int nums[] = new int[]{1,1,2};
        Solutions solutions  = new Solutions();

        int len = solutions.removeDuplicates(nums);

        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]+" ");
        }
        Assert.assertEquals(2,len);
    }



    public void testMerge(){
        int nums1[] = new int[]{1,1,2,0,0,0};
        int nums2[] = new int[]{0,2,5};
        int result[] = new int[]{0,1,1,2,2,5};
        Solutions solutions = new Solutions();
        solutions.merge(nums1,3,nums2,3);
        org.junit.Assert.assertArrayEquals(nums1,result);
    }

}
