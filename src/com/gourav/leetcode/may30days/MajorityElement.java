
//Given an array of size n, find the majority element. The majority element is t
//he element that appears more than ⌊ n/2 ⌋ times. 
//
// You may assume that the array is non-empty and the majority element always ex
//ist in the array. 
//
// Example 1: 
//
// 
//Input: [3,2,3]
//Output: 3 
//
// Example 2: 
//
// 
//Input: [2,2,1,1,1,2,2]
//Output: 2
// 
// Related Topics Array Divide and Conquer Bit Manipulation
	
package com.gourav.leetcode.may30days;

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        // as we know that it is must that our array contains atleast one number
        // which comes more than n/2 times. means atleast n+1 times
        // we can use this property 1 0 | 1 0 | 1 0 | 1
        // if one got cancelled imediatly by next element, it will come again atleast
        // one time
        int count = 1;
        int max = nums[0]; // assume no. at 0th index is max
        // start iterating from 0th index
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == max) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    max = nums[i];
                    count = 1;
                }
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
// we can use the boyer moore's voting election algorithm
//using map below
//int result= nums.length/2;
//    int temp= Integer.MIN_VALUE;
//    Map<Integer,Integer> map= new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//        if(map.containsKey(nums[i])){
//        map.put(nums[i],map.get(nums[i])+1);
//        temp=map.get(nums[i]);
//        if(temp>=result)
//        return nums[i];
//        }else
//        {
//        map.put(nums[i],1);
//        temp=map.get(nums[i]);
//        if(temp>=result)
//        return nums[i];
//
//        }
//        }
//        return result;
//        }