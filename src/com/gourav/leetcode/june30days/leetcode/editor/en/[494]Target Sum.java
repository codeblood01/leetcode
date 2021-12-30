//You are given an integer array nums and an integer target. 
//
// You want to build an expression out of nums by adding one of the symbols '+' 
//and '-' before each integer in nums and then concatenate all the integers. 
//
// 
// For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 
//and concatenate them to build the expression "+2-1". 
// 
//
// Return the number of different expressions that you can build, which evaluate
//s to target. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,1,1,1], target = 3
//Output: 5
//Explanation: There are 5 ways to assign symbols to make the sum of nums be tar
//get 3.
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// Example 2: 
//
// 
//Input: nums = [1], target = 1
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
// Related Topics Array Dynamic Programming Backtracking 
// 👍 5774 👎 226

package com.gourav.leetcode.june30days.leetcode.editor.en;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        if(nums.length==1) {
            if(nums[0] == target || nums[0] == 0-target) return 1;
            else return 0;
        } if(nums.length == 0){
            if(target ==0) return 1;
            else return 0;
        }
        Arrays.sort(nums);
        int sum = 0;
        int zeroCount = 0;
        for(int i =0; i<nums.length; i++) {
            sum+=nums[i];
            if(nums[i]==0) zeroCount++;
        }
        if(sum == target) return 1<<zeroCount;
        if(sum<target) return 0;
        if((sum-target)%2!=0) return 0;
        int findTarget = (sum-target)/2;
        int dp[][] = new int[nums.length+1][sum+1];
        for(int i=0; i<= sum; i++){
            dp[0][i]=0;
        }
        for(int i=0;i<=nums.length;i++) dp[i][0] =1;
        dp[0][0] = 1;

        for(int i=1; i<= nums.length; i++){
            //System.out.print(dp[i][0]+"===");
            for(int j=1; j<= sum; j++){
                if(j-nums[i-1]>=0){
                    dp[i][j] = (dp[i-1][j]+dp[i-1][j-nums[i-1]]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
                System.out.print(dp[i][j]+"===");

            }
            System.out.println("______________________");
        }
        return dp[nums.length][findTarget]*(1<<zeroCount);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
