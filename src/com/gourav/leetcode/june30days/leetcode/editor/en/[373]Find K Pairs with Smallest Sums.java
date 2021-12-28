//You are given two integer arrays nums1 and nums2 sorted in ascending order and
// an integer k. 
//
// Define a pair (u, v) which consists of one element from the first array and o
//ne element from the second array. 
//
// Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums. 
//
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
//Output: [[1,2],[1,4],[1,6]]
//Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,
//6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
// 
//
// Example 2: 
//
// 
//Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
//Output: [[1,1],[1,1]]
//Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,
//2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
// 
//
// Example 3: 
//
// 
//Input: nums1 = [1,2], nums2 = [3], k = 3
//Output: [[1,3],[2,3]]
//Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums1.length, nums2.length <= 105 
// -109 <= nums1[i], nums2[i] <= 109 
// nums1 and nums2 both are sorted in ascending order. 
// 1 <= k <= 1000 
// 
// Related Topics Array Heap (Priority Queue) 
// 👍 2640 👎 157

package com.gourav.leetcode.june30days.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int x = nums1.length<k?nums1.length:k;
        int y = nums2.length<k?nums2.length:k;
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<PairSum> maxHeap = new PriorityQueue<>((a, b)-> Integer.compare(b.sum,a.sum));
        for(int i = 0; i<x; i++){
            for(int j = 0; j< y; j++){
                maxHeap.add(new PairSum(nums1[i], nums2[j], nums1[i]+nums2[j]));
                if(maxHeap.size()>k)
                    maxHeap.poll();
            }
        }
        while(!maxHeap.isEmpty()){
            PairSum temp = maxHeap.poll();
            List<Integer> resultPair = new ArrayList<>();
            resultPair.add(temp.first);
            resultPair.add(temp.second);
            result.add(resultPair);
        }
        return result;
    }
}
class PairSum{
    int first;
    int second;
    int sum;
    public PairSum(int first, int second, int sum){
        this.first = first;
        this.second = second;
        this.sum = sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
