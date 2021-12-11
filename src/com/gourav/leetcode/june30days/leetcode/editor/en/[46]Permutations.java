//Given an array nums of distinct integers, return all the possible permutations
//. You can return the answer in any order. 
//
// 
// Example 1: 
// Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// Example 2: 
// Input: nums = [0,1]
//Output: [[0,1],[1,0]]
// Example 3: 
// Input: nums = [1]
//Output: [[1]]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// All the integers of nums are unique. 
// 
// Related Topics Array Backtracking 
// 👍 8234 👎 160

package com.gourav.leetcode.june30days.leetcode.editor.en;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> arraySoFar = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
            //List<Integer> arraySoFar = new ArrayList<>();
            List<Integer> tempe = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            tempe.add(nums[i]);
        }
            letMePermute( tempe, tempe.size());

        return result;
    }

    public void letMePermute(List<Integer> nums, int size){
      //  System.out.println(nums+" -------------  "+arraySoFar);
        if(arraySoFar.size()==size){
            result.add(new ArrayList<>(arraySoFar));
           // arraySoFar.remove(arraySoFar.size()-1);
           // return;
        }
        for (int i = 0; i < nums.size(); i++) {
            arraySoFar.add(nums.get(i));
            List<Integer> temp = new ArrayList<>();
            temp.addAll(nums.subList(0,i));
            temp.addAll(nums.subList(i+1,nums.size()));
            letMePermute(temp,size);
           // System.out.println(nums+" ###########  "+arraySoFar);
        }
        if(arraySoFar.size()>0)
        arraySoFar.remove(arraySoFar.size()-1);
        return;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
