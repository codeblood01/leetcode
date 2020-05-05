
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

//setimport java.sql.Array;
import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstUniqChar(String s) {
        boolean arr[]=new boolean[26];
        List<BitSet> set= new ArrayList<BitSet>();
        char stringToChar[]= s.toCharArray();
        for(int i=0; i < 26;i++){
            BitSet initial = new BitSet(2);
            set.add(initial);
        }

        for(int i=0; i< stringToChar.length; i++ ){
            if(!set.get(stringToChar[i]-97).get(0)&&!set.get(stringToChar[i]-97).get(1)){
                set.get(stringToChar[i]-97).flip(1);
            }else if (!set.get(stringToChar[i]-97).get(0)&&set.get(stringToChar[i]-97).get(1)){
                set.get(stringToChar[i]-97).flip(0);
            }
        }
        for (int i = 0; i < stringToChar.length; i++) {
            if (!set.get(stringToChar[i]-97).get(0)&&set.get(stringToChar[i]-97).get(1))
                return i;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
//above is more efficient then this
//removed set usage as we need to check wether a element comes first time, or doesnt came at all or came more than two times(represnt three states, 2 bits required), so we can use arraylist of bitset  ?
//public int firstUniqChar(String s) {
//    boolean arr[]=new boolean[26];
//    Set<Character> set= new HashSet<Character>();
//    char stringToChar[]= s.toCharArray();
//    for(int i=0; i< stringToChar.length; i++ ){
//        if(set.add(stringToChar[i])){
//            arr[stringToChar[i]-97]=true;
//        }else{
//            arr[stringToChar[i]-97]=false;
//        }
//    }
//    for (int i = 0; i < stringToChar.length; i++) {
//        if (arr[stringToChar[i]-97])
//            return i;
//    }
//    return -1;
//}