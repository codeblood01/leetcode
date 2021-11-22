//Given two strings s1 and s2, return true if s2 contains a permutation of s1, o
//r false otherwise. 
//
// In other words, return true if one of s1's permutations is the substring of s
//2. 
//
// 
// Example 1: 
//
// 
//Input: s1 = "ab", s2 = "eidbaooo"
//Output: true
//Explanation: s2 contains one permutation of s1 ("ba").
// 
//
// Example 2: 
//
// 
//Input: s1 = "ab", s2 = "eidboaoo"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= s1.length, s2.length <= 104 
// s1 and s2 consist of lowercase English letters. 
// 
// Related Topics Hash Table Two Pointers String Sliding Window 
// 👍 3638 👎 97

package com.gourav.leetcode.june30days.leetcode.editor.en;

import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s2, String s1) {

        HashMap<Character,Integer> countMap = countMap(s2);
        int windowStart = 0;
        int windowEnd=0;
        for (int i = 0; i < s1.length() ; i++) {
            windowEnd= i;
            if (countMap.containsKey(s1.charAt(i))){
                if (countMap.get(s1.charAt(i))>=1)
                    countMap.put(s1.charAt(i),countMap.get(s1.charAt(i))-1);
                else{
                    while (countMap.get(s1.charAt(i))<1&& windowStart!=windowEnd){
                        countMap.put(s1.charAt(windowStart),countMap.get(s1.charAt(windowStart))+1);
                        windowStart++;
                    }
                    countMap.put(s1.charAt(i),countMap.get(s1.charAt(i))-1);
                }
            }
            else {
                while (windowStart!= windowEnd){
                    countMap.put(s1.charAt(windowStart),countMap.get(s1.charAt(windowStart))+1);
                    windowStart++;
                }
                windowStart++;

            }

            System.out.println(windowStart+" "+" "+windowEnd+" "+countMap);
            if (windowEnd - windowStart + 1 == s2.length())
                return true;
        }
        return false;
    }

    public HashMap<Character, Integer> countMap(String s2){
        HashMap<Character,Integer> countMap = new HashMap<Character, Integer>();
        for (int i = 0; i < s2.length() ; i++) {
            if(!countMap.containsKey(s2.charAt(i))){
                countMap.put(s2.charAt(i),1);
            }
            else{
                countMap.put(s2.charAt(i),countMap.get(s2.charAt(i))+1);
            }
        }
        return countMap;
    }
        

}
//leetcode submit region end(Prohibit modification and deletion)
