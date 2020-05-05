
//
//Given a string, find the first non-repeating character in it and return it's i
//ndex. If it doesn't exist, return -1.
// 
// Examples:
// 
//s = "leetcode"
//return 0.
//
//s = "loveleetcode",
//return 2.
// 
// 
//
// 
//Note: You may assume the string contain only lowercase letters.
// Related Topics Hash Table String
	
package com.gourav.leetcode.may30days.leetcode.editor.en;

import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstUniqChar(String s) {
        boolean arr[]=new boolean[26];
        Set<Character> set= new HashSet<Character>();
        char stringToChar[]= s.toCharArray();
        for(int i=0; i< stringToChar.length; i++ ){
            if(set.add(stringToChar[i])){
                arr[stringToChar[i]-97]=true;
            }else{
                arr[stringToChar[i]-97]=false;
            }
        }
        for (int i = 0; i < stringToChar.length; i++) {
            if (arr[stringToChar[i]-97])
                    return i;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
	