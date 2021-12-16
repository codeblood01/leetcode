//Given an integer array nums, in which exactly two elements appear only once an
//d all the other elements appear exactly twice. Find the two elements that appear
// only once. You can return the answer in any order. 
//
// You must write an algorithm that runs in linear runtime complexity and uses o
//nly constant extra space. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,1,3,2,5]
//Output: [3,5]
//Explanation:  [5, 3] is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: nums = [-1,0]
//Output: [-1,0]
// 
//
// Example 3: 
//
// 
//Input: nums = [0,1]
//Output: [1,0]
// 
//
// 
// Constraints: 
//
// 
// 2 <= nums.length <= 3 * 104 
// -231 <= nums[i] <= 231 - 1 
// Each integer in nums will appear twice, only two integers will appear once. 
// 
// Related Topics Array Bit Manipulation 
// 👍 3442 👎 175

package com.gourav.leetcode.june30days.leetcode.editor.en;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] singleNumber(int[] nums) {
        int XOR = 0; int count=0; int index=0; int rightMostSetIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            XOR=XOR^nums[i];
        }
        int temp = XOR;
        while ((temp & 1) != 1){
                rightMostSetIndex++;
                temp=temp>>1;
        }
        int right=0;int rightCounter=nums.length-1;
        while (count<nums.length){
            if(((nums[index]>>>rightMostSetIndex)&1)==1) {
                index++;
            }else {
                right=nums[rightCounter];
                nums[rightCounter]=nums[index];
                nums[index]=right;
                rightCounter--;
            }
            count++;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
        temp=0;
        for (int i = 0; i < index; i++) {
            temp=nums[i]^temp;
        }
        int[] result= {XOR^temp,temp};
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
