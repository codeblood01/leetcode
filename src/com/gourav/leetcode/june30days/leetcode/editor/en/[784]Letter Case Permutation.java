//Given a string s, we can transform every letter individually to be lowercase o
//r uppercase to create another string. 
//
// Return a list of all possible strings we could create. You can return the out
//put in any order. 
//
// 
// Example 1: 
//
// 
//Input: s = "a1b2"
//Output: ["a1b2","a1B2","A1b2","A1B2"]
// 
//
// Example 2: 
//
// 
//Input: s = "3z4"
//Output: ["3z4","3Z4"]
// 
//
// Example 3: 
//
// 
//Input: s = "12345"
//Output: ["12345"]
// 
//
// Example 4: 
//
// 
//Input: s = "0"
//Output: ["0"]
// 
//
// 
// Constraints: 
//
// 
// s will be a string with length between 1 and 12. 
// s will consist only of letters or digits. 
// 
// Related Topics String Backtracking Bit Manipulation 
// 👍 2737 👎 130

package com.gourav.leetcode.june30days.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> result = new ArrayList<>();
    StringBuilder answerSoFar=new StringBuilder();
    int length=0;
    public List<String> letterCasePermutation(String s) {
        permuteTheCases(s, s.length());
        return result;
    }

    public void permuteTheCases(String str, int size){
            if (str.length()==0){
                result.add(new String(answerSoFar));
                answerSoFar.deleteCharAt(answerSoFar.length()-1);
                return;
            }
            if(str.charAt(0)>=48&& str.charAt(0)<=57){
                answerSoFar.append(str.charAt(0));
                permuteTheCases(new String(str.substring(1)), size);
            }else{
                answerSoFar.append(Character.toUpperCase(str.charAt(0)));
                permuteTheCases(new String(str.substring(1)), size);
                answerSoFar.append(Character.toLowerCase(str.charAt(0)));
                permuteTheCases(new String(str.substring(1)), size);
            }
            if(answerSoFar.length()>0)
                answerSoFar.deleteCharAt(answerSoFar.length()-1);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
