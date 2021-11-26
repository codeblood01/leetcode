//Given an array nums of n integers, return an array of all the unique quadruple
//ts [nums[a], nums[b], nums[c], nums[d]] such that: 
//
// 
// 0 <= a, b, c, d < n 
// a, b, c, and d are distinct. 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// You may return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,0,-1,0,-2,2], target = 0
//Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// Example 2: 
//
// 
//Input: nums = [2,2,2,2,2], target = 8
//Output: [[2,2,2,2]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 200 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 
// Related Topics Array Two Pointers Sorting 
// 👍 4824 👎 580

package com.gourav.leetcode.june30days.leetcode.editor.en;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int tempSum=0;
        boolean arr[]= new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                tempSum=nums[i]+nums[j];
                HashMap<Integer,Integer> otherPair = checkPairSum(nums,i,j,target-tempSum,arr);
                boolean flag=true;
                if (!otherPair.isEmpty()){
                    for (Map.Entry<Integer,Integer> mapEntry:otherPair.entrySet()) {
                        List<Integer> tempList = new ArrayList<Integer>() ;
                        tempList.add(mapEntry.getKey());
                        tempList.add(mapEntry.getValue());
                        tempList.add(nums[i]);
                        tempList.add((nums[j]));
                        flag=false;
                        for (int k = 0; k < result.size(); k++) {
                            List<Integer> list1= result.get(k);
                            flag=checkEqualList(list1,tempList);
                           // System.out.println(" "+flag+" "+(checkEqualList(list1,tempList)));
                            if(flag==true){
                                break;
                            }
                        }
                        if(flag==false)
                            result.add(tempList);
                    }
                }

            }

        }

        return result;
    }

    public HashMap<Integer,Integer> checkPairSum(int[] numsArr , int i , int j, int sum, boolean arr[]){
        HashSet<Integer> hashSet = new HashSet<Integer>();
        HashMap<Integer,Integer> otherPair = new HashMap<Integer, Integer>();
        int nums[]=new int[numsArr.length-2];
        for (int k = 0; k < numsArr.length ; k++) {
            if(k<i){
                nums[k]=numsArr[k];
            }
            if(k>i&&k<j){
                nums[k-1]=numsArr[k];
            }
            if(k>i&&k>j){
                nums[k-2]=numsArr[k];
            }
        }
        for (int k = 0; k < nums.length; k++) {
            if (!hashSet.contains(nums[k])){
                hashSet.add(sum-nums[k]);
            }else {
                if(!otherPair.containsKey(nums[k])&&!otherPair.containsKey(sum-nums[k])){

                    otherPair.put(nums[k],sum-nums[k]);
                    //System.out.println(nums[k]+" "+(sum-nums[k])+" "+sum);
                }
            }
        }

        return otherPair;

    }

    public boolean checkEqualList(List<Integer> list1,List<Integer> list2){
        Collections.sort(list1);
        Collections.sort(list2);
        //System.out.println("list1  "+list1+" list2  "+list2);
        for(int i = 0; i<list1.size();i++){
            if(list1.get(i).longValue()!=list2.get(i).longValue()) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
