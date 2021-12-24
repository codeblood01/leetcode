//Given an m x n matrix, return true if the matrix is Toeplitz. Otherwise, retur
//n false. 
//
// A matrix is Toeplitz if every diagonal from top-left to bottom-right has the 
//same elements. 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
//Output: true
//Explanation:
//In the above grid, the diagonals are:
//"[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
//In each diagonal all elements are the same, so the answer is True.
// 
//
// Example 2: 
//
// 
//Input: matrix = [[1,2],[2,2]]
//Output: false
//Explanation:
//The diagonal "[1, 2]" has different elements.
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 20 
// 0 <= matrix[i][j] <= 99 
// 
//
// 
// Follow up: 
//
// 
// What if the matrix is stored on disk, and the memory is limited such that you
// can only load at most one row of the matrix into the memory at once? 
// What if the matrix is so large that you can only load up a partial row into t
//he memory at once? 
// 
// Related Topics Array Matrix 
// 👍 1711 👎 113

package com.gourav.leetcode.june30days.leetcode.editor.en;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reorganizeString(String s,int k ) {
        //System.out.println("asdf");
        LinkedList<Character> result = new LinkedList<Character>();
        HashMap<Character,Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>((a, b)-> Integer.compare(b.getValue(),a.getValue()));
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
                    count+=k;
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
