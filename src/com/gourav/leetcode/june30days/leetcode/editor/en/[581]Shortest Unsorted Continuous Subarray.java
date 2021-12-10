//Given an integer array nums, you need to find one continuous subarray that if 
//you only sort this subarray in ascending order, then the whole array will be sor
//ted in ascending order. 
//
// Return the shortest such subarray and output its length. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,6,4,8,10,9,15]
//Output: 5
//Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the 
//whole array sorted in ascending order.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,4]
//Output: 0
// 
//
// Example 3: 
//
// 
//Input: nums = [1]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 104 
// -105 <= nums[i] <= 105 
// 
//
// 
//Follow up: Can you solve it in O(n) time complexity? Related Topics Array Two 
//Pointers Stack Greedy Sorting Monotonic Stack 
// 👍 4572 👎 194

package com.gourav.leetcode.june30days.leetcode.editor.en;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findUnsortedSubarray(int[] nums) {
//        int result = 0;
//        int previous =nums[0];
//        int min =Integer.MAX_VALUE;
//        int max= Integer.MIN_VALUE;
//        int left = 0; int leftfinal=0;
//        int right = 0;
//        boolean flag=false;
//        for (int i = 1; i < nums.length; i++) {
//            if(nums[i]<previous|| flag==true){
//                if(flag==false) {
//                    left = i - 1;
//
//                }
//
//                flag=true;
//                if(nums[i]>previous) {
//                    flag = false;
//
//                    break;
//                }
//            }
//                previous = nums[i];
//
//        }
//        System.out.println(left+" "+right+" ");
//
//        leftfinal=left;
//         left = 0;
//         right = 0;
//         flag=false;
//         previous =nums[nums.length-1];
//
//        for (int i = nums.length-2; i >= 0; i--) {
//            if(nums[i]>previous|| flag==true){
//
//                if(flag==false) {
//                    right = i+1;
//                }
//                flag=true;
//                if(nums[i]<previous) {
//                    flag = false;
//
//                    System.out.println(left+" "+right+" +");
//                    break;
//
//                }
//            }
//            previous = nums[i];
//
//        }
//        for(int i = leftfinal ; i<=right;i++){
//            min=Math.min(min,nums[i]);
//            max=Math.max(max,nums[i]);
//        }
//        leftfinal= Arrays.binarySearch(nums,0,leftfinal+1,min)<0?Math.abs(Arrays.binarySearch(nums,0,leftfinal+1,min)+1):Arrays.binarySearch(nums,0,leftfinal+1,min);
//        right= Arrays.binarySearch(nums,right,nums.length,max)<0?Math.abs(Arrays.binarySearch(nums,right,nums.length,max)):Arrays.binarySearch(nums,right,nums.length,max);
//
//
//        System.out.println(min+" "+max+" "+leftfinal+" "+right+" "+Arrays.binarySearch(nums,0,leftfinal,min) +" "+Arrays.binarySearch(nums,right,nums.length,max));
//        if(left==right) return 0;
//        return right-leftfinal+1;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
