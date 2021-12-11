//Given a collection of numbers, nums, that might contain duplicates, return all
// possible unique permutations in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,2]
//Output:
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics Array Backtracking 
// 👍 4057 👎 87

package com.gourav.leetcode.june30days.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> arraySoFar = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
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
            boolean a=containsAlready(result,arraySoFar)?true:result.add(new ArrayList<>(arraySoFar));
            arraySoFar.remove(arraySoFar.size()-1);
            return;
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

    }
    public boolean containsAlready(List<List<Integer>> res, List<Integer> checkMe){
        for (int i = 0; i < res.size(); i++) {
            List<Integer> temp = res.get(i);int size = 0;
            for (int j = 0; j < temp.size(); j++) {
                size++;
                if (!temp.get(j).equals(checkMe.get(j)))
                     break;
            }
            if (size == temp.size())
                    return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
