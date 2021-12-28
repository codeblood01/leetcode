//Given a non-empty array nums containing only positive integers, find if the ar
//ray can be partitioned into two subsets such that the sum of elements in both su
//bsets is equal. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,5,11,5]
//Output: true
//Explanation: The array can be partitioned as [1, 5, 5] and [11].
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,5]
//Output: false
//Explanation: The array cannot be partitioned into equal sum subsets.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
// Related Topics Array Dynamic Programming 
// 👍 6458 👎 107

package com.gourav.leetcode.june30days.leetcode.editor.en;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int i=0;i<nums.length;i++){
            totalSum+=nums[i];
        }
        if(totalSum%2!=0) return false;
        int halfSum = totalSum/2;
        boolean dp[][] = new boolean[nums.length+1][halfSum+1];
        for(int i =0; i<halfSum+1;i++){
            if(i<nums.length+1){
                dp[0][i] = false;
                dp[i][0] = true;
            }
            else{
                dp[0][i] = false;
            }
        }
        for(int i =1; i<nums.length+1; i++){
            for(int j=1; j<halfSum+1; j++){
                if(j-nums[i-1]>=0)
                    dp[i][j] = dp[i-1][j]||dp[i-1][j-nums[i-1]];
                else
                    dp[i][j]= dp[i-1][j];
            }
            if(dp[i][halfSum]==true) return true;
        }
        return dp[nums.length][halfSum];
    }
}

//leetcode submit region end(Prohibit modification and deletion)
