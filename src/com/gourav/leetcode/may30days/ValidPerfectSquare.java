
//Given a positive integer num, write a function which returns True if num is a 
//perfect square else False. 
//
// Note: Do not use any built-in library function such as sqrt. 
//
// Example 1: 
//
// 
// 
//Input: 16
//Output: true
// 
//
// 
// Example 2: 
//
// 
//Input: 14
//Output: false
// 
// 
// Related Topics Math Binary Search
	
package com.gourav.leetcode.may30days;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPerfectSquare(int num) {
        if(num<2)
                return true;
        long end = num / 2 ;
        long start=1;
        long mid=start+(end - start)/2;
        long square;
        while (start<=end){
            mid = start+(end - start)/2;
            square=mid*mid;
            if(num == square)
                    return true;
            else if(num>square)
                    start=mid+1;
            else if(num<square)
                    end = mid-1;

        }
        return false;
    }
    //using binary search among 1 to n/2 numbers, if there are many of such queries its better to prepare a hashset of perfect squares
}
//leetcode submit region end(Prohibit modification and deletion)
	