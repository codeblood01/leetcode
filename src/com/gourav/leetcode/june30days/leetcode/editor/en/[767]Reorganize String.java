//Given a string s, rearrange the characters of s so that any two adjacent chara
//cters are not the same. 
//
// Return any possible rearrangement of s or return "" if not possible. 
//
// 
// Example 1: 
// Input: s = "aab"
//Output: "aba"
// Example 2: 
// Input: s = "aaab"
//Output: ""
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 500 
// s consists of lowercase English letters. 
// 
// Related Topics Hash Table String Greedy Sorting Heap (Priority Queue) Countin
//g 
// 👍 3907 👎 165

package com.gourav.leetcode.june30days.leetcode.editor.en;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reorganizeString(String s) {
        //System.out.println("asdf");
        LinkedList<Character> result = new LinkedList<Character>();
        HashMap<Character,Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>((a,b)-> Integer.compare(b.getValue(),a.getValue()));
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) map.put(s.charAt(i),map.get(s.charAt(i))+1);
            else map.put(s.charAt(i),1);
        }
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            pq.add(entry);
            //System.out.println(entry.getKey()+"==="+entry.getValue());
        }

        Map.Entry<Character,Integer> first = pq.poll();
        int temp = first.getValue();
        int maxCharLength = temp;
        boolean firstSequence=false;
        if(pq.isEmpty()&&temp>1) return "";
        while (temp>0){
            result.add(first.getKey());
            temp--;
        }
        int count=1;
        while (!pq.isEmpty()){
            if (pq.peek().getValue()>result.size()+1) return "";
            else {
                temp=pq.peek().getValue();
                if(firstSequence==true)
                count=0;
                while (temp>0){
                    if(count>=result.size()) result.addLast(pq.peek().getKey());
                    else
                    result.add(count,pq.peek().getKey());
                    count+=2;
                    temp--;
                    if (result.size()>=maxCharLength+maxCharLength-1&&firstSequence==false){
                        count=0;
                        firstSequence=true;
                    }
                }
               // System.out.println(result+"===========");
                pq.poll();
            }
        }if (firstSequence==false) return "";
        String str = new String();
        for (Character c : result){
            System.out.println();
            str=str+c;
        }
        return str;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
