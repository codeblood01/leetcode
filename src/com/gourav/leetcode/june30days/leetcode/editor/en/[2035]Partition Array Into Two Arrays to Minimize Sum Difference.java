//You are given an integer array nums of 2 * n integers. You need to partition n
//ums into two arrays of length n to minimize the absolute difference of the sums 
//of the arrays. To partition nums, put each element of nums into one of the two a
//rrays. 
//
// Return the minimum possible absolute difference. 
//
// 
// Example 1: 
//
// 
//Input: nums = [3,9,7,3]
//Output: 2
//Explanation: One optimal partition is: [3,9] and [7,3].
//The absolute difference between the sums of the arrays is abs((3 + 9) - (7 + 3
//)) = 2.
// 
//
// Example 2: 
//
// 
//Input: nums = [-36,36]
//Output: 72
//Explanation: One optimal partition is: [-36] and [36].
//The absolute difference between the sums of the arrays is abs((-36) - (36)) = 
//72.
// 
//
// Example 3: 
//
// 
//Input: nums = [2,-1,0,4,-2,-9]
//Output: 0
//Explanation: One optimal partition is: [2,4,-9] and [-1,0,-2].
//The absolute difference between the sums of the arrays is abs((2 + 4 + -9) - (
//-1 + 0 + -2)) = 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 15 
// nums.length == 2 * n 
// -107 <= nums[i] <= 107 
// 
// Related Topics Array Two Pointers Binary Search Dynamic Programming Bit Manip
//ulation Ordered Set Bitmask 
// 👍 278 👎 13

package com.gourav.leetcode.june30days.leetcode.editor.en;
//leetcode submit region begin(Prohibit modification and deletion)
/*

PATTERN DYNAMIC PROGRAMMING

Given a set of positive integers S, partition it into two subsets, S1 and S2, such that the difference between the sum of elements in S1 and S2 is mininum. The solution should return the minimum absolute difference between the sum of elements of two partitions.

Input: S = [10, 20, 15, 5, 25]
Output: 5
Explanation: S can be partitioned into two partitions [[10, 20, 5], [15, 25]] where the minimum absolute difference between the sum of elements is 5. Note that this solution is not unique. Another solution is [[10, 25], [20, 15, 5]].

Input: []
Output: 0

*/

class Solution
{
    public static int findMinAbsDiff(int[] S)
    {
        int nums[] = S;
        long sum = 0;
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.abs(nums[0]-nums[1]);
        for(int i=0; i< nums.length ; i++) sum+=nums[i];

        int halfSum = (int)Math.abs(sum/2);
        boolean dp[][] = new boolean[nums.length+1][halfSum+1];
        for(int i = 0 ; i< halfSum ; i++){
            if(i<=nums.length){
                dp[0][i]= false;
                dp[i][0]= true;
            }else{
                dp[0][i] = false;
            }
        }
        dp[0][0] = true;

        for(int i = 1 ; i<= nums.length; i++){
            for(int j=1; j<= halfSum; j++){
                if(j-nums[i-1]>=0){
                    dp[i][j] = dp[i-1][j]|| dp[i-1][j-nums[i-1]];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        for(int i = halfSum; ; i--){
            if(dp[nums.length][i]==true){
                System.out.println(i +" "+sum);
                int first = i;
                int second = (int)sum -i;

                if(first>second)
                    return first-second;
                else
                    return second - first;
            }
        }
    }
}

//leetcode submit region end(Prohibit modification and deletion)
