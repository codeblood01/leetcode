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

class grokingtopkproblemeleven {
    public static long sumBetweenTwoKth(long A[], long N, long K1, long K2)
    {
        // Your code goes here
        long k = Math.max(K1, K2);
        PriorityQueue<Long> pq= new PriorityQueue<>(Collections.reverseOrder());
        for(int i =0; i< A.length; i++){
            pq.add(A[i]);
            if(pq.size()>k) pq.poll();
        }
        //System.out.println(pq);
        pq.poll();K2--;
        long result = 0;
        while(K2!=K1){
            result+=pq.peek();
            pq.poll();
            K2--;
        }


        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
