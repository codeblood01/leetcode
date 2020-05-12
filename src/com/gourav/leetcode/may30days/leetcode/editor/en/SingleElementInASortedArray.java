
//You are given a sorted array consisting of only integers where every element a
//ppears exactly twice, except for one element which appears exactly once. Find th
//is single element that appears only once. 
//
// 
//
// Example 1: 
//
// 
//Input: [1,1,2,3,3,4,4,8,8]
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: [3,3,7,7,10,11,11]
//Output: 10
// 
//
// 
//
// Note: Your solution should run in O(log n) time and O(1) space. 
//
	
package com.gourav.leetcode.may30days.leetcode.editor.en;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int mid=left+(right-left)/2;
        while (left<right){
            mid=left+(right-left)/2;
            System.out.println(nums[mid]);
            if(nums[mid]==nums[mid+1]){
                if(mid%2!=0)
                    right=mid-1;
                else
                    left=mid;

            }
            else if(nums[mid]==nums[mid-1]){
                if(mid%2!=0)
                    left=mid+1;
                else
                    right=mid;

            }

            else
                return nums[mid];
        }
        return nums[left];
    }
}
}
// we could have used XOR operation here for O(1) space complexity to beat HashMap usage complexity still is O(n)
// but we need to solve it in log(n)
// lets observe the property
// exaclty one element single time
// rest are in pair... doesnt it mean array length with always be of odd length.
// lets take a expample to beat it in log(n) by using sorted property of array
// 1 1 3 3 5 // break it intro half -> at index 2 element is 3 and its partner is at right side,
// does not that mean that the number alone without having a partner will be in right side also,
// as the numbers in left are already even in numbers and they have to be having there partners(remember the fact that we have only a single number having no partner)
// hope you got the idea what we need to do, deciding which division of mid belongs to and figuring out where the alone guy lies --- simple binary search
// hurrayyy we beat it in log(n) and constant space.
 /// leetcode submit region end(Prohibit modification and deletion)
	