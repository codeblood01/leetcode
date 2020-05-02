
//You're given strings J representing the types of stones that are jewels, and S
// representing the stones you have. Each character in S is a type of stone you ha
//ve. You want to know how many of the stones you have are also jewels. 
//
// The letters in J are guaranteed distinct, and all characters in J and S are l
//etters. Letters are case sensitive, so "a" is considered a different type of sto
//ne from "A". 
//
// Example 1: 
//
// 
//Input: J = "aA", S = "aAAbbbb"
//Output: 3
// 
//
// Example 2: 
//
// 
//Input: J = "z", S = "ZZ"
//Output: 0
// 
//
// Note: 
//
// 
// S and J will consist of letters and have length at most 50. 
// The characters in J are distinct. 
// 
// Related Topics Hash Table
	
package com.gourav.leetcode.may30days.leetcode.editor.en;


import java.util.HashMap;
import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numJewelsInStones(String J, String S) {

        HashSet<Character> map= new HashSet<>();
        for(int i=0; i< J.length();i++){
            map.add(J.charAt(i));
        }
        int result=0;
        for (int i = 0; i < S.length() ; i++) {
            if(map.contains(S.charAt(i)))
                    result+=1;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
	