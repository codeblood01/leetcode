//The complement of an integer is the integer you get when you flip all the 0's 
//to 1's and all the 1's to 0's in its binary representation. 
//
// 
// For example, The integer 5 is "101" in binary and its complement is "010" whi
//ch is the integer 2. 
// 
//
// Given an integer n, return its complement. 
//
// 
// Example 1: 
//
// 
//Input: n = 5
//Output: 2
//Explanation: 5 is "101" in binary, with complement "010" in binary, which is 2
// in base-10.
// 
//
// Example 2: 
//
// 
//Input: n = 7
//Output: 0
//Explanation: 7 is "111" in binary, with complement "000" in binary, which is 0
// in base-10.
// 
//
// Example 3: 
//
// 
//Input: n = 10
//Output: 5
//Explanation: 10 is "1010" in binary, with complement "0101" in binary, which i
//s 5 in base-10.
// 
//
// 
// Constraints: 
//
// 
// 0 <= n < 109 
// 
//
// 
// Note: This question is the same as 476: https://leetcode.com/problems/number-
//complement/ 
// Related Topics Bit Manipulation 
// 👍 605 👎 51

package com.gourav.leetcode.june30days.leetcode.editor.en;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int bitwiseComplement(int n) {
        if(n==0) return 1;
        int result =0;int mul=1;
        while (n>0){
            result+=mul*(n%2^1);
            mul*=2;
            n=n/2;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
