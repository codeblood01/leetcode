//Given a string s, find the length of the longest substring without repeating c
//haracters. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
// 
//
// Example 2: 
//
// 
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// Example 3: 
//
// 
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a 
//substring.
// 
//
// Example 4: 
//
// 
//Input: s = ""
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 104 
// s consists of English letters, digits, symbols and spaces. 
// 
// Related Topics Hash Table String Sliding Window 
// 👍 19344 👎 887

package com.gourav.leetcode.june30days.leetcode.editor.en;
//leetcode submit region begin(Prohibit modification and deletion)
import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
            int result =1;
            int left=0;
            if(s.length()<=1) return s.length();

            int arr[]=new int[200];
                 for (int i = 0; i <200 ; i++) {
                     arr[i] = Integer.MIN_VALUE;
                 }
                    arr[s.charAt(0)- 30]=0;
            for(int i=1;i<s.length();i++){
                System.out.println(left + " "+ i);
                        if(arr[s.charAt(i)- 30]==Integer.MIN_VALUE || arr[s.charAt(i)- 30] < left){
                            arr[s.charAt(i)- 30]=i;
                            result=Math.max(result,i-left+1);
                        }
                        else{

                            left=arr[s.charAt(i) - 30]+1;
                            arr[s.charAt(i)- 30]=i;
                        }
            }

           // if(left==0) return s.length();
            return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
