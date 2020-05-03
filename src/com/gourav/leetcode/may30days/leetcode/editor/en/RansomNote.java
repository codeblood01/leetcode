
//
//Given an arbitrary ransom note string and another string containing letters fr
//om all the magazines, write a function that will return true if the ransom 
//note can be constructed from the magazines ; otherwise, it will return false. 
//
// 
// 
//Each letter in the magazine string can only be used once in your ransom note.
// 
//
// Note: 
//You may assume that both strings contain only lowercase letters.
// 
//
// 
//canConstruct("a", "b") -> false
//canConstruct("aa", "ab") -> false
//canConstruct("aa", "aab") -> true
// 
// Related Topics String
	
package com.gourav.leetcode.may30days.leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        char magazineChar[]= magazine.toCharArray();
        char ransomChar[]= ransomNote.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < magazineChar.length ; i++) {
            if(map.containsKey(magazineChar[i]))
                    map.put(magazineChar[i],map.get(magazineChar[i]+1));
            else
                    map.put(magazineChar[i],1);
        }
        for (int i = 0; i < ransomChar.length; i++) {
            if (map.containsKey(ransomChar[i])&& map.get(ransomChar[i])>=1){
                map.put(magazineChar[i],map.get(magazineChar[i])+1);
            }else
            {
                return false;
            }
        }
        return true;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
	