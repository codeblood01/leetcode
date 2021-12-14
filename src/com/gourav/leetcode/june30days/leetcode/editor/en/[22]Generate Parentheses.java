//Given n pairs of parentheses, write a function to generate all combinations of
// well-formed parentheses. 
//
// 
// Example 1: 
// Input: n = 3
//Output: ["((()))","(()())","(())()","()(())","()()()"]
// Example 2: 
// Input: n = 1
//Output: ["()"]
// 
// 
// Constraints: 
//
// 
// 1 <= n <= 8 
// 
// Related Topics String Dynamic Programming Backtracking 
// 👍 10709 👎 420

package com.gourav.leetcode.june30days.leetcode.editor.en;
//leetcode submit region begin(Prohibit modification and deletion)
import java.util.*;

class Solution {
    List<String> result = new ArrayList<>();
    StringBuilder answerSoFar = new StringBuilder();
    public List<String> generateParenthesis(int n) {
        myGenerator(0, 0, n);
        return result;
    }
    public void myGenerator(int open, int close, int n){

        if (open == n){
            int closeTemp = close;
            StringBuilder temp = new StringBuilder(answerSoFar);
            while (open>closeTemp){
                temp.append(')');
                closeTemp++;
            }
            //System.out.println(temp);
            result.add(new String(temp));
            if(answerSoFar.length()>0) {
                if (answerSoFar.charAt(answerSoFar.length() - 1) == '(') open = open - 1;
                else close = close - 1;
                answerSoFar.deleteCharAt(answerSoFar.length() - 1);
            }
            return;
        }

        if (open < n){
                if (open > close){
                answerSoFar.append('(');
                myGenerator(open+1,close,n);
                answerSoFar.append(')');
                myGenerator(open, close+1, n);
                }else{
                    answerSoFar.append('(');
                    myGenerator(open+1 , close, n);
                }
            }
        if(answerSoFar.length()>0) {
            if (answerSoFar.charAt(answerSoFar.length() - 1) == '(') open = open - 1;
            else close = close - 1;
            answerSoFar.deleteCharAt(answerSoFar.length() - 1);
        }
        return;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
