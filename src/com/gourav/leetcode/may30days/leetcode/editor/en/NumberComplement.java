import java.lang.Math;

//Given a positive integer, output its complement number. The complement strateg
//y is to flip the bits of its binary representation. 
//
// 
//
// Example 1: 
//
// 
//Input: 5
//Output: 2
//Explanation: The binary representation of 5 is 101 (no leading zero bits), and
// its complement is 010. So you need to output 2.
// 
//
// 
//
// Example 2: 
//
// 
//Input: 1
//Output: 0
//Explanation: The binary representation of 1 is 1 (no leading zero bits), and i
//ts complement is 0. So you need to output 0.
// 
//
// 
//
// Note: 
//
// 
// The given integer is guaranteed to fit within the range of a 32-bit signed in
//teger. 
// You could assume no leading zero bit in the integer’s binary representation. 
//
// This question is the same as 1009: https://leetcode.com/problems/complement-o
//f-base-10-integer/ 
// 
// Related Topics Bit Manipulation
	
package com.gourav.leetcode.may30days.leetcode.editor.en;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findComplement(int num) {
        int theBitMastk = 1; // num = 00001011 c = 00001111 result=c-num or c xor num
        while (theBitMastk< num){
                    theBitMastk =  (theBitMastk << 1)  | 1 ; // c pow 2 + 1 same
        }
        return theBitMastk ^ num ; // xor bitwise preferred over minus;

    }
}

// we could use bitwise operator ~num which returns compliment but it returns 2's compliment.
// link to bitwise operators.
/*int a = 60;	*//* 60 = 0011 1100 *//*
    int b = 13;	*//* 13 = 0000 1101 *//*
    int c = 0;

      c = a & b;        *//* 12 = 0000 1100 *//*
              System.out.println("a & b = " + c );

              c = a | b;        *//* 61 = 0011 1101 *//*
              System.out.println("a | b = " + c );

              c = a ^ b;        *//* 49 = 0011 0001 *//*
              System.out.println("a ^ b = " + c );

              c = ~a;           *//*-61 = 1100 0011 *//*
              System.out.println("~a = " + c );

              c = a << 2;       *//* 240 = 1111 0000 *//*
              System.out.println("a << 2 = " + c );

              c = a >> 2;       *//* 15 = 1111 *//*
              System.out.println("a >> 2  = " + c );

              c = a >>> 2;      *//* 15 = 0000 1111 *//*
              System.out.println("a >>> 2 = " + c );
              a & b = 12
a | b = 61
a ^ b = 49
~a = -61
a << 2 = 240
a >> 2  = 15
a >>> 2 = 15

              */
//leetcode submit region end(Prohibit modification and deletion)
	